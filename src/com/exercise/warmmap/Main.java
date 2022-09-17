package com.exercise.warmmap;

import static com.exercise.warmmap.LazyTest.assert_eq;

public class Main {

    public static void main(String[] args) throws Exception {

        Warmest<Integer, String> warmest = new Warmest<>();

        warmest.put(1, "hello");
        assert_eq(warmest.getWarmest(), "hello",
                "warmest.put(1, \"hello\"); warmest.getWarmest() != \"hello\"");

        warmest.put(2, "warmest");
        assert_eq(warmest.getWarmest(), "warmest",
                "warmest.put(2, \"warmest\"); warmest.getWarmest() != \"warmest\"");

        assert_eq(warmest.get(1), "hello",
                "warmest.get(1) != \"hello\"");

        assert_eq(warmest.getWarmest(), "hello",
                "warmest.getWarmest() \"hello\"");

        assert_eq(warmest.remove(1), "hello",
                "warmest.remove(1) != \"hello\"");

        assert_eq(warmest.getWarmest(), "warmest",
                "warmest.getWarmest() != \"warmest\"");

        System.out.println("Tested Successfully!");

    }

}