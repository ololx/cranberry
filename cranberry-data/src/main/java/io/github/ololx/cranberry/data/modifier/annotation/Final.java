package io.github.ololx.cranberry.data.modifier.annotation;

import java.lang.annotation.*;

/**
 * The interface Final.
 */
@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({
        ElementType.PARAMETER,
        ElementType.LOCAL_VARIABLE
})
public @interface Final {
}
