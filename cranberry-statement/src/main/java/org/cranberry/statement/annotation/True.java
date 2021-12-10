package org.cranberry.statement.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
 * this code will throw {@link org.cranberry.statement.internal.exception.TrueStatementException}
 * if the `param` is not `true`; see {@link org.cranberry.statement.internal.util.Statements}.
 * 
 * This annotation is valid for `params` and `local variables` of the of the `Boolean` type and `boolean` primitive.
 * 
 * see {@link org.cranberry.statement.internal.exception.TrueStatementException}
 * see {@link org.cranberry.statement.internal.util.Statements}
 */
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
