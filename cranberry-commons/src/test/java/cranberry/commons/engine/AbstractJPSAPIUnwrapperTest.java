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
package cranberry.commons.engine;

import javax.annotation.processing.ProcessingEnvironment;

/**
 * project cranberry
 * created 10.02.2022 21:55
 *
 * @author Alexander A. Kropotin
 */
public class AbstractJPSAPIUnwrapperTest {

    /**
     * The interface Wrapper delegate accessor.
     *
     * @param <T> the type parameter
     */
    interface WrapperDelegateAccessor<T> {
        /**
         * Gets wrapper delegate.
         *
         * @return the wrapper delegate
         */
        T getWrapperDelegate();
    }

    /**
     * The type Dynamic wrapper.
     *
     * @param <T> the type parameter
     */
    abstract static class DynamicWrapper<T> implements WrapperDelegateAccessor<T> {

        private final T myDelegate;

        /**
         * Instantiates a new Dynamic wrapper.
         *
         * @param delegate the delegate
         */
        DynamicWrapper(T delegate) {
            myDelegate = delegate;
        }

        @Override
        public final T getWrapperDelegate() {
            return myDelegate;
        }
    }

    /**
     * The type Processing environment wrapper.
     */
    static class ProcessingEnvironmentWrapper extends DynamicWrapper<ProcessingEnvironment> {

        /**
         * Instantiates a new Processing environment wrapper.
         *
         * @param delegate the delegate
         */
        ProcessingEnvironmentWrapper(ProcessingEnvironment delegate) {
            super(delegate);
        }
    }
}
