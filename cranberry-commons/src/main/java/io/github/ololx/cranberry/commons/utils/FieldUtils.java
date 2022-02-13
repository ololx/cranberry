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
package io.github.ololx.cranberry.commons.utils;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * project cranberry
 * created 05.02.2022 22:35
 *
 * @author Alexander A. Kropotin
 */
public final class FieldUtils {

    private static final Logger log;

    static {
        log = Logger.getLogger(ClassUtils.class.getCanonicalName());
    }

    public static<T, S> Optional<T> getFieldValue(S obj, String fieldName) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            log.fine("Get field - " + field + " for name - " + fieldName);

            field.setAccessible(true);
            T value = (T) field.get(obj);
            log.fine("Get value - " + value);

            return Optional.ofNullable(value);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            log.severe("Catch exception - " + e.getLocalizedMessage());

            return Optional.empty();
        }
    }
}
