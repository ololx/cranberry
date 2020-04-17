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
 * The type Not empty statement exception.
 * Thrown to indicate that a not empty statement has failed.
 * <p>
 * @project cranberry
 * @created 2020-03-18 16:00
 * <p>
 * @author Alexander A. Kropotin
 */
public final class NotEmptyStatementException extends StatementException {

    /**
     * Use serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -10L;

    /**
     * Overrides expected value by value of 'not empty'. Actual value could be defined
     * via constructors.
     */
    {
        this.expected = ValueWrapper.getInstance("not empty");
    }

    /**
     * Constructs an {@code NotEmptyStatementException} without the
     * specified exception message, cause, and expected/actual values.
     * <p>
     * The expected value is defined by default.
     */
    public NotEmptyStatementException() {
        super();
    }

    /**
     * Constructs an {@code NotEmptyStatementException} with the
     * specified message, but without the specified expected/actual values and a cause.
     * <p>
     * The expected value is defined by default.
     * <p>
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     */
    public NotEmptyStatementException(String message) {
        super(message);
    }

    /**
     * Constructs an {@code NotEmptyStatementException} with the
     * specified actual value, but without the specified message, expected value and a cause.
     * <p>
     * The expected value is defined by default.
     * <p>
     * @param actual the actual value; may be {@code null}
     */
    public NotEmptyStatementException(Object actual) {
        super(null, actual);
    }

    /**
     * Constructs an {@code NotEmptyStatementException} with the specified message and
     * expected value, but without the specified expected value and cause.
     * <p>
     * The expected value is defined by default.
     * <p>
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param actual the actual value; may be {@code null}
     */
    public NotEmptyStatementException(String message, Object actual) {
        super(message, null, actual, null);
    }

    /**
     * Constructs an {@code NotEmptyStatementException} with the
     * specified cause, but without the specified message and an expected/actual values.
     * <p>
     * The expected value is defined by default.
     * <p>
     * @param cause the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param  cause the cause, which is saved for later retrieval by the
     * {@link Throwable#getCause()}; a {@code null} value
     * is indicates that the cause is nonexistent or unknown.
     */
    public NotEmptyStatementException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an {@code NotEmptyStatementException} with the specified message and cause
     * but without the specified expected/actual values.
     * <p>
     * The expected value is defined by default.
     * <p>
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param cause the cause of the failure
     */
    public NotEmptyStatementException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an {@code NotEmptyStatementException} with a message,
     * actual value, and a cause, but without the specified expected value.
     * <p>
     * The expected value is defined by default.
     * <p>
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param actual the actual value; may be {@code null}
     * @param cause the cause of the failure
     */
    public NotEmptyStatementException(String message, Object actual, Throwable cause) {
        super(message, null, actual, cause);
    }
}
