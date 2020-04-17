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
package org.cranberry.statement.internal.exception;

/**
 * The type Not null statement exception.
 * Thrown to indicate that a not null statement has failed.
 * <p>
 * @project cranberry
 * @created 2020-03-10 09:45
 * <p>
 * @author Alexander A. Kropotin
 */
public final class NotNullStatementException extends StatementException {

    /**
     * Use serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -90L;

    /**
     * Overrides expected value by value of 'not null' and actual value
     * by value of 'null'.
     */
    {
        this.expected = ValueWrapper.getInstance("not null");
        this.actual = ValueWrapper.getInstance("null");
    }

    /**
     * Constructs an {@code StatementException} without the
     * specified exception message, cause, and expected/actual values.
     * <p>
     * The expected/actual values are defined by default.
     */
    public NotNullStatementException() {
        super();
    }

    /**
     * Constructs an {@code NotNullStatementException} with the
     * specified message, but without an expected/actual values and a cause.
     * <p>
     * The expected/actual values are defined by default.
     * <p>
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     */
    public NotNullStatementException(String message) {
        super(message);
    }

    /**
     * Constructs an {@code NotNullStatementException} with the
     * specified cause, but without the specified message and an expected/actual values.
     * <p>
     * The expected/actual values are defined by default.
     * <p>
     * @param cause the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param  cause the cause, which is saved for later retrieval by the
     * {@link Throwable#getCause()}; a {@code null} value
     * is indicates that the cause is nonexistent or unknown.
     */
    public NotNullStatementException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an {@code NotNullStatementException} with the specified message and cause
     * but without the specified expected/actual values.
     * <p>
     * The expected/actual values are defined by default.
     * <p>
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param cause the cause of the failure
     */
    public NotNullStatementException(String message, Throwable cause) {
        super(message, cause);
    }
}
