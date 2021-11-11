package com.practice.ctci.linkedlists;

import java.util.HashSet;
import java.util.Set;

class Node {
    int data;
    Node next;

    Node(int value) {
        this.data = value;
        this.next = null;
    }
}

class LinkedLists {
    Node head;
    Node tail;
    int length = 0;

//    public Node mergeTwoLists(LinkedLists l1, LinkedLists l2) {
//
//    }

    void insertAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
        this.length++;
    }

    void removeDuplicates() {
        if (head == null) {
            return;
        }
        Node currentNode = head;
        Node prevNode = head;
        Set<Integer> valueSet = new HashSet<>();
        while (currentNode != null) {
            if (!valueSet.contains(currentNode.data)) {
                prevNode = currentNode;
                valueSet.add(currentNode.data);
            } else {
                prevNode.next = currentNode.next;
                tail = prevNode;
                this.length--;
            }
            currentNode = currentNode.next;
        }
    }

    void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.print("null\n");
    }

    int kthLastElementUsingLength(int k) {
        int kthValue = 0;
        Node currentNode = head;
        if (length < k) {
            System.out.println("Invalid k value");
        } else {
            int nodeIndexTracker = 0;
            while (nodeIndexTracker != (length - k)) {
                nodeIndexTracker++;
                currentNode = currentNode.next;
            }
            kthValue = currentNode.data;
        }
        return kthValue;
    }


    int kthLastElementUsingRecursion(Node head, int k) {
        if (head == null) return 0;
        int i = kthLastElementUsingRecursion(head.next, k) + 1;
        if (i == k)
            System.out.println(head.data);
//        System.out.println("Index-->" + i);
        return i;
    }
}

public class Solution {
    public static void main(String[] args) {
        LinkedLists linkedList = new LinkedLists();
        linkedList.insertAtTail(1);
        linkedList.insertAtTail(2);
        linkedList.insertAtTail(4);
        LinkedLists linkedList2 = new LinkedLists();
        linkedList2.insertAtTail(1);
        linkedList2.insertAtTail(3);
        linkedList2.insertAtTail(4);
//        linkedList.print();
//        linkedList.removeDuplicates();
//        linkedList.print();
//        System.out.println(linkedList.kthLastElementUsingLength(3));
//        linkedList.kthLastElementUsingRecursion(linkedList.head, 1);
        LinkedLists newLinkedList = new LinkedLists();
//            newLinkedList.mergeTwoLists(linkedList, linkedList2);

    }
}
