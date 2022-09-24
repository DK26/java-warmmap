package com.exercise.warmmap;

import java.util.ArrayDeque;
import java.util.Deque;

// Ideally, I would like to implement either a Swiss hash table map or a B-Tree map,
// but since it turned to be complicated to learn and to implement in a very limited time frame,
// I decided to have something working using the same Stack I used to implement the warmest logical flow.
// Looking back, maybe I should have tried to implement this with my own stack, but I was under the assumption
// that a B-Tree is required and that it could be the most efficient algorithm I hoped I could easily implement.

public class Warmest<K, V> {

    // Serves both for storing the data and recording history.
    // Contains references for Entry objects.
    private final Deque<Entry<K, V>> warmest_deque = new ArrayDeque<>();

    public Warmest put(K key, V value) {

        Entry<K, V> entry = new Entry<>(key, value);

        this.warmest_deque.push(entry);

        return this;
    }

    private Entry<K, V> search_entry(K key) {

        // Inefficient O(n), but working
        for (Entry<K, V> e : this.warmest_deque) {
            if (e.key() == key) {
                return e;
            }
        }
        return null;
    }

    // O(n)
    public V get(K key) {

        Entry<K, V> found_entry = search_entry(key);

        V result = null;

        if (found_entry != null) {
            result = found_entry.value();
            this.warmest_deque.push(found_entry);
        }

        return result;
    }

    // Guessing O(n^2)
    public V remove(K key) {

        Entry<K, V> found_entry = search_entry(key);  // O(n)

        if (found_entry == null) {
            return null;
        }
        // Keep removing any trace of the key from the deque
        // (Not sure if this is idiomatic Java)
        // O(n) for each iteration but for a reduced size
        while(this.warmest_deque.remove(found_entry));

        return found_entry.value();
    }

    public V getWarmest() {
        // `peek()` for a stack is considered an O(1) operation.
        Entry<K, V> result = this.warmest_deque.peek();

        if (result != null) {
            return result.value();
        }
        else return null;

    }
}
