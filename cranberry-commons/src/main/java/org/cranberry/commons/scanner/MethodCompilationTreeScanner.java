/**
 * Copyright 2020 the project cranberry authors
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
package org.cranberry.commons.scanner;

import com.sun.source.tree.MethodTree;
import com.sun.source.util.Trees;

import javax.lang.model.element.ExecutableElement;

/**
 * The type Method compilation tree scanner.
 *
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2020 -02-19 14:43
 */
public class MethodCompilationTreeScanner extends AbstractCompilationTreeScanner<ExecutableElement> {

    /**
     * Instantiates a new Method compilation tree scanner.
     *
     * @param trees the trees
     */
    public MethodCompilationTreeScanner(Trees trees) {
        super(trees);
    }

    @Override
    public Void visitMethod(MethodTree tree, Void aVoid) {
        super.visitMethod(tree, aVoid);
        this.addElement(tree);

        return aVoid;
    }
}