package com.exercise.warmmap;

public record Entry<K , V>(K key, V value) {

    //    // Overriding equals() to compare two Complex objects
    //    @Override
    //    public boolean equals(Object o) {
    //
    //        // If the object is compared with itself then return true
    //        if (o == this) {
    //            return true;
    //        }
    //
    //        /* Check if o is an instance of Complex or not
    //          "null instanceof [type]" also returns false */
    //        if (!(o instanceof V c)) {
    //            return false;
    //        }
    //
    //        // Compare the data members and return accordingly
    //        return Double.compare(this.re, c.re) == 0
    //                && Double.compare(this.im, c.im) == 0;
    //    }
}
