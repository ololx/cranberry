/**
 * Copyright 2022 the project cranberry authors
 * and the original author or authors annotated by {@author}
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ololx.cranberry.statement.processing;

import com.sun.source.tree.Tree;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sun.source.util.Trees;
import com.sun.tools.javac.model.JavacElements;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.Names;
import io.github.ololx.cranberry.commons.scanner.VariableCompilationTreeScanner;
import io.github.ololx.cranberry.commons.utils.TypeUtil;
import io.github.ololx.cranberry.statement.annotation.NotBlank;
import io.github.ololx.cranberry.statement.annotation.NotEmpty;
import io.github.ololx.cranberry.statement.annotation.True;
import io.github.ololx.cranberry.statement.internal.util.Statements;

import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.sun.source.util.TaskEvent.Kind.ANNOTATION_PROCESSING_ROUND;
import static com.sun.source.util.TaskEvent.Kind.ENTER;

/**
 * project cranberry
 * created 2022-01-09 13:07
 *
 * @author Alexander A. Kropotin
 */
final class CranberryStatementTaskListener implements TaskListener {

    public static final String SUPER_KEYWORD = "super";

    private final Set<Class<?>> scanningAnnotations;

    private TreeMaker treeMaker;

    private Messager messager;

    private JavacElements elements;

    private TypeUtil typeUtil;

    private VariableCompilationTreeScanner scanner;

    {
        scanningAnnotations = new HashSet<>();
    }

    /**
     * Init.
     *
     * @param processingEnvironment the processing environment
     * @param scanningAnnotations   the scanning annotations
     */
    public void init(ProcessingEnvironment processingEnvironment, Set<Class<? extends Annotation>> scanningAnnotations) {
        if (scanningAnnotations != null) {
            this.scanningAnnotations.addAll(scanningAnnotations);
        }

        Trees trees = Trees.instance(processingEnvironment);
        JavacProcessingEnvironment javacProcessingEnv = (JavacProcessingEnvironment) processingEnvironment;
        this.treeMaker = TreeMaker.instance(javacProcessingEnv.getContext());
        this.messager = processingEnvironment.getMessager();
        this.elements = ((JavacProcessingEnvironment) processingEnvironment).getElementUtils();
        Types types = ((JavacProcessingEnvironment) processingEnvironment).getTypeUtils();
        trees = Trees.instance(javacProcessingEnv);
        this.typeUtil = new TypeUtil(types, elements);
        Names names = Names.instance(javacProcessingEnv.getContext());

        this.scanner = new VariableCompilationTreeScanner(trees);
        this.scanner.setFilter(
                (VariableElement element) -> scanningAnnotations.stream()
                        .anyMatch(eachAnnotation -> element.getAnnotation(eachAnnotation) != null)
        );
    }

    @Override
    public void started(TaskEvent e) {

    }

    @Override
    public void finished(TaskEvent taskEvent) {
        if (taskEvent.getKind() == ENTER) {
            this.scanner.scan(taskEvent.getCompilationUnit(), null);
        }

        if (taskEvent.getKind() == ANNOTATION_PROCESSING_ROUND) {
            this.scanner.getElements().forEach(element -> this.process(element));
        }
    }

    /**
     * Process boolean.
     *
     * @param element the element
     * @return the boolean
     */
    public boolean process(Element element) {
        for (AnnotationMirror annotationMirror : element.getAnnotationMirrors()) {
            for (Class<?> processingAnnotation : scanningAnnotations) {
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
        if ((currentNode = elements.getTree(currentElement)) == null)
            return;

        Element parentElement;
        if ((parentElement = currentElement.getEnclosingElement()) != null) {
            JCTree parentNode = elements.getTree(parentElement);

            JCTree.JCStatement statement = this.getMethodExecutionStatement(currentNode, annotationMirror);

            ((JCTree.JCMethodDecl) parentNode).body.stats = this.injectStatementIntoBody(
                    ((JCTree.JCMethodDecl) parentNode).body.stats,
                    List.of(statement),
                    currentElement);
        }
    }

    private JCTree.JCStatement getMethodExecutionStatement(JCTree currentNode, AnnotationMirror annotationMirror) {
        JCTree.JCExpression stateExpression = this.getMethodExecutionExpression(String.format(
                "%s.state%s",
                Statements.class.getCanonicalName(),
                annotationMirror.getAnnotationType().asElement().getSimpleName()
        ));

        List<JCTree.JCExpression> stateParams = List.nil();
        stateParams = stateParams.append(treeMaker.Ident(((JCTree.JCVariableDecl) currentNode).name));

        String message = null;
        for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> annotationEnElementValue :
                annotationMirror.getElementValues().entrySet()) {

            if (annotationEnElementValue.getKey().toString() == "message") continue;

            message = String.valueOf(annotationEnElementValue.getValue().getValue());
            stateParams = stateParams.append(treeMaker.Literal(message));
        }

        JCTree.JCStatement statement = treeMaker.Exec(treeMaker.Apply(
                List.<JCTree.JCExpression>nil(),
                stateExpression,
                stateParams)
        );

        return statement;
    }

    private JCTree.JCExpression getMethodExecutionExpression(String expressionString) {
        List<String> statementParts = List.from(expressionString.split("\\."));
        JCTree.JCExpression expression = treeMaker.Ident(elements.getName(statementParts.get(0)));

        for (int i = 1; i < statementParts.size(); i++) {
            expression = treeMaker.Select(expression, elements.getName(statementParts.get(i)));
        }

        return expression;
    }

    private List<JCTree.JCStatement> injectStatementIntoBody(List<JCTree.JCStatement> source, List<JCTree.JCStatement> injection, Element currentElement) {

        if (source.isEmpty()) {
            return injection;
        }

        if (injection.isEmpty() || source.toString().contains(injection.toString())) {
            return source;
        }

        int pointer = 0;
        while (pointer < source.length() && source.get(pointer).toString().contains(SUPER_KEYWORD)) {
            pointer++;
        }

        List<JCTree.JCStatement> statements = List.nil();
        for (JCTree.JCStatement statement : source.reverse()) {
            if (currentElement.getKind() == ElementKind.LOCAL_VARIABLE
                    && statement.getKind() == Tree.Kind.VARIABLE
                    && ((JCTree.JCVariableDecl) statement).name.equals(((JCTree.JCVariableDecl) this.elements.getTree(currentElement)).name))
                statements = statements.prependList(injection);

            statements = statements.prepend(statement);

            if (currentElement.getKind() == ElementKind.PARAMETER
                    && statement.equals(source.get(pointer))) {
                statements = statements.prependList(injection);
            }
        }

        return statements;
    }
}
