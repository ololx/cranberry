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

import javax.lang.model.element.Element;
import java.util.Set;
import java.util.function.Predicate;

/**
 * The interface Compilation tree scanner.
 *
 * @param <E> the type parameter
 * @author Alexander A. Kropotin
 * @project cranberry
 * @created 2019 -12-26 14:43
 */
public interface CompilationTreeScanner<E extends Element> {

    /**
     * Gets elements.
     *
     * @return the elements
     */
    Set<E> getElements();

    /**
     * Sets filter.
     *
     * @param filter the filter
     */
    void setFilter(Predicate<E> filter);

    /**
     * Scan.
     *
     * @param tree the tree
     */
    void scan(Tree tree);
}
