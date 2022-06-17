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
package io.github.ololx.cranberry.commons.informing;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * A program element annotated {@code @ForRemoval} is one that programmers
 * are discouraged till using. It will be removed in a future version.
 *
 * This annotation type has a string-valued elements {@code since}. The value of
 * this element indicates the version in which the annotated program element
 * was first marked for removal.
 *
 * This annotation type has a string-valued elements {@code till}. The value of
 * this element indicates the version in which the annotated program element
 * will be removed.
 *
 * Note:
 * <p>It is highly recommended to annotate a programming element in conjunction
 * with the {@code @Deprecated} annotation.</p>
 *
 * It is recommended that a {@code since} value be provided with all newly
 * annotated program elements.
 *
 * It is recommended that a {@code till} value be provided with all newly
 * annotated program elements. Note that {@code till} may not be required as it
 * is not always possible to predict the exact version to remove.
 *
 * There is no defined order among annotation elements. As a matter of style,
 * the {@code since} element should be placed first.
 *
 * project cranberry
 * created 2022-01-22 18:53
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
public @interface ForRemoval {

    /**
     * Returns version in which the annotated program element was first marked
     * for removal.
     * The version string is in the same format and namespace as the value of
     * the project cranberry {@code version}. The default value is not presented.
     *
     * @return the version string
     */
    String since();

    /**
     * Returns version in which the annotated program element will be removed.
     * The version string is in the same format and namespace as the value of
     * the project cranberry {@code version}. The default value is
     * the empty string.
     *
     * @return the version string
     */
    String till() default "";
}

