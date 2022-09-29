package com.exercise.warmmap;

import java.util.HashMap;

public class Warmest<K, V> {

    // Serves both for storing the data and recording history.
    // Contains references for Entry objects.
    private final HashMap<K, Entry<V>> warmest_map = new HashMap<>();

    private Entry<V> first = null;
    private Entry<V> last = null;
    private V warmest = null;


    public Warmest put(K key, V value) {

        Entry<V> entry = this.warmest_map.get(key);

        if (entry == null) {

            entry = new Entry<>(value);

            if (this.first == null) {
                this.first = entry;
            } else {

                // `this.last` cannot be null if `this.first` is not null

                this.first.setPrev(entry);
                entry.setNext(this.first);

                this.last.setNext(entry);
                entry.setPrev(this.last);

            }

            this.last = entry;
            this.warmest_map.put(key, entry);
        }

        entry.value = value;
        this.warmest = value;

        return this;
    }


    public V get(K key) {
        Entry<V> entry = this.warmest_map.get(key);

        if (entry == null) {
            return null;
        }

        this.warmest = entry.value;
        return entry.value;
    }

    public V remove(K key) {

        Entry<V> entry = this.warmest_map.remove(key);

        if (entry == null) {
            return null;
        }

        if (this.last == entry) {
            this.last = last.getPrev();
        }

        if (this.first == entry) {
            this.first = first.getNext();
        }

        // Remove from the Linked-List & connect prev and next to each other
        entry.remove();

        this.warmest = this.last.value;

        return entry.value;
    }

    public V getWarmest() {
        return this.warmest;
    }
}
