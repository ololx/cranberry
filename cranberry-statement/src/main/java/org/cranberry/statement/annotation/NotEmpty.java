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
 * public static void runWithoutCustomMessage(@NotEmpty List param) {
 * }
 * </pre>
 * 
 * will generate:
 * <pre>
 * public static void runWithoutCustomMessage(@NotEmpty List param) {
 *     Statements.stateNotEmpty(param);
 * }
 * </pre>
 * this code will throw {@link org.cranberry.statement.internal.exception.NotEmptyStatementException}
 * if the `param` is empty; see {@link org.cranberry.statement.internal.util.Statements}.
 * 
 * This annotation is valid for `params` and `local variables` of the `Map` type,
 * the `Collection` type, the `Array` and the `String` type.
 * 
 * see {@link org.cranberry.statement.internal.exception.NotEmptyStatementException}
 * see {@link org.cranberry.statement.internal.util.Statements}
 */
@Retention(RetentionPolicy.SOURCE)
@Target({
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE
})
public @interface NotEmpty {

    /**
     * Message string.
     * 
     * @return the custom message string of the statement exception.
     */
    String message() default "";
}
