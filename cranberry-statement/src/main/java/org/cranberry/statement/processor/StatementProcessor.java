package org.cranberry.statement.processor;

import com.sun.source.tree.Tree;
import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.Trees;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.JCTree.JCExpression;
import com.sun.tools.javac.tree.JCTree.JCMethodDecl;
import com.sun.tools.javac.tree.JCTree.JCStatement;
import com.sun.tools.javac.tree.JCTree.JCVariableDecl;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.List;
import org.cranberry.commons.handler.EnterCompilationHandler;
import org.cranberry.commons.scanner.VariableCompilationTreeScanner;
import org.cranberry.commons.util.TypeUtil;
import org.cranberry.statement.annotation.NotBlank;
import org.cranberry.statement.annotation.NotEmpty;
import org.cranberry.statement.annotation.NotNull;
import org.cranberry.statement.annotation.True;
import org.cranberry.statement.internal.util.Statements;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * The type State processor.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class StatementProcessor extends AbstractProcessor {

    /**
     * The constant SUPPORTED_ANNOTATIONS.
     */
    public static final Set<Class> SUPPORTED_ANNOTATIONS = new HashSet<Class>(){{
        add(NotNull.class);
        add(NotEmpty.class);
        add(NotBlank.class);
        add(True.class);
    }};

    private JavacProcessingEnvironment javacProcessingEnv;

    private TreeMaker maker;

    private Messager messager;

    private JavacElements utils;

    private Types types;

    private Trees parser;

    private JavacTask task;

    private VariableCompilationTreeScanner scanner;

    private TypeUtil typeUtil;



    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return SUPPORTED_ANNOTATIONS.stream()
                .map(eachAnnotation -> eachAnnotation.getCanonicalName())
                .collect(Collectors.toSet());
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        this.parser = Trees.instance(processingEnvironment);
        this.task = JavacTask.instance(processingEnvironment);
        this.scanner = new VariableCompilationTreeScanner(this.parser);
        this.scanner.setFilter(
                (VariableElement element) ->
                        SUPPORTED_ANNOTATIONS.stream()
                                .map(eachAnnotation -> element.getAnnotation(eachAnnotation) != null)
                                .filter(b -> b != false)
                                .findAny()
                                .orElse(false)
        );

        EnterCompilationHandler tListener = new EnterCompilationHandler();
        tListener.setFinishHandling(
                (Object event) -> {
                    this.scanner.scan(((TaskEvent) event).getCompilationUnit());
                }
        );
        this.task.addTaskListener(tListener);

        this.javacProcessingEnv = (JavacProcessingEnvironment) processingEnvironment;
        this.maker = TreeMaker.instance(javacProcessingEnv.getContext());
        this.messager = processingEnvironment.getMessager();
        this.utils = javacProcessingEnv.getElementUtils();
        this.types = processingEnv.getTypeUtils();
        this.parser = Trees.instance(this.javacProcessingEnv);
        this.typeUtil = new TypeUtil(types, utils);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment processingEnvironment) {
        this.scanner.getElements().stream()
                .forEach(element -> {
                    for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
                        for (Class processingAnnotation : SUPPORTED_ANNOTATIONS) {
                            if (!this.typeUtil.isSame(annotationMirror.getAnnotationType(),
                                    this.typeUtil.getType(processingAnnotation)))
                                continue;

                            if (this.typeUtil.isSame(this.typeUtil.getType(processingAnnotation),
                                    this.typeUtil.getType(NotBlank.class))
                            && !this.checkTypeForNoBlankAnnotation(element)) {
                                this.messager.printMessage(
                                        Diagnostic.Kind.ERROR,
                                        "@NotBlank could be applied to a String type only " + element.toString()
                                        );
                            } else if (this.typeUtil.isSame(this.typeUtil.getType(processingAnnotation),
                                    this.typeUtil.getType(NotEmpty.class))
                            && !this.checkTypeForNoEmptyAnnotation(element)) {
                                this.messager.printMessage(
                                        Diagnostic.Kind.ERROR,
                                        "@NotEmpty could be applied to an Arrays, a String, a Collection or a Map types only "
                                                + element.toString()
                                );
                            } else if (this.typeUtil.isSame(this.typeUtil.getType(processingAnnotation),
                                    this.typeUtil.getType(True.class))
                            && !this.checkTypeForTrueAnnotation(element)) {
                                this.messager.printMessage(
                                        Diagnostic.Kind.ERROR,
                                        "@True could be applied to an Boolean types only "
                                                + element.toString()
                                );
                            }

                            injectStatementsCall(element, annotationMirror);
                        }
                    }
                });

        return true;
    }

    private boolean checkTypeForTrueAnnotation(Element element) {
        return this.typeUtil.isSame(element.asType(), this.typeUtil.getType(Boolean.class));
    }

    private boolean checkTypeForNoEmptyAnnotation(Element element) {
        return this.typeUtil.isMap(element.asType())
                || this.typeUtil.isCollection(element.asType())
                || this.typeUtil.isArray(element.asType())
                || this.typeUtil.isSame(element.asType(), this.typeUtil.getType(String.class));
    }

    private boolean checkTypeForNoBlankAnnotation(Element element) {
        return this.typeUtil.isSame(element.asType(), this.typeUtil.getType(String.class));
    }

    /**
     * Inject statements call.
     *
     * @param currentElement   the current element
     * @param annotationMirror the annotation mirror
     */
    public void injectStatementsCall(Element currentElement, AnnotationMirror annotationMirror) {

        if (currentElement == null || annotationMirror == null)
            return;

        JCTree currentNode;
        if ((currentNode = utils.getTree(currentElement)) == null)
            return;

        Element parentElement;
        if ((parentElement = currentElement.getEnclosingElement()) != null) {
            JCTree parentNode = utils.getTree(parentElement);

            JCStatement statement = this.getMethodExecutionStatement(currentNode, annotationMirror);

            ((JCMethodDecl) parentNode).body.stats = this.injectStatementIntoBody(
                    ((JCMethodDecl) parentNode).body.stats,
                    List.of(statement),
                    currentElement);
        }
    }

    private JCStatement getMethodExecutionStatement(JCTree currentNode, AnnotationMirror annotationMirror) {
        JCExpression stateExpression = this.getMethodExecutionExpression(String.format(
                "%s.state%s",
                Statements.class.getCanonicalName(),
                annotationMirror.getAnnotationType().asElement().getSimpleName()
        ));

        List<JCExpression> stateParams = List.nil();
        stateParams = stateParams.append(maker.Ident(((JCVariableDecl) currentNode).name));

        String message = null;
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> annotationEnElementValue :
                annotationMirror.getElementValues().entrySet()) {

            if (annotationEnElementValue.getKey().toString() == "message") continue;

            message = String.valueOf(annotationEnElementValue.getValue().getValue());
            stateParams = stateParams.append(maker.Literal(message));
        }

        JCStatement statement = maker.Exec(maker.Apply(
                List.<JCExpression>nil(),
                stateExpression,
                stateParams)
        );

        return statement;
    }

    private JCExpression getMethodExecutionExpression(String expressionString) {
        List<String> statementParts = List.from(expressionString.split("\\."));
        JCExpression expression = maker.Ident(utils.getName(statementParts.get(0)));

        for (int i = 1; i < statementParts.size(); i++) {
            expression = maker.Select(expression, utils.getName(statementParts.get(i)));
        }

        return expression;
    }

    private List<JCStatement> injectStatementIntoBody(List<JCStatement> source, List<JCStatement> injection, Element currentElement) {

        if (source.isEmpty()) return injection;

        if (injection.isEmpty() || source.containsAll(injection)) return source;

        List<JCStatement> statements = List.nil();

        for (JCStatement statement : source.reverse()) {
            if (currentElement.getKind() == ElementKind.LOCAL_VARIABLE
                    && statement.getKind() == Tree.Kind.VARIABLE
                    && ((JCVariableDecl) statement).name.equals(((JCVariableDecl) this.utils.getTree(currentElement)).name))
                statements = statements.prependList(injection);

            statements = statements.prepend(statement);

            if (currentElement.getKind() == ElementKind.PARAMETER
                    && statement.equals(source.get(0)))
                statements = statements.prependList(injection);
        }

        return statements;
    }
}