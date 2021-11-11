package com.datastructures.linkedlists.doubly.impl;

public class DoublyLinkedList {

    DLLNode head;

    void insertAtEnd(DLLNode newNode) {
        DLLNode currentNode = head;
        if (head == null) {
            this.head = newNode;
        } else {
            while (currentNode != null) { //loop until the end of the list
                if (currentNode.next == null) { //if last node
                    currentNode.next = newNode; //previous node next equals new node
                    newNode.prev = currentNode; // new node previous equals last node
                    currentNode = newNode.next; //move the current node pointer to new node
                } else { //if not last node
                    currentNode = currentNode.next; //just move the pointer to the next node
                }
            }
        }
    }

    void insertAtHead(DLLNode newNode) {
        if (head != null) {
            newNode.next = this.head;
            this.head.prev = newNode;
        }
        this.head = newNode;
    }

    void delete(DLLNode delNode) {
        DLLNode currentNode = this.head;
        if (this.head != null && this.head.data == delNode.data) {
            this.head = this.head.next;
            this.head.prev = null;
        }
    }

    void deleteTail() {
        DLLNode currentNode = head;
        DLLNode tailNode = null;
        while (currentNode != null) {
            tailNode = currentNode;
            currentNode = currentNode.next;
        }
        tailNode.prev.next = null;
    }

    void print() {
        DLLNode currentNode = head;
        DLLNode lastNode = null;
        System.out.print("Forward:\n");
        System.out.print("null->");
        while (currentNode != null) {
            if (currentNode.next == null)
                lastNode = currentNode;
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;

        }
        System.out.println(currentNode);
        System.out.print("Reverse:\n");
        System.out.print("null->");
        while (lastNode != null) {
            System.out.print(lastNode.data + "->");
            lastNode = lastNode.prev;
        }
        System.out.print(lastNode);
    }

}
