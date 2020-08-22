package org.cranberry.statement.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Causes cranberry to generate a statements validation method invoking.
 * <p>
 * Example:
 * <pre>
 * public static void runWithoutCustomMessage(@NotNull String param) {
 * }
 * </pre>
 * <p>
 * will generate:
 * <pre>
 * public static void runWithoutCustomMessage(@NotNull String param) {
 *     Statements.stateNotNull(param);
 * }
 * </pre>
 * this code will throw {@link org.cranberry.statement.internal.exception.NotNullStatementException}
 * if the `param` is null; see {@link org.cranberry.statement.internal.util.Statements}.
 * <p>
 * This annotation is valid for `params` and `local variables` of the `Object` type.
 * <p>
 * see {@link org.cranberry.statement.internal.exception.NotNullStatementException}
 * see {@link org.cranberry.statement.internal.util.Statements}
 */
@Retention(RetentionPolicy.SOURCE)
@Target({
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE
})
public @interface True {

    boolean condition() default true;

    /**
     * Message string.
     * <p>
     * @return the custom message string of the statement exception.
     */
    String message() default "";
}
