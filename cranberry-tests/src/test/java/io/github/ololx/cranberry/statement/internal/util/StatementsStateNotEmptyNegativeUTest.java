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

import io.github.ololx.cranberry.statement.internal.exception.NotEmptyStatementException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * project cranberry
 * created 2021-12-27 16:29
 *
 * @author Alexander A. Kropotin
 */
public class StatementsStateNotEmptyNegativeUTest {

    /**
     * String values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "stringValues")
    public static Object[] stringValues() {
        return new Object[] {
                "",
                new StringBuffer().toString(),
                new StringBuilder().toString()
        };
    }

    /**
     * Collection values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "collectionValues")
    public static Object[] collectionValues() {
        return new Object[] {
                Collections.EMPTY_LIST,
                Collections.EMPTY_SET,
                new ArrayList<>(),
                new HashSet<>(),
                new TreeSet<>(),
                new Vector<>()
        };
    }

    /**
     * Map values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "mapValues")
    public static Object[] mapValues() {
        return new Object[] {
                Collections.EMPTY_MAP,
                new HashMap<>(),
                new TreeMap<>()
        };
    }

    /**
     * Array values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "arrayValues")
    public static Object[] arrayValues() {
        return new Object[] {
                new Object[]{},
                new Boolean[]{},
                new Byte[]{},
                new Character[]{},
                new Integer[]{},
                new Long[]{},
                new Float[]{},
                new Double[]{},
                new BigInteger[]{},
                new BigDecimal[]{},
                new String[]{}
        };
    }

    /**
     * State not empty when string value is empty then throws exception.
     *
     * @param value the value
     */
    @Test(
            dataProvider = "stringValues",
            expectedExceptions = NotEmptyStatementException.class
    )
    public void stateNotEmpty_whenStringValueIsEmpty_thenThrowsException(String value) {
        Statements.stateNotEmpty(value);
    }

    /**
     * State not empty when collection value is empty then throws exception.
     *
     * @param value the value
     */
    @Test(
            dataProvider = "collectionValues",
            expectedExceptions = NotEmptyStatementException.class
    )
    public void stateNotEmpty_whenCollectionValueIsEmpty_thenThrowsException(Collection value) {
        Statements.stateNotEmpty(value);
    }

    /**
     * State not empty when map value is empty then throws exception.
     *
     * @param value the value
     */
    @Test(
            dataProvider = "mapValues",
            expectedExceptions = NotEmptyStatementException.class
    )
    public void stateNotEmpty_whenMapValueIsEmpty_thenThrowsException(Map value) {
        Statements.stateNotEmpty(value);
    }

    /**
     * State not empty when array value is empty then throws exception.
     *
     * @param value the value
     */
    @Test(
            dataProvider = "arrayValues",
            expectedExceptions = NotEmptyStatementException.class
    )
    public void stateNotEmpty_whenArrayValueIsEmpty_thenThrowsException(Object[] value) {
        Statements.stateNotEmpty(value);
    }
}
