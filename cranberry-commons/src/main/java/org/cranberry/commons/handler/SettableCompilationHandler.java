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
 * The interface Settable compilation handler.
 *
 * @param <K> the type parameter
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2019 -12-23 12:32
 */
public interface SettableCompilationHandler<K extends TaskEvent.Kind> {

    /**
     * Add phase type.
     *
     * @param pass the pass
     */
    void addPhaseType(K pass);

    /**
     * Add phases types.
     *
     * @param passes the passes
     */
    void addPhasesTypes(Collection<K> passes);
}
