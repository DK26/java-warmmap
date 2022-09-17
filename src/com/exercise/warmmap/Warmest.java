package com.exercise.warmmap;

import java.util.EmptyStackException;
import java.util.Stack;

public class Warmest<K, V> {

    // TODO: `warmest` is some kind of stack (hidden exercise)
    private final Stack<Entry<K, V>> warmest_stack;

    public Warmest() {
        this.warmest_stack = new Stack<>();
    }

    public Warmest put(K key, V value) {

        Entry<K, V> entry = new Entry<>(key, value);

        this.warmest_stack.push(entry);

        // TODO: Assign value to data structure

        return this;
    }

    public V get(K key) {

        Entry<K, V> found_entry = null; // TODO: Replace `null` with `get_entry()` implementation

        V result = null;

        if (found_entry != null) {
            result = found_entry.value();
            this.warmest_stack.push(found_entry);
        }

        // TODO: Returns either a value or null
        return result;
    }

    public V remove(K key) {
        Entry<K, V> found_entry = null; // TODO: Replace `null` with `get_entry()` implementation

        if (found_entry == null) {
            return null;
        }

        // Remove any trace of the object from the stack
        while(this.warmest_stack.remove(found_entry));

        // TODO: Remove key from map

        return found_entry.value();
    }

    public V getWarmest() {
        // Peak in a stack is considered an O(1) operation.
        try {
            return this.warmest_stack.peek().value();
        }catch (EmptyStackException e) {
            return null;
        }
    }
}
