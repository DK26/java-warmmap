package com.exercise.warmmap;

import java.util.Stack;

public class Warmest<K, V> {

    // TODO: `warmest` is some kind of stack (hidden exercise)
    private final Stack<Entry<K, V>> warmest_stack;
    private Entry<K, V> dummy_value;

    public Warmest() {
        this.warmest_stack = new Stack<>();
    }

    public Warmest put(K key, V value) {

        Entry<K, V> entry = new Entry<>(key, value);

        this.warmest_stack.push(entry);

        this.dummy_value = entry;
        // TODO: Assign value to data structure

        return this;
    }

    public V get(K key) {

        // TODO: Replace `result` with actual map algorithm
        Entry<K, V> result = null;

        if (result != null) {
            this.warmest_stack.push(result);
        }

        // TODO: Returns either a value or null
        return result.value();
    }

    public V remove(K key) {
        // TODO: Update Warmest with second warmest

        // TODO: Return value or null
        return null;
    }

    public V getWarmest() {
        // Peak in a stack is considered an O(1) operation.
        return this.warmest_stack.peek().value();
    }
}
