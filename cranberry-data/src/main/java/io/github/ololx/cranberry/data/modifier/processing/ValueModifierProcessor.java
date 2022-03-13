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
package io.github.ololx.cranberry.data.modifier.processing;

import com.sun.source.util.JavacTask;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;
import com.sun.source.util.Trees;
import com.sun.tools.javac.processing.JavacProcessingEnvironment;
import com.sun.tools.javac.tree.TreeMaker;
import io.github.ololx.cranberry.commons.engine.AbstractProcessor;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

import static com.sun.source.util.TaskEvent.Kind.ENTER;

/**
 * project cranberry
 * created 2022-01-04 16:54
 *
 * @author Alexander A. Kropotin
 */
@SupportedAnnotationTypes({"io.github.ololx.cranberry.data.modifier.annotation.Final"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public final class ValueModifierProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment env) {
        super.init(env);

        Trees trees = Trees.instance(env);

        TreeMaker treeMaker = TreeMaker.instance(((JavacProcessingEnvironment) env).getContext());

        JavacTask.instance(env).addTaskListener(new TaskListener() {

            @Override
            public void started(TaskEvent taskEvent) {
                // Nothing to do on task started event.
            }

            @Override
            public void finished(TaskEvent taskEvent) {
                if (taskEvent.getKind() == ENTER) {
                    new VariableElementScanner(
                            trees,
                            new VariableElementTranslator(treeMaker),
                            processedElements
                    ).scan(taskEvent.getCompilationUnit(), null);
                }
            }

        });
    }
}
