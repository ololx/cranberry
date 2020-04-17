/**
 * Copyright 2020 the project cranberry authors
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

import org.cranberry.statement.annotation.NotEmpty;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @project cranberry
 * @created 2020-04-06 07:27
 * <p>
 * @author Alexander A. Kropotin
 */
public class NotEmptyAnnotationExampleForParameters {

    public static void main(String args[]) {

        if (args.length < 2)
            return;

        if (args[0].equals(String.valueOf(0))) {
            /**
             * Execute example of {@code @NotEmpty} annotation usage.
             * <p>
             * This example will execute if {@code arg[0] = 0}. An value of the {@code arg[1]}
             * will be used for the value of the parameter {@code @NotEmpty List<String> param}.
             * <p>
             * Run the {@code NotEmptyAnnotationExampleForParameters} with
             * the following {@link args[]} parameters:
             * <ul>
             *     <li>
             *         `0 ""`, for example `1 ""` - to faced with an {@code @NotEmptyStatementException};
             *     </li>
             *     <li>
             *         `0 char sequence`, for example `1 1,2,3` - to execute example without exceptions.
             *     </li>
             * </ul>
             */
            runWithoutCustomMessage(
                    !args[1].equals("")
                            ? Arrays.stream(args).collect(Collectors.toList())
                            : Collections.EMPTY_LIST
            );
        }

        if (args[0].equals(String.valueOf(1))) {
            /**
             * Execute example of {@code @NotEmpty} annotation usage.
             * <p>
             * This example will execute if {@code arg[0] = 1}. An value of the {@code arg[1]}
             * will be used for the parameter value of a method {@link #runWithCustomMessage(List)}.
             * <p>
             * Run the {@code NotEmptyAnnotationExampleForParameters} with
             * the following {@link args[]} parameters:
             * <ul>
             *     <li>
             *         `1 ""`, for example `1 ""` - to faced with an {@code @NotEmptyStatementException};
             *     </li>
             *     <li>
             *         `1 char sequence`, for example `1 1,2,3` - to execute example without exceptions.
             *     </li>
             * </ul>
             */
            runWithCustomMessage(
                    !args[1].equals("")
                            ? Arrays.stream(args[1].split(",")).collect(Collectors.toList())
                            : Collections.EMPTY_LIST
            );
        }
    }

    /**
     * The example of {@code @NotEmpty} annotation usage on {@code List<String> param}.
     * <p>
     * If the annotated {@code param} is an empty list,
     * the {@code NotEmptyStatementException} will be thrown with
     * a localized default {@code NotEmptyStatementException} detail.
     */
    public static void runWithoutCustomMessage(@NotEmpty List<String> param) {
        param.stream()
                .forEach(eachParam -> {
                    System.out.println(eachParam);
                });
    }

    /**
     * The example of {@code @NotEmpty} annotation usage on {@code List<String> param}.
     * <p>
     * If the annotated {@code param} is an empty list,
     * the {@code NotEmptyStatementException} will be thrown with
     * a specified custom message.
     */
    public static void runWithCustomMessage(
            @NotEmpty(message = "This param couldn't be empty") List<String> param) {
        param.stream()
                .forEach(eachParam -> {
                    System.out.println(eachParam);
                });
    }
}
