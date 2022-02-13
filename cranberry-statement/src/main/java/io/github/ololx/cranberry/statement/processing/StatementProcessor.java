package io.github.ololx.cranberry.statement.processing;

import com.sun.source.util.JavacTask;
import io.github.ololx.cranberry.commons.engine.AbstractTrickyProcessor;
import io.github.ololx.cranberry.commons.engine.TargetAnnotationTypes;
import io.github.ololx.cranberry.statement.annotation.NotBlank;
import io.github.ololx.cranberry.statement.annotation.NotEmpty;
import io.github.ololx.cranberry.statement.annotation.NotNull;
import io.github.ololx.cranberry.statement.annotation.True;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
public final class StatementProcessor extends AbstractTrickyProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        CranberryStatementTaskListener task = new CranberryStatementTaskListener();
        task.init(processingEnv, this.getTargetAnnotationTypes());

        JavacTask.instance(processingEnv).addTaskListener(task);
    }
}