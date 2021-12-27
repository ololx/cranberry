package io.github.ololx.cranberry.statement.annotation;

import io.github.ololx.cranberry.statement.internal.exception.NotBlankStatementException;
import org.testng.annotations.Test;

/**
 * The type Not blank annotation i test.
 */
public class NotBlankAnnotationITest {

    /**
     * Expected not blank exception.
     */
    @Test(expectedExceptions = NotBlankStatementException.class)
    public void expectedNotBlankException() {
        executeWithAnnotatedLocalVariable("  ");
    }

    /**
     * Unexpected not blank exception.
     */
    @Test
    public void unexpectedNotBlankException() {
        executeWithAnnotatedLocalVariable("1");
    }

    private String executeWithAnnotatedParam(@NotBlank String param) {
        return param;
    }

    private String executeWithAnnotatedLocalVariable(String param) {
        @NotBlank String variable = param;

        return param;
    }
}