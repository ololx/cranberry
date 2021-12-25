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
package io.github.ololx.cranberry.logging.wrapper;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * The interface Logging processor.
 *
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2020-04-27 20:31
 * @author Alexander A. Kropotin
 */
public final class LoggerWrapper {

    private final String sourceClassName;

    private final Logger logger;

    public static LoggerWrapper getInstance(Logger logger) {
        return new LoggerWrapper(logger);
    }

    public static LoggerWrapper getInstance(Class<?> clazz) {
        return new LoggerWrapper(clazz);
    }

    public static LoggerWrapper getInstance(String className) {
        return new LoggerWrapper(className);
    }

    LoggerWrapper(Logger logger) {
        this(logger, null);
    }

    LoggerWrapper(Class<?> clazz) {
        this(clazz.getName());
    }

    LoggerWrapper(String sourceClassName) {
        this(Logger.getLogger(sourceClassName), sourceClassName);
    }

    LoggerWrapper(Logger logger, String sourceClassName) {
        this.logger = logger;
        this.sourceClassName = sourceClassName != null
                ? sourceClassName
                : logger.getName();
    }

    public void info(String message, String sourceMethodName, Throwable t) {
        log(Level.INFO, message, sourceMethodName, t);
    }

    public void info(String message, String sourceMethodName) {
        info(message, sourceMethodName, null);
    }

    public void info(String message) {
        info(message, null, null);
    }

    public void log(Level level, String message, String sourceMethodName, Throwable throwable) {
        if (logger.isLoggable(level)) {
            logger.log(this.getLogRecord(level, message, sourceMethodName, throwable));
        }
    }

    private LogRecord getLogRecord(Level level, String message, String sourceMethodName, Throwable throwable) {
        LogRecord logRecord = new LogRecord(level, message);

        if (throwable != null) {
            logRecord.setThrown(throwable);
        }

        logRecord.setLoggerName(sourceClassName);
        logRecord.setSourceClassName(sourceClassName);
        logRecord.setSourceMethodName(sourceMethodName);

        return logRecord;
    }

    private LogRecord getLogRecord(Level level, String message, String sourceMethodName) {
        return this.getLogRecord(level, message, sourceMethodName);
    }
}
