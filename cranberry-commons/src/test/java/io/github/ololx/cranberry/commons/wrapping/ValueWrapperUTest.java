/**
 * Copyright 2022 the project cranberry authors
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
package io.github.ololx.cranberry.commons.wrapping;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.logging.Logger;

import static org.testng.Assert.assertTrue;

/**
 * project cranberry
 * created 2022-01-02 13:51
 *
 * @author Alexander A. Kropotin
 */
public class ValueWrapperUTest {

    private final static Logger log;

    static {
        log = Logger.getLogger(ValueWrapperUTest.class.getName());
    }

    @DataProvider(name = "values")
    public static Object[][] values() {
        int[] primitiveArray = new int[] {0, 1, 2};
        Integer[] wrappedArray = new Integer[] {0, 1, 2};

        return new Object[][] {
                {
                        ValueWrapper.getInstance(Boolean.TRUE),
                        ValueWrapper.getInstance(ValueWrapper.getInstance(Boolean.TRUE))
                },
                {
                    Boolean.TRUE,
                        ValueWrapper.getInstance(Boolean.TRUE)
                },
                {
                    Byte.MIN_VALUE,
                        ValueWrapper.getInstance(Byte.MIN_VALUE)
                },
                {
                    Character.MIN_VALUE,
                        ValueWrapper.getInstance(Character.MIN_VALUE)
                },
                {
                    Integer.MIN_VALUE,
                        ValueWrapper.getInstance(Integer.MIN_VALUE)
                },
                {
                    Long.MIN_VALUE,
                        ValueWrapper.getInstance(Long.MIN_VALUE)
                },
                {
                    0L,
                        ValueWrapper.getInstance(0L)
                },
                {
                    BigDecimal.ZERO,
                        ValueWrapper.getInstance(BigDecimal.ZERO)
                },
                {
                    BigInteger.ZERO,
                        ValueWrapper.getInstance(BigInteger.ZERO)
                },
                {
                    0,
                        ValueWrapper.getInstance(0)
                },
                {
                    wrappedArray,
                        ValueWrapper.getInstance(wrappedArray)
                },
                {
                    primitiveArray,
                    ValueWrapper.getInstance(primitiveArray)
                }
        };
    }

    @DataProvider(name = "testTypeValues")
    public static Object[][] testTypeValues() {
        return new Object[][] {
                {
                        null,
                        false
                },
                {
                        ValueWrapper.getInstance(null),
                        false
                },
                {
                        ValueWrapper.getInstance(Boolean.TRUE),
                        true
                },
                {
                        ValueWrapper.getInstance(Byte.MIN_VALUE),
                        true
                }
        };
    }

    @Test(dataProvider = "testTypeValues")
    public void isValueDefined_whenValueWrapperCreatedFromValue_thenItHasATypeForThisValue(Object value,
                                                                                          Boolean expectedTypeExistance) {
        log.info(
                String.format(
                        "Start test running with params:\nvalue - %s\nexpectedTypeExistance - %s",
                        value,
                        expectedTypeExistance
                )
        );

        Boolean actualTypeExistance = ValueWrapper.getInstance(value).isEmpty();
        log.info(String.format("Got actual value:\nactualTypeExistance - %s", actualTypeExistance));

        assertTrue(
                expectedTypeExistance.equals(actualTypeExistance),
                "The ValueWrapper has wrong type"
        );
    }

    @Test(dataProvider = "testTypeValues")
    public void isValueUndefined_whenValueWrapperCreatedFromValue_thenItHasATypeForThisValue(Object value,
                                                                                            Boolean expectedTypeExistance) {
        log.info(
                String.format(
                        "Start test running with params:\nvalue - %s\nexpectedTypeExistance - %s",
                        value,
                        expectedTypeExistance
                )
        );

        Boolean actualTypeExistance = ValueWrapper.getInstance(value).isPresent();
        log.info(String.format("Got actual value:\nactualTypeExistance - %s", actualTypeExistance));

        assertTrue(
                expectedTypeExistance.equals(!actualTypeExistance),
                "The ValueWrapper has wrong type"
        );
    }

    @Test(dataProvider = "values")
    public void getValue_whenValueWrappersCreatedFromOneValue_thenTheyValuesAreEquals(Object value,
                                                                                      ValueWrapper expectedValueWrapper) {
        log.info(
                String.format(
                        "Start test running with params:\nvalue - %s\nexpectedValueWrapper - %s",
                        value,
                        expectedValueWrapper
                )
        );

        ValueWrapper actualValueWrapper = ValueWrapper.getInstance(value);
        log.info(String.format("Got actual value:\nactualValueWrapper - %s", actualValueWrapper));

        assertTrue(
                expectedValueWrapper.getValue().equals(actualValueWrapper.getValue()),
                "The ValueWrapper instances have different values"
        );
    }

    @Test(dataProvider = "values")
    public void getType_whenValueWrappersCreatedFromOneValue_thenTheyTypesAreEquals(Object value,
                                                                                    ValueWrapper expectedValueWrapper) {
        log.info(
                String.format(
                        "Start test running with params:\nvalue - %s\nexpectedValueWrapper - %s",
                        value,
                        expectedValueWrapper
                )
        );

        ValueWrapper actualValueWrapper = ValueWrapper.getInstance(value);
        log.info(String.format("Got actual value:\nactualValueWrapper - %s", actualValueWrapper));

        assertTrue(
                expectedValueWrapper.getType().equals(actualValueWrapper.getType()),
                "The ValueWrapper instances have different types"
        );
    }

    @Test(dataProvider = "values")
    public void getValueStringRepresentation_whenValueWrappersCreatedFromOneValue_thenTheyValuesStringRepresentationAreEquals(Object value,
                                                                                                                              ValueWrapper expectedValueWrapper) {
        log.info(
                String.format(
                        "Start test running with params:\nvalue - %s\nexpectedValueWrapper - %s",
                        value,
                        expectedValueWrapper
                )
        );

        ValueWrapper actualValueWrapper = ValueWrapper.getInstance(value);
        log.info(String.format("Got actual value:\nactualValueWrapper - %s", actualValueWrapper));

        assertTrue(
                expectedValueWrapper.getValueStringRepresentation()
                        .equals(actualValueWrapper.getValueStringRepresentation()),
                "The ValueWrapper instances are different"
        );
    }

    @Test(dataProvider = "values")
    public void equals_whenValueWrappersCreatedFromOneValue_thenTheyAreEquals(Object value,
                                                                              ValueWrapper otherValueWrapper) {
        log.info(
                String.format(
                        "Start test running with params:\nvalue - %s\notherValueWrapper - %s",
                        value,
                        otherValueWrapper
                )
        );

        ValueWrapper actualValueWrapper = ValueWrapper.getInstance(value);
        log.info(String.format("Got actual value:\nactualValueWrapper - %s", actualValueWrapper));

        assertTrue(
                otherValueWrapper.equals(actualValueWrapper),
                "The ValueWrapper instances are not equals"
        );
    }

    @Test(dataProvider = "values")
    public void hashCode_whenValueWrappersCreatedFromOneValue_thenTheyAreEqualsHasCode(Object value,
                                                                              ValueWrapper otherValueWrapper) {
        log.info(
                String.format(
                        "Start test running with params:\nvalue - %s\notherValueWrapper - %s",
                        value,
                        otherValueWrapper
                )
        );

        int actualValueWrapperHashCode = ValueWrapper.getInstance(value).hashCode();
        log.info(String.format("Got actual value:\nactualValueWrapperHashCode - %s", actualValueWrapperHashCode));

        assertTrue(
            actualValueWrapperHashCode == otherValueWrapper.hashCode(),
                "The ValueWrapper instances are not equals"
        );
    }

    @Test
    public void equalsHashCodeContracts() {
        EqualsVerifier.forClass(ValueWrapper.class)
            .withNonnullFields("value", "type")
            .verify();
    }
}
