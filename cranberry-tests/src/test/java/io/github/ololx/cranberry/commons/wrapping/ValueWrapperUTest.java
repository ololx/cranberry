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

import org.testng.annotations.DataProvider;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * project cranberry
 * created 2022-01-02 13:51
 *
 * @author Alexander A. Kropotin
 */
public class ValueWrapperUTest {

    @DataProvider(name = "values")
    public static Object[] values() {
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
}
