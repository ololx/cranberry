/**
 * Copyright 2020 the project cranberry authors
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
package org.cranberry.statement.internal.util;

import org.cranberry.statement.internal.exception.TrueStatementException;

/**
 * The type True statement.
 * <p>
 * @author Alexander A. Kropotin
 * @project cranberry
 * @created 2020 -03-09 20:21
 */
class TrueStatement implements Statement {

    /**
     * Check.
     *
     * @param actual the actual
     */
    static void check(Boolean actual) {
        TrueStatement.check(actual, null);
    }

    /**
     * Check.
     *
     * @param actual  the actual
     * @param message the message
     */
    static void check(Boolean actual, String message) {
        if (actual == null || !actual) {
            throw new TrueStatementException(message);
        }
    }
}
