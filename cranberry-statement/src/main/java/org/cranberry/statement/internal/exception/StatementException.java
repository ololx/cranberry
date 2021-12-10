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
     * The type ValueWrapper.
     * The wrapper of a value that is used in an statements exceptions.
     * 
     * This stores the value {@link #getValue()}, value type {@link #getType() runtime type}
     * and value hash code {@link #toString()}.
     * 
     * This allows to get a value string representation {@link #getValueStringRepresentation()}
     * 
     * The {@link #toString()} method returns the string representation of the
     * value along with its type and identity hash code.
     * 
     * project cranberry
     * created 2020-04-16 12:45
     * 
     * @author Alexander A. Kropotin
     */
    static final class ValueWrapper implements Serializable {

        /**
         * Use serialVersionUID for interoperability
         */
        private static final long serialVersionUID = -309177L;

        /**
         * The wrapped value hash code; see {@link #toString()}.
         * 
         * @serial
         */
        private final int valueHashCode;

        /**
         * The wrapped value type; see {@link #toString()}, {@link #getType()}.
         * 
         * @serial
         */
        private final Class<?> type;

        /**
         * The wrapped value; see {@link #getValueStringRepresentation()},
         * {@link #getValue()}, {@link #toString()}, {@link #getType()}.
         * 
         * @serial
         */
        private final Object value;

        /**
         * The factory method for the getting a new {@code ValueWrapper} instance
         * for the supplied {@code value}.
         * 
         * This method will return a new {@code ValueWrapper} instance for a given value
         * suitable for all {@code values} if the value is not an instance of a wrapper.
         * Otherwise, if the supplied {@code value} is already a {@link ValueWrapper} instance,
         * this method will return it as is.
         * 
         * @param value the value to wrap; may be {@code null}
         * @return a wrapper for the supplied value; never {@code null}
         */
        public static ValueWrapper getInstance(Object value) {

            if (value instanceof ValueWrapper)
                return (ValueWrapper) value;

            return new ValueWrapper(value);
        }

        /**
         * Returns the string representation of a value for the supplied {@code value}
         * via the supplied custom {@code nullStringRepresentation}.
         * 
         * If the supplied {@code value} is {@code null}, this method will return a
         * custom representation of the value from the {@code nullStringRepresentation}.
         * If the supplied {@code value} is not {@code null}, this method will return a string representation
         * which is generated by invoking {@link String#valueOf(Object) String.valueOf(value)}:
         * <ul>
         *     <li>
         *         for an each element of an array - if the value type is
         *         an array type; see {@link Class#isArray()};
         *     </li>
         *     <li>
         *         for the value - in another cases.
         *     </li>
         * </ul>
         * 
         * @param value the value to wrap; may be {@code null}
         * @param nullStringRepresentation a custom representation of the value; is used by default
         * when value is {@code null}.
         * @return a string representation for the supplied value; never {@code null}
         */
        public static String getValueStringRepresentation(Object value, String nullStringRepresentation) {

            if (value == null)
                return String.valueOf(nullStringRepresentation);

            if (value.getClass().isArray())
                return String.format(
                        "[%s]",
                        Arrays.stream((Object[]) value)
                                .map(element -> String.valueOf(element))
                                .collect(Collectors.joining(", "))
                );

            return String.valueOf(value);
        }

        /**
         * Constructs an {@code ValueWrapper} with the
         * specified value, value type and value hash code.
         * 
         * @param value the value to wrap; may be {@code null}.
         */
        private ValueWrapper(Object value) {
            this.valueHashCode = System.identityHashCode(value);
            this.value = value;
            this.type = value == null
                    ? null
                    : value.getClass();
        }

        /**
         * Returns the origin value supplied to {@link #ValueWrapper(Object)} or
         * {@code null} if the value is {@code null}.
         * 
         * @return an origin value with type {@code Object}.
         */
        public Object getValue() {
            return this.value;
        }

        /**
         * Returns the origin value type supplied to {@link #ValueWrapper(Object)} or
         * {@code null} if the value is {@code null}.
         * 
         * @return a origin value type with type {@code Class<?>}.
         */
        public Class<?> getType() {
            return this.type;
        }

        /**
         * Returns the string representation of a wrapped value.
         * This method returns wrapped value string representation by invoking
         * {@link #getValueStringRepresentation(Object value, String nullStringRepresentation)
         * ValueWrapper.getValueStringRepresentation(this.getValue(), null)}.
         * 
         * If the wrapped {@code value} is {@code null}, this method will return a
         * string `{@code null}'.
         * 
         * @return a string representation for the wrapper value; never {@code null}
         */
        public String getValueStringRepresentation() {
            return ValueWrapper.getValueStringRepresentation(this.getValue(), null);
        }

        /**
         * Indicates whether the wrapped value is defined or not.
         * 
         * @return {@code true} if the wrapped value is not null;
         * {@code false} otherwise.
         */
        public boolean isValueDefined() {
            return this.getValue() != null;
        }

        /**
         * Indicates whether the wrapped value is undefined or
         * it is defined.
         * 
         * @return {@code true} if the wrapped value is null;
         * {@code false} otherwise.
         */
        public boolean isValueUndefined() {
            return !this.isValueDefined();
        }

        /**
         * Indicates whether the wrapped value type is defined or not.
         * 
         * @return {@code true} if the wrapped value type is not null;
         * {@code false} otherwise.
         */
        public boolean isTypeDefined() {
            return this.getType() != null;
        }

        /**
         * Indicates whether the wrapped value type is undefined
         * or it is defined.
         * 
         * @return {@code true} if the wrapped value type is null;
         * {@code false} otherwise.
         */
        public boolean isTypeUndefined() {
            return !this.isTypeDefined();
        }

        /**
         * Returns the string representation of a value along with its type and
         * identity hash code.
         * 
         * The {@code toString} method for this class returns a string consisting of:
         * <ul>
         *     <li>
         *         the string representation of the origin value - if the origin value is null;
         *         
         *         for instance:
         *         <blockquote>
         *             <pre>
         *                 value.getValueStringRepresentation()
         *             </pre>
         *         </blockquote>
         *     </li>
         *     <li>
         *         the name of the class of which the origin value object is an instance,
         *         the at-sign character `{@code @}', the unsigned hexadecimal representation
         *         of the hash code of the origin value object, the at-sign character `{@code =}'
         *         and the string representation of the origin value - if the origin value is null.
         *         
         *         for instance:
         *         <blockquote>
         *             <pre>
         *                 '[' + getClass().getName() + '@' + Integer.toHexString(value.hashCode()) + ']'
         *                 + '=' + value.getValueStringRepresentation()
         *             </pre>
         *         </blockquote>
         *     </li>
         * </ul>
         * 
         * @return a string representation of the object.
         */
        @Override
        public String toString() {
            return this.isTypeDefined()
                    ? String.format(
                            "[%s@%s]=%s",
                            this.getType().getName(),
                            Integer.toHexString(this.valueHashCode),
                            this.getValueStringRepresentation()
                    )
                    : this.getValueStringRepresentation();
        }
    }

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
            "org.cranberry.statement.resources.messages",
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
                : new String();
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
                : !"".equals(this.getDetail())
                ? this.getDetail()
                : new String();
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