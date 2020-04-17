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
package org.cranberry.commons.handler;

import com.sun.source.util.TaskEvent;

import java.util.Collection;

/**
 * The type Multi phase compilation handler.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 * @author Alexander A. Kropotin
 * @project cranberry
 * @created 2019 -12-23 13:23
 */
public class MultiPhaseCompilationHandler<T extends TaskEvent, K extends TaskEvent.Kind>
        extends AbstractCompilationHandler<T, K>
        implements SettableCompilationHandler<K> {

    /**
     * Instantiates a new Multi phase compilation handler.
     */
    public MultiPhaseCompilationHandler() {
        super();
    }

    @Override
    public void addPhaseType(K pass) {
        this.phasesTypes.add(pass);
    }

    @Override
    public void addPhasesTypes(Collection<K> passes) {
        this.phasesTypes.addAll(this.phasesTypes);
    }
}
