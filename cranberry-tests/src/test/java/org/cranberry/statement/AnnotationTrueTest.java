package org.cranberry.statement;

import org.cranberry.statement.annotation.True;
import org.cranberry.statement.internal.exception.TrueStatementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("The test of True annotation")
public class AnnotationTrueTest {

    @Test
    @DisplayName("[negative]: test false param")
    public void expectedNotNullException() {
        Exception exception = assertThrows(TrueStatementException.class, () -> {
            testBoothParamAndVariable(false, true);
        });

        String expectedMessage = "false";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    @DisplayName("[positive]: test true param")
    public void unexpectedNotNullException() {
        testBoothParamAndVariable(true, false);
    }

    public void testBoothParamAndVariable(@True boolean param, boolean param2) {
        @True boolean param3 = !param2;
    }
}