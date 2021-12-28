package io.github.ololx.cranberry.statement.annotation;

/**
 * project cranberry
 * created 2021-12-27 16:29
 *
 * @author Alexander A. Kropotin
 */
public abstract class NotNullAnnotationITest {

    /**
     * Execute with annotated param object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedParam(@NotNull Object param) {
        return param;
    }

    /**
     * Execute with annotated local variable object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedLocalVariable(Object param) {
        @NotNull Object variable = param;

        return param;
    }
}