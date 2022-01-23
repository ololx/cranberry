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
package io.github.ololx.cranberry.commons.engine;

import javax.annotation.processing.Processor;
import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * project cranberry
 * created 2022-01-22 17:57
 *
 * @author Alexander A. Kropotin
 */
public interface TrickyProcessor extends Processor {

    Set<Class<? extends Annotation>> getTargetAnnotationTypes();
}
