package io.github.ololx.cranberry.commons.annotation;

import java.lang.annotation.*;

/**
 * CMarks a class or method so that the cranberry can run the annotation processor when only local variables are annotated.
 *
 * The cranberry is able to find annotated local variables at the stage of parsing the code,
 * but cannot process them if no klyukovka annotations were specified for non-local variables.
 *
 */
@Deprecated
@Retention(RetentionPolicy.SOURCE)
@Target({
        ElementType.METHOD,
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE,
        ElementType.TYPE_USE
})
public @interface IncludeVarsLocal {
}
