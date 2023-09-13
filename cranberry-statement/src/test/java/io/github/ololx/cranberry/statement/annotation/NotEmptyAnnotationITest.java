package io.github.ololx.cranberry.statement.annotation;

import java.util.Collection;
import java.util.Map;

/**
 * project cranberry
 * created 2021-12-27 16:29
 *
 * @author Alexander A. Kropotin
 */
public abstract class NotEmptyAnnotationITest {

    /**
     * Execute with annotated param object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedParam(@NotEmpty String param) {
        return param;
    }

    /**
     * Execute with annotated param object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedParam(@NotEmpty Object[] param) {
        return param;
    }

    /**
     * Execute with annotated param object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedParam(@NotEmpty Collection param) {
        return param;
    }

    /**
     * Execute with annotated param object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedParam(@NotEmpty Map param) {
        return param;
    }

    /**
     * Execute with annotated local variable object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedLocalVariable(String param) {
        @NotEmpty String variable = param;

        return param;
    }

    /**
     * Execute with annotated local variable object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedLocalVariable(Object[] param) {
        @NotEmpty Object[] variable = param;

        return param;
    }

    /**
     * Execute with annotated local variable object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedLocalVariable(Collection param) {
        @NotEmpty Collection variable = param;

        return param;
    }

    /**
     * Execute with annotated local variable object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedLocalVariable(Map param) {
        @NotEmpty Map variable = param;

        return param;
    }
}