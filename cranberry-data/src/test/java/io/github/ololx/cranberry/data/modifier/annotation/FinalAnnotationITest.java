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
package io.github.ololx.cranberry.data.modifier.annotation;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * project cranberry
 * created 2022-01-07 14:57
 *
 * @author Alexander A. Kropotin
 */
public class FinalAnnotationITest {

    /**
     * String values object [ ].
     *
     * @return the object [ ]
     */
    @DataProvider(name = "values")
    public static Object[] values() {
        return new Object[] {
                "",
                new StringBuffer().toString(),
                new StringBuilder().toString(),
                true,
                false,
                Byte.MIN_VALUE,
                Character.MIN_VALUE,
                Integer.MIN_VALUE,
                Long.MIN_VALUE,
                BigInteger.ZERO,
                BigDecimal.ZERO
        };
    }

    /**
     * Final when param value do not changed then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "values")
    public void final_whenParamValueDoNotChanged_thenDoNotThrowsException(@Final Object value) {
        return;
    }

    /**
     * Final when local variable value do not changed then do not throws exception.
     *
     * @param value the value
     */
    @Test(dataProvider = "values")
    public void final_whenLocalVariableValueDoNotChanged_thenDoNotThrowsException(Object value) {
        @Final Object finalValue = value;

        return;
    }
}
