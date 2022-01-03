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

import io.github.ololx.cranberry.statement.internal.exception.NotBlankStatementException;
import io.github.ololx.cranberry.statement.internal.util.Statements;
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

    private final static Logger log = Logger.getLogger(ValueWrapperUTest.class.getName());

    @DataProvider(name = "values")
    public static Object[] values() {
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
                }
        };
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
}
