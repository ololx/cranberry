package io.github.ololx.cranberry.statement;

import io.github.ololx.cranberry.statement.annotation.NotEmpty;
import io.github.ololx.cranberry.statement.internal.exception.NotEmptyStatementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("The test of NotEmpty annotation")
public class NotEmptyTest {

    @Test
    @DisplayName("[negative]: test empty param")
    public void expectedNotEmptyException() {
        Exception exception = assertThrows(NotEmptyStatementException.class, () -> {
            testBoothParamAndVariable(new HashMap<>());
        });

        String expectedMessage = "'{}'";
        String  actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("[positive]: test not empty param")
    public void unexpectedNotEmptyException() {
        testBoothParamAndVariable(new HashMap<Integer, String>(){{put(1, "1");}});
    }

    public void testBoothParamAndVariable(@NotEmpty Map<Integer, String> param) {
        @NotEmpty Map<Integer, String> variable = param;
    }
}