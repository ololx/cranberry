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

import io.github.ololx.cranberry.commons.informing.Unstable;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * An annotation used to indicate what annotation types an annotation
 * processor supports.  The {@link AbstractTrickyProcessor#getSupportedAnnotationTypes}
 * method can construct its result from the value of this annotation,
 * as done by {@link AbstractTrickyProcessor#getSupportedAnnotationTypes}.
 *
 * project cranberry
 * created 2022-01-23 19:45
 *
 * @author Alexander A. Kropotin
 * @since 0.11.0
 */
@Unstable
@Documented
@Target(TYPE)
@Retention(RUNTIME)
public @interface TargetAnnotationTypes {

    Class<? extends Annotation>[] value();
}
