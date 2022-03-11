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
    int size;
    DLL head;
    DLL tail;

    LRUCache(int size) {
        this.size = size;
    }

    public static void main(String[] args) {

    }

    int get(int key) {
        if (map.containsKey(key)) {
            DLL node = map.get(key);
            DLL prev = node.prev;
            DLL next = node.next;
            prev.next = next;
            next.prev = prev;
            cache.addFirst(node);
            this.head = node;
            return key;
        }
        return -1;
    }

    void put(int key, int val) {
        if (map.containsKey(key)) {
            DLL existingNode = map.get(key);
            existingNode.val = val;
            map.put(key, existingNode);
            DLL prev = existingNode.prev;
            DLL next = existingNode.next;
            prev.next = next;
            next.prev = prev;
            cache.addFirst(existingNode);
            this.head = existingNode;
        } else if (cache.size() < size) {
            DLL newNode = new DLL(key, val, null, null);
            cache.addFirst(newNode);
            this.head = newNode;
            map.put(key, newNode);
        }
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
