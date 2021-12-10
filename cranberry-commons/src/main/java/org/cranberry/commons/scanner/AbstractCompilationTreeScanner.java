/**
 * Copyright 2019 the project cranberry authors
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

import com.sun.source.tree.Tree;
import com.sun.source.util.TreePathScanner;
import com.sun.source.util.Trees;

import javax.lang.model.element.Element;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

/**
 * The type Abstract compilation tree scanner.
 *
 * @param <E> the type parameter
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2019 -12-26 14:51
 */
public abstract class AbstractCompilationTreeScanner<E extends Element>
        extends TreePathScanner<Void, Void>
        implements CompilationTreeScanner<E> {

    private final Trees trees;

    private Predicate<E> filter;

    private final Set<E> elements;

    {
        this.filter = (E element) -> true;
        this.elements = new HashSet<>();
    }

    /**
     * Instantiates a new Abstract compilation tree scanner.
     *
     * @param trees the trees
     */
    public AbstractCompilationTreeScanner(Trees trees) {
        Objects.requireNonNull(trees);
        this.trees = trees;
    }

    public Set<E> getElements() {
        return this.elements;
    }

    public void setFilter(Predicate<E> filter) {
        Objects.requireNonNull(filter);
        this.filter = filter;
    }

    /**
     * Add element.
     *
     * @param tree the tree
     */
    protected void addElement(Tree tree) {
        E element = (E) this.trees.getElement(trees.getPath(
                getCurrentPath().getCompilationUnit(),
                tree
        ));

        if (filter.test(element)) {
            this.elements.add(element);
        }
    }

    public void scan(Tree tree) {
        this.scan(tree, null);
    }
}