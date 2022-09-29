package com.exercise.warmmap;


public class Entry<V> {

    public V value;

    private Entry<V> prev = null;
    private Entry<V> next= null;

    public Entry(V value) {
        this.value = value;
    }


    public Entry<V> setNext(Entry<V> entry) {
        // An Entry cannot point to itself. Self pointing replaced with `null`
        this.next = (entry == this ? null : entry);
        return this;
    }

    public Entry<V> getNext() {
        return this.next;
    }

    public Entry<V> setPrev(Entry<V> entry) {
        // An Entry cannot point to itself. Self pointing replaced with `null`
        this.prev = (entry == this ? null : entry);
        return this;
    }

    public Entry<V> getPrev() {
        return this.prev;
    }

    public V remove() {

        if (this.prev != null) {

            if (this.next == this) {
                this.prev.setNext(null);
            } else {
                this.prev.setNext(this.next);
            }

        }

        if (this.next != null) {

            if (this.prev == this) {
                this.next.setPrev(null);
            } else {
                this.next.setPrev(this.prev);
            }

        }

        return this.value;
    }

}
