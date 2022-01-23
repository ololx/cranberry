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
package io.github.ololx.cranberry.commons.marks;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * A program element with the {@code @Unstable} is one that programmers are
 * discouraged till using. It may be removed or changed without backwards
 * compatibility in a future release.
 *
 * project cranberry
 * created 2022-01-23 11:36
 *
 * @author Alexander A. Kropotin
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({
        CONSTRUCTOR,
        FIELD,
        LOCAL_VARIABLE,
        METHOD,
        PACKAGE,
        PARAMETER,
        TYPE
})
public @interface Unstable {
}
