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
package io.github.ololx.cranberry.commons.engine;

import io.github.ololx.cranberry.commons.utils.FieldInstance;

import javax.annotation.processing.ProcessingEnvironment;
import java.lang.reflect.Proxy;
import java.util.Optional;

/**
 * project cranberry
 * created 05.02.2022 22:23
 *
 * @author Alexander A. Kropotin
 */
public interface ProcessingEnvironmentUnwrapper {

    static ProcessingEnvironment unwrap(ProcessingEnvironment processingEnv) {
        if (processingEnv == null) {
            throw new NullPointerException("The processing environment must be defined");
        }

        if (!Proxy.isProxyClass(processingEnv.getClass())) {
            return processingEnv;
        }

        Optional<ProcessingEnvironment> originProcessingEnv = FieldInstance.getFieldValue(
                Proxy.getInvocationHandler(processingEnv),
                "val$delegateTo"
        );

        return originProcessingEnv.orElse(null);
    }

}

