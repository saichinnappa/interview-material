package com.datastructures.hashtables;

import com.datastructures.linkedlists.singly.impl.Node;
import com.datastructures.linkedlists.singly.impl.SinglyLinkedList;

import java.util.HashMap;
import java.util.HashSet;

//Using hashing
public class RemoveDuplicatesSLL {

    public void removeDuplicates(SinglyLinkedList sll) {
        HashSet<Integer> set = new HashSet<>();
        Node head = sll.head; //head
        Node prevNode = null; //previous node tracker
        Node currentNode = head; //current node tracker
        Node nextNode = head.next; //next node tracker
        while (nextNode != null) { //keep iterating until the last node is null
            if (set.contains(currentNode.data)) { //if set already has the current node, then point the next element of previous node to next node, skipping current node
                prevNode.next = nextNode;
            } else { //if not found in set , previous node will be current node
                prevNode = currentNode;
            }
            set.add(currentNode.data);//add every current node to set to maintain uniqueness
            currentNode = nextNode; //current node will be next node
            nextNode = nextNode.next; //next node will be next to next
        }
        if (set.contains(currentNode.data)) { //since the while loop breaks when last node is null, we have to a check on last current node whose next is null
            prevNode.next = currentNode.next; // if the element is present in the set, then point the previous node next to current node next i.e. null
        }
    }

//    public void union(SinglyLinkedList sll1, SinglyLinkedList sll2) {
//        HashMap<Integer, Integer> map2 = new HashMap<>();
//        Node currentNode = sll2.head;
//        while (currentNode.next != null) {
//            if (!map2.containsKey(currentNode.data))
//                map2.put(currentNode.data, currentNode.next.data);
//            currentNode = currentNode.next;
//        }
//        map2.put(currentNode.data, null);
//
//        Node currentNode1 = sll1.head;
//        while (currentNode1 != null) {
//            currentNode1 = currentNode1.next;
//        }
//        for (Integer i : map2.keySet()) {
//            currentNode1.next = i;
//        }
//    }

    public int[] findSum(int[] arr, int n) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(i, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.containsValue(n - arr[i])) {
                result[0] = arr[i];
                result[1] = n - arr[i];
            }
        }
        return result;
    }


}
