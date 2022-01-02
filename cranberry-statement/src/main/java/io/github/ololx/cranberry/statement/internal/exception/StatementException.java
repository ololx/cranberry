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
package io.github.ololx.cranberry.statement.internal.exception;

import io.github.ololx.cranberry.commons.wrapping.ValueWrapper;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

/**
 * The type Statement exception.
 * Thrown to indicate that a some kind of statement has failed.
 * 
 * project cranberry
 * created 2020-03-10 09:45
 * 
 * @author Alexander A. Kropotin
 */
public class StatementException extends IllegalArgumentException {

    /**
     * Use serialVersionUID for interoperability
     */
    private static final long serialVersionUID = -8293295L;

    /**
     * The localized exception detail message templates. The template localization is set in
     * accordance with the user language or English, if there is not set user language in system properties;
     * see {@link System#getProperty(String, String)}
     * 
     * This is used to inform about the cause of the exception
     * together with {@link #expected};
     * see {@link #getDetail()} and {@link #getMessage()}
     * 
     * For example, the exception default detail for the not null statement takes value:
     * <ul>
     *     <li>
     *         {@code Exception in thread "main" org.cranberry.statement.internal.exception.NotEmptyStatementException:
     *         Ожидается 'not empty', но получили '{}'} - for RU localization
     *     </li>
     *     <li>
     *         {@code Exception in thread "main" org.cranberry.statement.internal.exception.NotEmptyStatementException:
     *         Ожидается 'not empty' is expected but actually was 'null'} - for EN localization and default localization
     *     </li>
     * </ul>
     * 
     */
    public static final ResourceBundle LOCALE_DETAIL_MESSAGE_PATTERNS = ResourceBundle.getBundle(
            "io.github.ololx.cranberry.statement.resources.messages",
            new Locale(System.getProperty(
                    "user.language",
                    "en"
            ))
    );

    /**
     * The specific detail about the actual result of a some statement (the reason of an exception).
     * This is used to inform about the cause of the exception
     * together with {@link #expected};
     * see {@link #getDetail()} and {@link #getMessage()}
     * 
     * For example, for the statement of not null value, this always contains value of 'null'.
     * 
     * @serial
     */
    protected ValueWrapper actual;

    /**
     * The specific detail about the expected result of a some statement.
     * This is used to inform about the cause of the exception
     * together with {@link #actual};
     * see {@link #getDetail()} and {@link #getMessage()}
     * 
     * For example, for the statement of not null value, this always contains value of 'not null'.
     * 
     * @serial
     */
    protected ValueWrapper expected;

    /**
     * Constructs an {@code StatementException} without the
     * specified exception message, cause, and expected/actual values.
     */
    public StatementException() {
        this(null, null, null, null);
    }

    /**
     * Constructs an {@code StatementException} with the
     * specified message, but without an expected/actual values and a cause.
     * 
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     */
    public StatementException(String message) {
        this(message, null, null, null);
    }

    /**
     * Constructs an {@code StatementException} with the
     * specified cause, but without the specified message and an expected/actual values.
     *
     * @param  cause the cause, which is saved for later retrieval by the
     * {@link Throwable#getCause()}; a {@code null} value
     * is indicates that the cause is nonexistent or unknown.
     */
    public StatementException(Throwable cause) {
        this(null, null, null, cause);
    }

    /**
     * Constructs an {@code StatementException} with the specified message and cause
     * but without the specified expected/actual values.
     * 
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param cause the cause of the failure
     */
    public StatementException(String message, Throwable cause) {
        this(message, null, null, cause);
    }

    /**
     * Constructs an {@code StatementException} with the specified message and
     * expected value, but without the specified expected value and cause.
     * 
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param actual the actual value; may be {@code null}
     */
    public StatementException(String message, Object actual) {
        this(message, null, actual, null);
    }

    /**
     * Constructs an {@code StatementException} with a message,
     * actual value, and a cause, but without the specified expected value.
     * 
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param actual the actual value; may be {@code null}
     * @param cause the cause of the failure
     */
    public StatementException(String message, Object actual, Throwable cause) {
        this(message, null, actual, cause);
    }

    /**
     * Constructs an {@code StatementException} with the specfied message and
     * expected/actual values, but without the specified cause.
     *
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param expected the expected value; may be {@code null}
     * @param actual the actual value; may be {@code null}
     */
    public StatementException(String message, Object expected, Object actual) {
        this(message, expected, actual, null);
    }

    /**
     * Constructs an {@code StatementException} with the specified message,
     * expected/actual values and a cause.
     * 
     * @param message the detail message; {@code null} or blank will be
     * converted to the empty {@code String}
     * @param expected the expected value; {@code null} will be wrapped into a {@code String} value
     * via the {@link String#valueOf(Object)}.
     * @param actual the actual value; {@code null} will be wrapped into a {@code String} value
     * via the {@link String#valueOf(Object)}.
     * @param cause the cause of the failure
     */
    public StatementException(String message, Object expected, Object actual, Throwable cause) {
        super((message == null || message.trim().equals(""))
                ? ValueWrapper.getValueStringRepresentation(message, "")
                : message);

        this.expected = ValueWrapper.getInstance(expected);

        this.actual = ValueWrapper.getInstance(actual);

        if (cause != null)
            this.initCause(cause);
    }

    /**
     * Returns the actual value wrapped in {@code ValueWrapper} instance.
     * 
     * @return {@code ValueWrapper} instance which store the {@link #actual}
     */
    public ValueWrapper getActual() {
        return this.actual;
    }

    /**
     * Returns the expected value wrapped in ValueWrapper instance.
     * 
     * @return {@code ValueWrapper} instance which store the {@link #expected}
     */
    public ValueWrapper getExpected() {
        return this.expected;
    }

    /**
     * Returns the detail string of this statement exception actual/expected values.
     * 
     * @return the detail string of this {@code StatementException} instance
     * actual/expected values (which could not be {@code null}).
     */
    public String getDetail() {
        return (this.expected.isValueDefined() && this.actual.isValueDefined())
                ? String.format(
                        StatementException.LOCALE_DETAIL_MESSAGE_PATTERNS.getString("detail.default"),
                        this.getExpected().getValueStringRepresentation(),
                        this.getActual().getValueStringRepresentation()
                )
                : "";
    }

    /**
     * Returns the detail message string of this statement exception or the statement detail with
     * actual/expected values.
     * 
     * @return the detail message string of this {@code StatementException} instance
     * (which could not be {@code null}).
     */
    public String getMessage() {
        return !"".equals(super.getMessage())
                ? super.getMessage()
                : this.getDetail();
    }

    /**
     * Returns a short description of this statement exception using the same format
     * as {@link Throwable#toString()}.
     * 
     * Since the constructors of this class convert supplied {@code null} or
     * blank messages to the empty {@code String}, this method only includes
     * non-empty messages in its return value.
     * 
     * @return a string representation of this {@code StatementException}.
     */
    @Override
    public String toString() {
        String className = getClass().getName();
        String message = getLocalizedMessage();

        return (
                "".equals(message)
                        ? className
                        : String.format("%s: %s", className, message)
        );
    }
}