package io.github.ololx.cranberry.statement.processing;

import com.sun.source.util.JavacTask;
import io.github.ololx.cranberry.commons.engine.AbstractTrickyProcessor;
import io.github.ololx.cranberry.statement.annotation.NotBlank;
import io.github.ololx.cranberry.statement.annotation.NotEmpty;
import io.github.ololx.cranberry.statement.annotation.NotNull;
import io.github.ololx.cranberry.statement.annotation.True;

import javax.annotation.processing.ProcessingEnvironment;
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
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public final class StatementProcessor extends AbstractTrickyProcessor {

    public static final Set<Class> SUPPORTED_ANNOTATIONS = new HashSet<Class>() {
        {
            add(NotNull.class);
            add(NotEmpty.class);
            add(NotBlank.class);
            add(True.class);
        }
    };


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return SUPPORTED_ANNOTATIONS.stream()
                .map(eachAnnotation -> eachAnnotation.getCanonicalName())
                .collect(Collectors.toSet());
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        CranberryStatementTaskListener task = new CranberryStatementTaskListener();
        task.init(processingEnv, SUPPORTED_ANNOTATIONS);

        JavacTask.instance(processingEnv).addTaskListener(task);
    }
}