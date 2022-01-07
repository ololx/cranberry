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
package io.github.ololx.cranberry.commons.processing;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * An abstract annotation processor designed to be a convenient
 * superclass for most concrete annotation processors.  This class
 * examines annotation values to compute the {@linkplain
 * #getSupportedOptions options}, {@linkplain
 * #getSupportedAnnotationTypes annotation types}, and {@linkplain
 * #getSupportedSourceVersion source version} supported by its
 * subtypes.
 *
 * Subclasses are free to override the implementation and
 * specification of any of the methods in this class as long as the
 * general {@link javax.annotation.processing.Processor Processor}
 * contract for that method is obeyed.
 *
 * created 2022-01-04 21:33
 *
 * @author Alexander A. Kropotin
 * @since 0.8.0
 */
public abstract class AbstractCranberryProcessor implements Processor {

    /**
     * An annotation processing tool framework.
     */
    protected ProcessingEnvironment processingEnv;

    /**
     * The Processed elements.
     */
    protected volatile static Map<Element, Set<Class<?>>> processedElements;

    static {
        processedElements = new ConcurrentHashMap<Element, Set<Class<?>>>();
    }

    /**
     * Constructor for subclasses to call.
     */
    protected AbstractCranberryProcessor() {}

    /**
     * Returns the options recognized by this processor.
     *
     * <ul>
     *     <li>
     *         If the processor class is annotated with {@link SupportedOptions},
     *         return an unmodifiable set with the same set of strings as the annotation.
     *     </li>
     *     <li>
     *         In other cases an empty set is returned.
     *     </li>
     * </ul>
     *
     * @return the options recognized by this processor or an
     * empty collection if none
     * @see javax.annotation.processing.SupportedOptions
     * @see Processor#getSupportedOptions
     */
    @Override
    public Set<String> getSupportedOptions() {
        SupportedOptions supportedOptions = this.getClass().getAnnotation(SupportedOptions.class);

        Set<String> options = Collections.emptySet();
        if (supportedOptions != null) {
            options = Arrays.stream(supportedOptions.value())
                    .parallel()
                    .collect(Collectors.toSet());
        }

        return options;
    }

    /**
     * Returns the names of the annotation types supported by this processor.
     *
     * <ul>
     *     <li>
     *         If the processor class is annotated with {@link SupportedAnnotationTypes},
     *         return an unmodifiable set with the same set of strings as the annotation.
     *     </li>
     *     <li>
     *         In other cases an empty set is returned.
     *     </li>
     * </ul>
     *
     * If the {@link ProcessingEnvironment#getSourceVersion source
     * version} does not support modules, in other words if it is less
     * than or equal to {@link SourceVersion#RELEASE_8 RELEASE_8},
     * then any leading {@link Processor#getSupportedAnnotationTypes
     * module prefixes} are stripped from the names.
     *
     * @return the names of the annotation types supported by this
     * processor, or an empty set if none
     * @see javax.annotation.processing.SupportedAnnotationTypes
     * @see Processor#getSupportedAnnotationTypes
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        SupportedAnnotationTypes supportedAnnotationTypes = this.getClass().getAnnotation(
                SupportedAnnotationTypes.class
        );
        boolean isNeededToStripPrefix = this.isUsableReady()
                && this.processingEnv.getSourceVersion().compareTo(SourceVersion.RELEASE_8) <= 0;

        Set<String> annotationTypes = Collections.emptySet();
        if (supportedAnnotationTypes != null) {
            annotationTypes = Arrays.stream(supportedAnnotationTypes.value())
                    .parallel()
                    .map(s -> {
                        int prefixIndex = s.indexOf('/');
                        if (prefixIndex < 0 || !isNeededToStripPrefix) {
                            return s;
                        }

                        return s.substring(prefixIndex + 1);
                    })
                    .collect(Collectors.toSet());
        }

        return annotationTypes;
    }

    /**
     * Returns the specified (or default {@link SourceVersion#RELEASE_8}) version
     * supported by this annotation processor.
     *
     * <ul>
     *     <li>
     *         If the processor class is marked with {@link SupportedSourceVersion},
     *         returns the original version following the rule:
     *         <ul>
     *             <li>
     *                 Returns the source version in the annotation,
     *                 if the specified {@link SourceVersion} >= {@link SourceVersion#RELEASE_8}
     *             </li>
     *             <li>
     *                 Returns the source version {@link SourceVersion#RELEASE_8},
     *                 if the specified {@link SourceVersion} >= {@link SourceVersion#RELEASE_8}
     *             </li>
     *         </ul>
     *         If the processor class is annotated with {@link SupportedSourceVersion},
     *         and specified {@link SourceVersion} >= {@link SourceVersion#RELEASE_8}
     *         return the source version in the annotation.
     *     </li>
     *     <li>
     *         If the processor class is annotated with {@link SupportedSourceVersion},
     *         and specified {@link SourceVersion} >= {@link SourceVersion#RELEASE_8}
     *         return the source version in the annotation.
     *     </li>
     *     <li>
     *         In other cases the {@link SourceVersion#RELEASE_8} is returned.
     *     </li>
     * </ul>
     *
     * @return the source version supported by this annotation processor
     * @see javax.annotation.processing.SupportedSourceVersion
     * @see ProcessingEnvironment#getSourceVersion
     * @see Processor#getSupportedSourceVersion()
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        SupportedSourceVersion supportedSourceVersion = this.getClass().getAnnotation(
                SupportedSourceVersion.class
        );

        SourceVersion sourceVersion = SourceVersion.RELEASE_8;
        if (supportedSourceVersion == null) {
            sourceVersion = supportedSourceVersion.value().compareTo(sourceVersion) <= 0
                    ? sourceVersion
                    : supportedSourceVersion.value();
        }

        return sourceVersion;
    }

    /**
     * Initializes the processor with the processing environment.
     *
     * @param processingEnv environment for facilities the tool framework
     * provides to the processor
     */
    @Override
    public void init(ProcessingEnvironment processingEnv) {
        if (this.isUsableReady()) {
            return;
        }

        Objects.requireNonNull(processingEnv, "The annotation processing tools couldn't be null");
        this.processingEnv = processingEnv;
    }

    /**
     * Returns always false.
     *
     * The cranberry processing don't care about this method, as it will never be
     * invoked for cranberry annotation.
     * It is planned that this method will not be called to the processing annotations.
     *
     * @param annotations {@inheritDoc}
     * @param roundEnv {@inheritDoc}
     * @return whether or not the set of annotation types are claimed by this processor
     * @see javax.lang.model.element.TypeElement
     * @see javax.annotation.processing.RoundEnvironment
     * @see javax.annotation.processing.Processor#process
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        //Always returns false
        return false;
    }

    /**
     * Returns an empty iterable of completions.
     *
     * @param element {@inheritDoc}
     * @param annotation {@inheritDoc}
     * @param member {@inheritDoc}
     * @param userText {@inheritDoc}
     * @return suggested completions to the annotation
     * @see javax.annotation.processing.Completion
     * @see javax.annotation.processing.Completions
     * @see javax.annotation.processing.Processor#getCompletions
     */
    @Override
    public Iterable<? extends Completion> getCompletions(Element element,
                                                         AnnotationMirror annotation,
                                                         ExecutableElement member,
                                                         String userText) {
        return Collections.emptyList();
    }

    /**
     * Returns the flag that says that the processor is ready for use,
     * i.e. it was initialized.
     *
     * <uL>
     *     <li>
     *         Returns {@code true} if {@link #init} was invoked for this processor.
     *     </li>
     *     <li>
     *         Returns {@code false} in other case.
     *     </li>
     * </uL>
     *
     * @return {@code true} if {@link #init} was invoked for this processor,
     * {@code false} otherwise.
     */
    protected synchronized boolean isUsableReady() {
        return this.processingEnv != null;
    }
}