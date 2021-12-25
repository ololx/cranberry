package io.github.ololx.cranberry.logging.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The interface Log param.
 *
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2020 -03-02 16:41
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface LogParam {
    /**
     * Message string.
     *
     * @return the string
     */
    String message() default "";
}
