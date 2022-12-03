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

import com.sun.tools.javac.code.Flags;
import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.tree.TreeMaker;
import com.sun.tools.javac.tree.TreeTranslator;

/**
 * project cranberry
 * created 2022-12-03 22:17
 *
 * @author Alexander A. Kropotin
 */
final class StaticElementTranslator extends TreeTranslator {

    private final TreeMaker treeMaker;

    /**
     * Instantiates a new Variable element translator.
     *
     * @param treeMaker the tree maker
     */
    public StaticElementTranslator(final TreeMaker treeMaker) {
        this.treeMaker = treeMaker;
    }

    @Override
    public void visitVarDef(final JCTree.JCVariableDecl variableDeclaration) {
        super.visitVarDef(variableDeclaration);

        variableDeclaration.mods = treeMaker.Modifiers(variableDeclaration.mods.flags | Flags.STATIC);
        this.result = variableDeclaration;
    }
}
