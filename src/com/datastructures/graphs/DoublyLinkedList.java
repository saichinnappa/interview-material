package com.datastructures.graphs;

public class DoublyLinkedList {
    public DLLNode head;
    public DLLNode tail;
    DoublyLinkedList currentNode;

    void insertAtHead(DLLNode newNode) {
        DLLNode currentNode = this.head;
        if (currentNode == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
    }

    void insertAtTail(DLLNode newNode) {
        DLLNode currentNode = this.tail;
        if (currentNode == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }

    void print() {
        DLLNode currentNode = this.head;
        if (currentNode == null) {
            System.out.println("DLL is empty.");
        } else {
            while (currentNode != null) {
                System.out.print(currentNode.data + "<=>");
                currentNode = currentNode.next;
            }
            System.out.print("null\n");
        }
    }
}
