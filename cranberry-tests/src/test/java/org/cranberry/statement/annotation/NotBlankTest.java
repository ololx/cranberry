package org.cranberry.statement.annotation;

import org.cranberry.statement.annotation.NotBlank;
import org.cranberry.statement.internal.exception.NotBlankStatementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("The test of NotBlank annotation")
public class NotBlankTest {

    @Test
    @DisplayName("[negative]: test empty param")
    public void expectedNotBlankException() {
        NotBlankStatementException exception = assertThrows(NotBlankStatementException.class, () -> {
            testBoothParamAndVariable("     ");
        });

        String expectedMessage = "123";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("[positive]: test not empty param")
    public void unexpectedNotBlankException() {
        testBoothParamAndVariable("1");
    }

    public void testBoothParamAndVariable(@NotBlank(message = "123") String param) {
        @NotBlank String variable = param;
    }
}