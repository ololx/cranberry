package io.github.ololx.cranberry.statement.processing;

import com.sun.source.util.JavacTask;
import io.github.ololx.cranberry.commons.engine.AbstractProcessor;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;

/**
 * The type State processor.
 *
 * project cranberry
 * created 2020 -03-09 20:21
 *
 * @author Alexander A. Kropotin
 */
@SupportedAnnotationTypes({
        "io.github.ololx.cranberry.statement.annotation.NotNull",
        "io.github.ololx.cranberry.statement.annotation.NotEmpty",
        "io.github.ololx.cranberry.statement.annotation.NotBlank",
        "io.github.ololx.cranberry.statement.annotation.True"
})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public final class StatementProcessor extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        CranberryStatementTaskListener task = new CranberryStatementTaskListener();
        task.init(processingEnv, this.getTargetAnnotationTypes());

        JavacTask.instance(processingEnv).addTaskListener(task);
    }
}