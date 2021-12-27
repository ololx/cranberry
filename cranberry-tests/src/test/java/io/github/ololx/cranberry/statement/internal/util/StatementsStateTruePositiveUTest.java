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

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * project cranberry
 * created 2021-12-27 16:29
 *
 * @author Alexander A. Kropotin
 */
public class StatementsStateTruePositiveUTest {

    /**
     * String values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "booleanValues")
    public static Object[] stringValues() {
        return new Object[] {
                true
        };
    }

    /**
     * State true when string value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "booleanValues")
    public void stateNotEmpty_whenBooleanValueIsTrue_thenDoNotThrowsException(Boolean value) {
        Statements.stateTrue(value);
    }
}
