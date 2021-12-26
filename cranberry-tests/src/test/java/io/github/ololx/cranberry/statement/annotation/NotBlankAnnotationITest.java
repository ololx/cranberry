package io.github.ololx.cranberry.statement.annotation;

import io.github.ololx.cranberry.statement.annotation.NotBlank;
import io.github.ololx.cranberry.statement.internal.exception.NotBlankStatementException;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NotBlankAnnotationITest {

    @Test(expectedExceptions = NotBlankStatementException.class)
    public void expectedNotBlankException() {
        executeWithAnnotatedLocalVariable("  ");
    }

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