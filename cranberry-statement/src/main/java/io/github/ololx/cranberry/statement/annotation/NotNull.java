package io.github.ololx.cranberry.statement.annotation;

import io.github.ololx.cranberry.statement.internal.exception.NotNullStatementException;
import io.github.ololx.cranberry.statement.internal.util.Statements;

import java.lang.annotation.*;

/**
 * Causes cranberry to generate a statements validation method invoking.
 * 
 * Example:
 * <pre>
 * public static void runWithoutCustomMessage(@NotNull String param) {
 * }
 * </pre>
 * 
 * will generate:
 * <pre>
 * public static void runWithoutCustomMessage(@NotNull String param) {
 *     Statements.stateNotNull(param);
 * }
 * </pre>
 * this code will throw {@link NotNullStatementException}
 * if the `param` is null; see {@link Statements}.
 * 
 * This annotation is valid for `params` and `local variables` of the `Object` type.
 * 
 * see {@link NotNullStatementException}
 * see {@link Statements}
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE
})
public @interface NotNull {

    /**
     * Message string.
     * 
     * @return the custom message string of the statement exception.
     */
    String message() default "";
}
