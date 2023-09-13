/**
 * Copyright 2021 the project cranberry authors
 * and the original author or authors annotated by {@author}
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ololx.cranberry.statement.internal.exception;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * project cranberry
 * created 2021-12-27 18:47
 *
 * @author Alexander A. Kropotin
 */
public class StatementExceptionUTest {

    /**
     * String values object [ ] [ ].
     *
     * @return the object [ ] [ ]
     */
    @DataProvider(name = "customMessages")
    public static Object[][] customMessages() {
        return new Object[][] {
                {
                    "StatementException",
                        new StatementException("StatementException")
                },
                {
                        "NotBlankStatementException",
                        new NotBlankStatementException("NotBlankStatementException")
                },
                {
                        "NotNullStatementException",
                        new NotNullStatementException("NotNullStatementException")
                },
                {
                        "NotEmptyStatementException",
                        new NotEmptyStatementException("NotEmptyStatementException")
                },
                {
                        "TrueStatementException",
                        new TrueStatementException("TrueStatementException")
                },
        };
    }

    /**
     * Gets message when exception is created with custom message then return exception custom message.
     *
     * @param expectedMessage the expected message
     * @param exception       the exception
     */
    @Test(dataProvider = "customMessages")
    public void getMessage_whenExceptionIsCreatedWithCustomMessage_thenReturnExceptionCustomMessage(String expectedMessage, StatementException exception) {
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage), "The message does not match the locale");
    }
}
