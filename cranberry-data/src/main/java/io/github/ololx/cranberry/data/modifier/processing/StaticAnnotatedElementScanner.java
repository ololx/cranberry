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
package io.github.ololx.cranberry.data.modifier.processing;

import com.sun.source.tree.Tree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;
import com.sun.tools.javac.tree.JCTree;
import io.github.ololx.cranberry.data.modifier.annotation.Static;

import javax.lang.model.element.Element;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * project cranberry
 * created 2022-12-03 22:17
 *
 * @author Alexander A. Kropotin
 */
final class StaticAnnotatedElementScanner extends TreePathScanner<Void, Void> {

    private final Map<Element, Set<Class<?>>> processedElements;

    private final Trees trees;

    private final StaticElementTranslator variableElementTranslator;


    /**
     * Instantiates a new Variable element scanner.
     *  @param trees             the trees
     //* @param treeMaker         the tree maker
     * @param variableElementTranslator
     * @param processedElements the processed elements
     */
    public StaticAnnotatedElementScanner(Trees trees, 
                                         StaticElementTranslator variableElementTranslator,
                                         Map<Element, Set<Class<?>>> processedElements
    ) {
        this.trees = trees;
        this.processedElements = processedElements;
        this.variableElementTranslator = variableElementTranslator;
    }

    @Override
    public Void visitVariable(VariableTree tree, Void aVoid) {
        super.visitVariable(tree, aVoid);
        
        if (tree.getKind() != Tree.Kind.VARIABLE && tree.getKind() != Tree.Kind.PARAMETERIZED_TYPE) {
            return aVoid;
        }

        Element variable = trees.getElement(trees.getPath(getCurrentPath().getCompilationUnit(), tree));
        Static annotation = variable.getAnnotation(Static.class);
        if (annotation == null) {
            return aVoid;
        }

        Set<Class<?>> processedAnnotations = processedElements.getOrDefault(variable, new HashSet<>());
        if (processedAnnotations.contains(Static.class)) {
            return aVoid;
        } else {
            processedAnnotations.add(Static.class);
            processedElements.put(variable, processedAnnotations);
        }

        JCTree variableJc = (JCTree) trees.getTree(variable);
        variableJc.accept(variableElementTranslator);

        return aVoid;
    }
}
