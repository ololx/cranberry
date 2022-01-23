package io.github.ololx.cranberry.commons.annotation;

import io.github.ololx.cranberry.commons.informing.ForRemoval;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * CMarks a class or method so that the cranberry can run the annotation
 * processor when only local variables are annotated.
 *
 * The cranberry is able to find annotated local variables at the stage
 * of parsing the code, but cannot process them if no cranberry annotations
 * were specified for non-local variables.
 *
 */
@ForRemoval(
        since = "0.10.0",
        till = "0.12.0"
)
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
