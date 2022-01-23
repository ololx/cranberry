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
 * A program element with the {@code @ForExperimentalUsage} annotation is
 * an element that may be used by programmers only at their own risk. It may has
 * an unexpected behavior or contain bugs that were not identified during testing.
 * It may be annotated by {@code @Unstable} or {@code @ForRemoval}
 * in a future release.
 *
 * This annotation type has a string-valued elements {@code since}. The value of
 * this element indicates the version in which the annotated program element
 * was first marked for experimental usage (was implemented like a beta).
 *
 * This annotation type has a string-valued elements {@code till}. The value of
 * this element indicates the version in which the annotated program element
 * will be implemented like a release.
 *
 * @apiNote
 * If element instability is also implied (may be changed without backwards
 * compatibility), then it is recommended recommended to annotate a programming
 * element in conjunction with the {@code @Unstable} annotation.
 *
 * It is recommended that a {@code since} value be provided with all newly
 * annotated program elements.
 *
 * It is recommended that a {@code till} value be provided with all newly
 * annotated program elements. Note that {@code till} may not be required as it
 * is not always possible to predict the exact version to release.
 *
 * There is no defined order among annotation elements. As a matter of style,
 * the {@code since} element should be placed first.
 *
 * project cranberry
 * created 2022-01-23 11:49
 *
 * @author Alexander A. Kropotin
 * @since 0.10.0
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
public @interface ForExperimentalUsage {

    /**
     * Returns version in which the annotated program element was first marked
     * for experimental usage (was implemented like a beta).
     * The version string is in the same format and namespace as the value of
     * the project cranberry {@code version}. The default value is not presented.
     *
     * @return the version string
     */
    String since();

    /**
     * Returns version in which the annotated program element will be implemented
     * like a release. The version string is in the same format and namespace as
     * the value of the project cranberry {@code version}. The default value is
     * the empty string.
     *
     * @return the version string
     */
    String till() default "";
}
