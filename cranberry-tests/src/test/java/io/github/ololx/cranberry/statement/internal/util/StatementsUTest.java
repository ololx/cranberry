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
package io.github.ololx.cranberry.statement.internal.util;

import io.github.ololx.cranberry.statement.internal.exception.NotBlankStatementException;
import io.github.ololx.cranberry.statement.internal.exception.NotEmptyStatementException;
import io.github.ololx.cranberry.statement.internal.exception.NotNullStatementException;
import io.github.ololx.cranberry.statement.internal.exception.TrueStatementException;
import org.testng.annotations.Test;

/**
 * project cranberry
 * created 2021-12-26 15:13
 *
 * @author Alexander A. Kropotin
 */
public class StatementsUTest {

    /**
     * State not blank when value is blank then throws exception.
     */
    @Test(expectedExceptions = NotBlankStatementException.class)
    public void stateNotBlank_whenValueIsBlank_thenThrowsException() {
        Statements.stateNotBlank("   ");
    }

    /**
     * State not null when value is null then throws exception.
     */
    @Test(expectedExceptions = NotNullStatementException.class)
    public void stateNotNull_whenValueIsNull_thenThrowsException() {
        Statements.stateNotNull(null);
    }

    /**
     * State not empty when value is empty then throws exception.
     */
    @Test(expectedExceptions = NotEmptyStatementException.class)
    public void stateNotEmpty_whenValueIsEmpty_thenThrowsException() {
        Statements.stateNotEmpty("");
    }

    /**
     * State true when value is false then throws exception.
     */
    @Test(expectedExceptions = TrueStatementException.class)
    public void stateTrue_whenValueIsFalse_thenThrowsException() {
        Statements.stateTrue(false);
    }

    /**
     * State not blank when value is not blank then do not throws exception.
     */
    @Test
    public void stateNotBlank_whenValueIsNotBlank_thenDoNotThrowsException() {
        Statements.stateNotBlank("not blank");
    }

    /**
     * State not null when value is not null then do not throws exception.
     */
    @Test
    public void stateNotNull_whenValueIsNotNull_thenDoNotThrowsException() {
        Statements.stateNotNull("not null");
    }

    /**
     * State not empty when value is not empty then do not throws exception.
     */
    @Test
    public void stateNotEmpty_whenValueIsNotEmpty_thenDoNotThrowsException() {
        Statements.stateNotEmpty("not empty");
    }

    /**
     * State true when value is not false then do not throws exception.
     */
    @Test
    public void stateTrue_whenValueIsNotFalse_thenDoNotThrowsException() {
        Statements.stateTrue(true);
    }
}
