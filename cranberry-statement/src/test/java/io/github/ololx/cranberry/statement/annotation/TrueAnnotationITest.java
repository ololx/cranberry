package io.github.ololx.cranberry.statement.annotation;

/**
 * project cranberry
 * created 2021-12-27 16:29
 *
 * @author Alexander A. Kropotin
 */
public abstract class TrueAnnotationITest {

    protected class AnnotatedParamOfConstructor {

        Boolean param1;

        boolean param2;

        protected AnnotatedParamOfConstructor(@True boolean param) {
            this.param1 = param;
        }

        protected AnnotatedParamOfConstructor(@True @NotNull boolean param1,
                                              @True @NotNull boolean param2) {
            this.param1 = param1;
            this.param2 = param2;
        }
    }

    /**
     * Execute with annotated param object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedParam(@True Boolean param) {
        return param;
    }

    /**
     * Execute with annotated local variable object.
     *
     * @param param the param
     * @return the object
     */
    protected Object executeWithAnnotatedLocalVariable(Boolean param) {
        @True Boolean variable = param;

        return param;
    }
}