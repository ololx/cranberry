package io.github.ololx.cranberry.statement.annotation;

import io.github.ololx.cranberry.commons.annotation.IncludeVarsLocal;
import io.github.ololx.cranberry.commons.wrapping.ValueWrapper;
import io.github.ololx.cranberry.statement.internal.exception.TrueStatementException;
import io.github.ololx.cranberry.statement.internal.util.Statements;

import java.lang.annotation.*;

/**
 * Causes cranberry to generate a statements validation method invoking.
 * 
 * Example:
 * <pre>
 * public static void runWithoutCustomMessage(@True Boolean param) {
 * }
 * </pre>
 * 
 * will generate:
 * <pre>
 * public static void runWithoutCustomMessage(@NotNull String param) {
 *     Statements.stateTrue(param);
 * }
 * </pre>
 * this code will throw {@link TrueStatementException}
 * if the `param` is not `true`; see {@link Statements}.
 * 
 * This annotation is valid for `params` and `local variables` of the of the `Boolean` type and `boolean` primitive.
 * 
 * see {@link TrueStatementException}
 * see {@link Statements}
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE
})
public @interface True {

    /**
     * Message string.
     * 
     * @return the custom message string of the statement exception.
     */
    String message() default "";
}
