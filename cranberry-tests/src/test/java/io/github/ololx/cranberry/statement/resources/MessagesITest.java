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
package io.github.ololx.cranberry.statement.resources;

import io.github.ololx.cranberry.statement.internal.exception.NotBlankStatementException;
import io.github.ololx.cranberry.statement.internal.util.Statements;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.Assert.assertTrue;

/**
 * project cranberry
 * created 2021-12-27 17:48
 *
 * @author Alexander A. Kropotin
 */
public class MessagesITest {

    @DataProvider(name = "localeValues")
    public static Object[][] localeValues() {
        return new Object[][] {
                {messages_en.class, "en"},
                {messages_ru.class, "ru"}
        };
    }

   @Test(dataProvider = "localeValues")
    public void getBundle_whenLocaleValueIsDefine_thenReturnResourceBundleForThisLocale(Class<?> clazz, String value) {
       ResourceBundle resourceBundle = ResourceBundle.getBundle(
               "io.github.ololx.cranberry.statement.resources.messages",
               new Locale(value)
       );

       assertTrue(resourceBundle.getClass().equals(clazz), "The message does not match the locale");
    }
}
