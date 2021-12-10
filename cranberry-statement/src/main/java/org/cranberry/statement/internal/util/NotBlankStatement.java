/**
 * Copyright 2020 the project cranberry authors
 * and the original author or authors annotated by {@author}
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cranberry.statement.internal.util;

import org.cranberry.statement.internal.exception.NotBlankStatementException;

/**
 * The type Not blank statement.
 *
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2020 -03-20 15:18 
 */
class NotBlankStatement implements Statement {

    /**
     * Check.
     *
     * @param actual the actual
     */
    static void check(String actual) {
        NotEmptyStatement.check(actual);
    }

    /**
     * Check.
     *
     * @param actual  the actual
     * @param message the message
     */
    static void check(String actual, String message) {
        if (Reasoner.isObjectNull(actual) || actual.trim().length() == 0) {
            throw new NotBlankStatementException(message, actual);
        }
    }
}
