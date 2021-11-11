package com.datastructures.hashtables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTable {

    private ArrayList<HashEntry> bucket = new ArrayList<>();
    private int size;
    private int slots;

    HashTable() {
        this.size = 0;
        this.slots = 10;
        for (int i = 0; i < this.slots; i++) {
            bucket.add(null);
        }
    }

    public String tracePath(Map<String, String> map) {
        String result = "";
        String start = "";
        int size = 0;
        for (String key : map.keySet()) {
            if (!map.containsValue(key)) {
                start = key;
            }
        }
        while (size != map.size()) {
            String value = map.get(start);
            result += start + "->" + value + ",";
            start = value;
            size++;
        }
        return result;
    }

    public boolean findSubZero(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int firstElement = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int sum = firstElement + arr[j];
                if (sum == 0)
                    return true;
                else
                    firstElement += arr[j];
            }
        }
        return false;
    }

    public int findFirstUnique(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i))
                map.replace(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]) && map.get(arr[i]) == 1) {
                return arr[i];
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    private int getIndex(String key) {
        //hashCode is a built in function of Strings
        int hashCode = key.hashCode();
        int index = hashCode % slots;
        //Check if index is negative
        if (index < 0) {
            index = (index + slots) % slots;
        }
        return index;
    }

    //Inserts a key value pair into table
    public void insert(String key, int value) {
        //Find head of the chain
        int b_Index = getIndex(key);
        HashEntry head = bucket.get(b_Index);

        //Checks if the key is already exists
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Inserts key in the chain
        size++;
        head = bucket.get(b_Index);
        HashEntry new_slot = new HashEntry(key, value);
        new_slot.next = head;
        bucket.set(b_Index, new_slot);


        //Checks if array >60% of the array gets filled
        if ((1.0 * size) / slots >= 0.6) {
            ArrayList<HashEntry> temp = bucket;
            bucket = new ArrayList();
            slots = 2 * slots;
            size = 0;
            for (int i = 0; i < slots; i++)
                bucket.add(null);

            for (HashEntry head_Node : temp) {
                while (head_Node != null) {
                    insert(head_Node.key, head_Node.value);
                    head_Node = head_Node.next;
                }
            }
        }
    }

    public boolean search(String key) {
        int bucket_index = getIndex(key);
        if (bucket.get(bucket_index) == null) {
            System.out.println("Nothing is present at this index..");
            return false;
        } else {
            HashEntry head = bucket.get(bucket_index);
            while (head != null) {
                if (head.key.equals(key)) {
                    return true;
                }
                head = head.next;
            }
        }
        return false;
    }

    public int delete(String key) {
        //Find index
        int b_Index = getIndex(key);

        // Get head of the chain for that index
        HashEntry head = bucket.get(b_Index);

        //Find the key in slots
        HashEntry prev = null;
        while (head != null) {
            //If key exists
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key does not exist
        if (head == null)
            return -1;

        // Decrease the size by one
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucket.set(b_Index, head.next);

        return head.value;
    }

}
