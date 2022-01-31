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

import java.util.Optional;
import java.util.logging.Logger;

/**
 * project cranberry
 * created 2022-01-27 21:04
 *
 * @author Alexander A. Kropotin
 * @since
 */
public final class ClassInstance {

    private static final Logger log;

    static {
        log = Logger.getLogger(ClassInstance.class.getCanonicalName());
    }

    public static<T> Optional<Class<T>> newClassForName(String className) {
        try {
            final Class<T> clazz = (Class<T>) Class.forName(className);
            log.fine("Get .class - " + clazz + " for name - " + className);

            return Optional.ofNullable(clazz);
        } catch (ClassNotFoundException e) {
            log.severe("Catch exception - " + e.toString());

            return Optional.empty();
        }
    }
}
