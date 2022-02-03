package com.practice.design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    LinkedList<DLL> cache = new LinkedList<>();
    Map<Integer, DLL> map = new HashMap<>();
    int size = 0;

    LRUCache(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(1, 4);
        System.out.println(cache.get(1));
    }

    //If cache is full, evict LRU and add the new pair
    //It cache is empty or not full, add end of the list;
    void put(int key, int val) {

        if (cache.size() == size) {
            int leastNodeKey = cache.getFirst().key;
            cache.removeFirst();
            map.remove(leastNodeKey);
        }
        if (cache.size() < size) {

            if (map.containsKey(key)) {

            }


            DLL prevNode = null;
            if (cache.size() > 0) {
                prevNode = cache.peekLast();
            }
            DLL newNode = new DLL(key, val, prevNode, null);
            cache.addLast(newNode);
            map.put(key, newNode);
        }

    }

    int get(int key) {
        return map.containsKey(key) ? map.get(key).val : -1;
    }
}

class DLL {
    int key;
    int val;
    DLL prev;
    DLL next;

    DLL(int key, int val, DLL prev, DLL next) {
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

}
