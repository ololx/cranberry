/**
 * Copyright 2020 the project cranberry authors
 * and the original author or authors annotated by {@author}
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.ololx.cranberry.statement.internal.util;

/**
 * The interface Statement.
 *
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2020 -03-13 09:22
 */
public interface Statement {

    /**
     * The interface Reasoner.
     */
    interface Reasoner {

        /**
         * Is object not null boolean.
         *
         * @param object the object
         * @return the boolean
         */
        static boolean isObjectNotNull(Object object) {
            return !Reasoner.isObjectNull(object);
        }

        /**
         * Is object null boolean.
         *
         * @param object the object
         * @return the boolean
         */
        static boolean isObjectNull(Object object) {
            return object == null;
        }
    }
}
