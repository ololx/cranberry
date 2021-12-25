package io.github.ololx.cranberry.statement.internal.util;

import java.util.Collection;
import java.util.Map;

/**
 * The type Statements.
 *
 * @author Alexander A. Kropotin
 * project cranberry
 * created 2020 -03-09 20:21
 */
public final class Statements {

    /**
     * State not null.
     *
     * @param obj     the obj
     * @param message the message
     */
    //----->NOT NULL STATEMENTS
    public static void stateNotNull(Object obj, String message) {
        NotNullStatement.check(obj, message /*== null ? Messages.NOT_NULL.toString() : message*/);
    }

    /**
     * State not null.
     *
     * @param obj the obj
     */
    public static void stateNotNull(Object obj) {
        stateNotNull(obj, null);
    }

    /**
     * State not empty.
     *
     * @param str     the str
     * @param message the message
     */
    //----->NOT EMPTY STATEMENTS
    public static void stateNotEmpty(String str, String message) {
        NotEmptyStatement.check(str, message/* == null ? Messages.NOT_EMPTY.toString() : message*/);
    }

    /**
     * State not empty.
     *
     * @param arr     the arr
     * @param message the message
     */
    public static void stateNotEmpty(Object[] arr, String message) {
        NotEmptyStatement.check(arr, message);
    }

    /**
     * State not empty.
     *
     * @param map     the map
     * @param message the message
     */
    public static void stateNotEmpty(Map<?, ?> map, String message) {
        NotEmptyStatement.check(map, message);
    }

    /**
     * State not empty.
     *
     * @param collection the collection
     * @param message    the message
     */
    public static void stateNotEmpty(Collection<?> collection, String message) {
        NotEmptyStatement.check(collection, message);
    }

    /**
     * State not empty.
     *
     * @param map the map
     */
    public static void stateNotEmpty(Map<?, ?> map) {
        stateNotEmpty(map, null);
    }

    /**
     * State not empty.
     *
     * @param collection the collection
     */
    public static void stateNotEmpty(Collection<?> collection) {
        stateNotEmpty(collection, null);
    }

    /**
     * State not empty.
     *
     * @param str the str
     */
    public static void stateNotEmpty(String str) {
        stateNotEmpty(str, null);
    }

    /**
     * State not empty.
     *
     * @param arr the str
     */
    public static void stateNotEmpty(Object[] arr) {
        stateNotEmpty(arr, null);
    }

    /**
     * State not blank.
     *
     * @param str     the str
     * @param message the message
     */
    //----->NOT BLANK STATEMENTS
    public static void stateNotBlank(String str, String message) {
        NotBlankStatement.check(str, message/* == null ? Messages.NOT_BLANK.toString() : message*/);
    }

    /**
     * State not blank.
     *
     * @param str the str
     */
    public static void stateNotBlank(String str) {
        stateNotBlank(str, null);
    }

    /**
     * State this is true.
     *
     * @param expr the boolean expression
     */
    //----->TRUE STATEMENTS
    public static void stateTrue(Boolean expr) {
        stateTrue(expr, null);
    }

    /**
     * State this is true.
     *
     * @param expr the boolean expression
     * @param message the message
     */
    public static void stateTrue(Boolean expr, String message) {
        TrueStatement.check(expr, message);
    }
}
