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
import io.github.ololx.cranberry.data.modifier.annotation.Final;

import javax.lang.model.element.Element;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * project cranberry
 * created 2022-01-04 16:55
 *
 * @author Alexander A. Kropotin
 */
final class VariableElementScanner extends TreePathScanner<Void, Void> {

    private final Map<Element, Set<Class<?>>> processedElements;

    private final Trees trees;

    //private final TreeMaker treeMaker;

    private VariableElementTranslator variableElementTranslator;


    /**
     * Instantiates a new Variable element scanner.
     *  @param trees             the trees
     //* @param treeMaker         the tree maker
     * @param variableElementTranslator
     * @param processedElements the processed elements
     */
    public VariableElementScanner(Trees trees,
            /*TreeMaker treeMaker,*/
                                  VariableElementTranslator variableElementTranslator,
                                  Map<Element, Set<Class<?>>> processedElements) {
        this.trees = trees;
        //this.treeMaker = treeMaker;
        this.processedElements = processedElements;
        this.variableElementTranslator = variableElementTranslator;
    }

    @Override
    public Void visitVariable(VariableTree tree, Void aVoid) {
        super.visitVariable(tree, aVoid);
        // This method might be invoked in case of
        //  1. method field definition
        //  2. method parameter
        //  3. local variable declaration
        // Therefore you have to filter out somehow what you don't need.
        if (tree.getKind() != Tree.Kind.VARIABLE && tree.getKind() != Tree.Kind.PARAMETERIZED_TYPE) {
            return aVoid;
        }

        Element variable = trees.getElement(trees.getPath(getCurrentPath().getCompilationUnit(), tree));
        Final annotation = variable.getAnnotation(Final.class);
        if (annotation == null) {
            return aVoid;
        }

        // Here we have your annotation.
        // We can process it now.

        Set<Class<?>> processedAnnotations = processedElements.getOrDefault(variable, new HashSet<>());
        if (processedAnnotations.contains(Final.class)) {
            return aVoid;
        } else {
            processedAnnotations.add(Final.class);
            processedElements.put(variable, processedAnnotations);
        }

        JCTree variableJc = (JCTree) trees.getTree(variable);
        variableJc.accept(variableElementTranslator);

        return aVoid;
    }
}
