package io.github.ololx.cranberry.statement.annotation;

import io.github.ololx.cranberry.statement.internal.exception.NotBlankStatementException;
import io.github.ololx.cranberry.statement.internal.util.Statements;

import java.lang.annotation.*;

/**
 * Causes cranberry to generate a statements validation method invoking.
 *
 * Example:
 * <pre>
 * public static void runWithoutCustomMessage(@NotBlank String param) {
 * }
 * </pre>
 * 
 * will generate:
 * <pre>
 * public static void runWithoutCustomMessage(@NotBlank String param) {
 *     Statements.stateNotBlank(param);
 * }
 * </pre>
 * this code will throw {@link NotBlankStatementException}
 * if the `param` is blank; see {@link Statements}.
 * 
 * This annotation is valid for `params` and `local variables` of of the `String` type.
 * 
 * see {@link NotBlankStatementException}
 * see {@link Statements}
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE
})
public @interface NotBlank {

    /**
     * Message string.
     * 
     * @return the custom message string of the statement exception.
     */
    String message() default "";
}
