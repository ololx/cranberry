package org.cranberry.logging.processor;

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
import org.cranberry.commons.scanner.MethodCompilationTreeScanner;
import org.cranberry.commons.util.TypeUtil;
import org.cranberry.logging.annotation.LogParam;
import org.cranberry.logging.wrapper.LoggerWrapper;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.*;
import javax.lang.model.util.Types;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * The type State processor.
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class LoggingProcessor extends AbstractProcessor {

    /**
     * The constant SUPPORTED_ANNOTATIONS.
     */
    public static final Set<Class> SUPPORTED_ANNOTATIONS = new HashSet<Class>(){{
        add(LogParam.class);
    }};

    private JavacProcessingEnvironment javacProcessingEnv;

    private TreeMaker maker;

    private Messager messager;

    private JavacElements utils;

    private Types types;

    private Trees parser;

    private JavacTask task;

    private MethodCompilationTreeScanner scanner;

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
        this.scanner = new MethodCompilationTreeScanner(this.parser);
        this.scanner.setFilter(
                (element) ->
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

                            injectStatementsCall(element, annotationMirror);
                        }
                    }
                });

        return true;
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

            List<JCStatement> statement = this.getMethodExecutionStatements(parentElement, currentNode, annotationMirror);

            ((JCMethodDecl) currentNode).body.stats = this.injectStatementIntoBody(
                    ((JCMethodDecl) currentNode).body.stats,
                    statement
            );
        }
    }

    private List<JCStatement> getMethodExecutionStatements(Element parentNode, JCTree currentNode, AnnotationMirror annotationMirror) {
        final List<JCVariableDecl> params = ((JCMethodDecl) currentNode).params;

        List<JCStatement> statements = List.nil();
        for (JCVariableDecl param : params) {
            statements = statements.append(this.getMethodExecutionStatement(parentNode, currentNode, annotationMirror, param));
        }

        return statements;
    }

    private JCStatement getMethodExecutionStatement(Element parentNode,
                                                    JCTree currentNode,
                                                    AnnotationMirror annotationMirror,
                                                    JCVariableDecl param) {
        final List<JCVariableDecl> params = ((JCMethodDecl) currentNode).params;
        JCExpression loggerGetExpression = this.getMethodExecutionExpression(String.format(
                "%s.getInstance",
                LoggerWrapper.class.getCanonicalName()
        ));

        List<JCExpression> loggerGetArgs = List.nil();
        loggerGetArgs = loggerGetArgs.append(maker.Literal(parentNode.toString()));

        JCExpression loggerGet = maker.Apply(List.<JCExpression>nil(), loggerGetExpression, loggerGetArgs);
        loggerGet = maker.Select(loggerGet, utils.getName("info"));

        String message = null;
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> annotationEnElementValue :
                annotationMirror.getElementValues().entrySet()) {

            if (annotationEnElementValue.getKey().toString() == "message")
                continue;

            message = String.valueOf(annotationEnElementValue.getValue().getValue());
        }

        JCExpression mainFormatExpression = this.getMethodExecutionExpression("String.format");

        List<JCExpression> mainFormatArgs = List.nil();
        mainFormatArgs = mainFormatArgs.append(maker.Literal(message != null ? "%s %s" : "%s = %s"));
        mainFormatArgs = mainFormatArgs.append(maker.Literal(message != null ? message : param.getName().toString()));
        mainFormatArgs = mainFormatArgs.append(maker.Ident(param.name));

        JCExpression format = maker.Apply(List.<JCExpression>nil(), mainFormatExpression, mainFormatArgs);

        List<JCExpression> printlnArgs = List.nil();
        printlnArgs = printlnArgs.append(format);
        printlnArgs = printlnArgs.append(maker.Literal(((JCMethodDecl) currentNode).getName().toString()));

        JCStatement statement = maker.Exec(maker.Apply(List.<JCExpression>nil(), loggerGet, printlnArgs)
        );

        System.err.println(statement);

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

    private List<JCStatement> injectStatementIntoBody(List<JCStatement> source, List<JCStatement> injection) {

        if (source.isEmpty())
            return injection;

        if (injection.isEmpty() || source.containsAll(injection))
            return source;

        List<JCStatement> statements = List.nil();
        statements = statements.appendList(injection);
        statements = statements.appendList(source);

        return statements;
    }
}