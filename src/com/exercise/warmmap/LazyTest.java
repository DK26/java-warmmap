/**
 * This lazy test library was created because I failed to figure out how to do it the Java way,
 * while I needed some kind of solution.
 */
package com.exercise.warmmap;

public class LazyTest {
    public static void assert_eq(Object left, Object right) throws Exception {
        if (left != right) {
            throw new Exception(String.format("%s (left) != %s (right)%n", left.toString(), right.toString()));
        }
    }

    public static void assert_con(boolean condition, String exceptionMsg) throws Exception {
        if (!condition) {
            throw new Exception(exceptionMsg);
        }
    }
}
