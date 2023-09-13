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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;

/**
 * project cranberry
 * created 2021-12-27 16:29
 *
 * @author Alexander A. Kropotin
 */
public class StatementsStateNotNullPositiveUTest {

    /**
     * Values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "objectValues")
    public static Object[] values() {
        return new Object[] {
                new String(),
                new StringBuffer(),
                new StringBuilder(),
                Boolean.TRUE,
                Byte.MIN_VALUE,
                Short.MIN_VALUE,
                Character.MIN_VALUE,
                Integer.MIN_VALUE,
                Long.MIN_VALUE,
                Float.MIN_VALUE,
                Double.MIN_VALUE,
                BigInteger.ZERO,
                BigDecimal.ZERO,
                new Object(),
                Collections.EMPTY_LIST,
                Collections.EMPTY_MAP,
                Collections.EMPTY_SET
        };
    }

    /**
     * State not null when object value is not null then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "objectValues")
    public void stateNotNull_whenObjectValueIsNotNull_thenDoNotThrowsException(Object value) {
        Statements.stateNotNull(value);
    }
}
