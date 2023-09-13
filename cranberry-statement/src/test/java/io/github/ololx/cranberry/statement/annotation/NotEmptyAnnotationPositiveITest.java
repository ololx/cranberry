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
package io.github.ololx.cranberry.statement.annotation;

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
public class NotEmptyAnnotationPositiveITest extends NotEmptyAnnotationITest {

    /**
     * String values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "stringValues")
    public static Object[] stringValues() {
        return new Object[] {
                " ",
                new StringBuffer(" ").toString(),
                new StringBuilder(" ").toString()
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
                new ArrayList<Object>() {{
                    add(new Object());
                }},
                new HashSet<Object>() {{
                    add(new Object());
                }},
                new TreeSet<Object>() {{
                    add(Integer.MIN_VALUE);
                }},
                new Vector<Object>() {{
                    add(new Object());
                }}
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
                new HashMap<Object, Object>() {{
                    put(null, new Object());
                }},
                new TreeMap<Object, Object>() {{
                    put(Integer.MIN_VALUE, new Object());
                }}
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
                new Object[]{" "},
                new Boolean[]{true},
                new Byte[]{1},
                new Character[]{'a'},
                new Integer[]{1},
                new Long[]{1L},
                new Float[]{.1f},
                new Double[]{.1d},
                new BigInteger[]{BigInteger.ONE},
                new BigDecimal[]{BigDecimal.ONE},
                new String[]{" "}
        };
    }

    /**
     * Method param not empty when string value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "stringValues")
    public void methodParamNotEmpty_whenStringValueIsNotEmpty_thenDoNotThrowsException(String value) {
        this.executeWithAnnotatedParam(value);
    }

    /**
     * Method param not empty when collection value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "collectionValues")
    public void methodParamNotEmpty_whenCollectionValueIsNotEmpty_thenDoNotThrowsException(Collection value) {
        this.executeWithAnnotatedParam(value);
    }

    /**
     * Method param not empty when map value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "mapValues")
    public void methodParamNotEmpty_whenMapValueIsNotEmpty_thenDoNotThrowsException(Map value) {
        this.executeWithAnnotatedParam(value);
    }

    /**
     * Method param not empty when array value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "arrayValues")
    public void methodParamNotEmpty_whenArrayValueIsNotEmpty_thenDoNotThrowsException(Object[] value) {
        this.executeWithAnnotatedParam(value);
    }

    /**
     * Local variable not empty when string value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "stringValues")
    public void localVariableNotEmpty_whenStringValueIsNotEmpty_thenDoNotThrowsException(String value) {
        this.executeWithAnnotatedLocalVariable(value);
    }

    /**
     * Local variable not empty when collection value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "collectionValues")
    public void localVariableNotEmpty_whenCollectionValueIsNotEmpty_thenDoNotThrowsException(Collection value) {
        this.executeWithAnnotatedLocalVariable(value);
    }

    /**
     * Local variable not empty when map value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "mapValues")
    public void localVariableNotEmpty_whenMapValueIsNotEmpty_thenDoNotThrowsException(Map value) {
        this.executeWithAnnotatedLocalVariable(value);
    }

    /**
     * Local variable not empty when array value is not empty then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "arrayValues")
    public void localVariableNotEmpty_whenArrayValueIsNotEmpty_thenDoNotThrowsException(Object[] value) {
        this.executeWithAnnotatedLocalVariable(value);
    }
}
