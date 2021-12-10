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
 * this code will throw {@link org.cranberry.statement.internal.exception.NotBlankStatementException}
 * if the `param` is blank; see {@link org.cranberry.statement.internal.util.Statements}.
 * 
 * This annotation is valid for `params` and `local variables` of of the `String` type.
 * 
 * see {@link org.cranberry.statement.internal.exception.NotBlankStatementException}
 * see {@link org.cranberry.statement.internal.util.Statements}
 */
@Retention(RetentionPolicy.SOURCE)
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
