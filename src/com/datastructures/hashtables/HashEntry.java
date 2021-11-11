package com.datastructures.hashtables;

public class HashEntry {

    public String key;
    public int value;
    HashEntry next;

    HashEntry(String key, int value) {
        this.key = key;
        this.value = value;
    }
}
