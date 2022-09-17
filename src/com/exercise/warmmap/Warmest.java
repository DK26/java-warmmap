package com.exercise.warmmap;

import java.util.EmptyStackException;
import java.util.Stack;

// Ideally, I would like to implement either a Swiss hash table map or a B-Tree map,
// but since it turned to be complicated to learn and to implement in a very limited time frame,
// I decided to have something working using the same Stack I used to implement the warmest logical flow.
// Looking back, maybe I should have tried to implement this with my own stack, but I was under the assumption
// that a B-Tree is required and that it could be the most efficient algorithm I hoped I could easily implement.

public class Warmest<K, V> {

    private final Stack<Entry<K, V>> warmest_stack;

    public Warmest() {
        this.warmest_stack = new Stack<>();
    }

    public Warmest put(K key, V value) {

        Entry<K, V> entry = new Entry<>(key, value);

        this.warmest_stack.push(entry);

        return this;
    }

    private Entry<K, V> search_entry(K key) {

        // Inefficient O(n), but working
        for (Entry<K, V> c : this.warmest_stack) {
            if (c.key() == key) {
                return c;
            }
        }
        return null;
    }

    public V get(K key) {

        Entry<K, V> found_entry = search_entry(key);

        V result = null;

        if (found_entry != null) {
            result = found_entry.value();
            this.warmest_stack.push(found_entry);
        }

        return result;
    }

    public V remove(K key) {
        Entry<K, V> found_entry = search_entry(key);

        if (found_entry == null) {
            return null;
        }

        // Remove any trace of the object from the stack
        while(this.warmest_stack.remove(found_entry));

        return found_entry.value();
    }

    public V getWarmest() {
        // `peek()` for a stack is considered an O(1) operation.
        try {
            return this.warmest_stack.peek().value();
        }catch (EmptyStackException e) {
            return null;
        }
    }
}
