package io.github.ololx.cranberry.statement.annotation;

/**
 * project cranberry
 * created 2021-12-27 16:29
 *
 * @author Alexander A. Kropotin
 */
public abstract class NotBlankAnnotationITest {

    /**
     * Execute with annotated param string.
     *
     * @param param the param
     * @return the string
     */
    protected String executeWithAnnotatedParam(@NotBlank String param) {
        return param;
    }

    /**
     * Execute with annotated local variable string.
     *
     * @param param the param
     * @return the string
     */
    protected String executeWithAnnotatedLocalVariable(String param) {
        @NotBlank String variable = param;

        return param;
    }
}