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
package io.github.ololx.cranberry.commons.handler;

import com.sun.source.util.TaskEvent;

import java.util.Set;
import java.util.function.Consumer;

/**
 * The type Abstract compilation handler.
 *
 * @param <T> the type parameter
 * @param <K> the type parameter
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2019 -12-23 12:52
 */
public abstract class AbstractCompilationHandler<T extends TaskEvent, K extends TaskEvent.Kind>
        implements CompilationHandler<T> {

    /**
     * The Start handling.
     */
    protected Consumer<T> startHandling;

    /**
     * The Finish handling.
     */
    protected Consumer<T> finishHandling;

    /**
     * The Phases types.
     */
    protected Set<K> phasesTypes;

    /**
     * Instantiates a new Abstract compilation handler.
     */
    public AbstractCompilationHandler() {
    }

    @Override
    public void started(TaskEvent event) {
        if (this.startHandling == null)
            return;

        this.acceptHandling(this.startHandling, (T) event);
    }

    @Override
    public void finished(TaskEvent event) {
        if (this.finishHandling == null)
            return;

        this.acceptHandling(this.finishHandling, (T) event);
    }

    @Override
    public void setStartHandling(Consumer<T> startHandling) {
        this.startHandling = startHandling;
    }

    @Override
    public void setFinishHandling(Consumer<T> finishHandling) {
        this.finishHandling = finishHandling;
    }

    private void acceptHandling(Consumer<T> processing, T event) {
        if (phasesTypes.contains(event.getKind()))
            processing.accept(event);
    }
}
