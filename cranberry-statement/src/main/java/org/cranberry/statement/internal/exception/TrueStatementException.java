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
package org.cranberry.statement.internal.exception;

/**
 * The type True statement exception.
 * Thrown to indicate that a true logical statement has failed.
 * 
 * project cranberry
 * created 2020-03-10 09:45
 * 
 * @author Alexander A. Kropotin
 */
public final class TrueStatementException extends StatementException {

    /**
     * Use serialVersionUID for interoperability
     */
    private static final long serialVersionUID = 8912836030252030614L;

    /**
     * Overrides expected value by value of 'true' and actual value
     * by value of 'null'.
     */
    {
        this.expected = ValueWrapper.getInstance(Boolean.TRUE);
        this.actual = ValueWrapper.getInstance(Boolean.FALSE);
    }

    /**
     * Constructs an {@code StatementException} without the
     * specified exception message, cause, and expected/actual values.
     * 
     * The expected/actual values are defined by default.
     */
    public TrueStatementException() {
        super();
    }

    /**
     * Constructs an {@code TrueStatementException} with the
     * specified message, but without an expected/actual values and a cause.
     * 
     * The expected/actual values are defined by default.
     * 
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     */
    public TrueStatementException(String message) {
        super(message);
    }

    /**
     * Constructs an {@code TrueStatementException} with the
     * specified cause, but without the specified message and an expected/actual values.
     * 
     * The expected/actual values are defined by default.
     *
     * @param  cause the cause, which is saved for later retrieval by the
     * {@link Throwable#getCause()}; a {@code null} value
     * is indicates that the cause is nonexistent or unknown.
     */
    public TrueStatementException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs an {@code TrueStatementException} with the specified message and cause
     * but without the specified expected/actual values.
     * 
     * The expected/actual values are defined by default.
     * 
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param cause the cause of the failure
     */
    public TrueStatementException(String message, Throwable cause) {
        super(message, cause);
    }
}
