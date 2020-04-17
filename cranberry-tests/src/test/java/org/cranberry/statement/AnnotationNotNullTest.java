package org.cranberry.statement;

import org.cranberry.statement.annotation.NotNull;
import org.cranberry.statement.internal.exception.NotNullStatementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("The test of NotNull annotation")
public class AnnotationNotNullTest {

    @Test
    @DisplayName("[negative]: test null param")
    public void expectedNotNullException() {
        Exception exception = assertThrows(NotNullStatementException.class, () -> {
            testBoothParamAndVariable(null);
        });

        String expectedMessage = "not null";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("[positive]: test not null param")
    public void unexpectedNotNullException() {
        testBoothParamAndVariable(new HashMap<Integer, String>());
    }

    public void testBoothParamAndVariable(@NotNull Map<Integer, String> param) {
        @NotNull Object variable = param;
    }
}