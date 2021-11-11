package com.datastructures.linkedlists.doubly.impl;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        DLLNode dllNode1 = new DLLNode(1);
        DLLNode dllNode2 = new DLLNode(2);
        DLLNode dllNode3 = new DLLNode(3);
        doublyLinkedList.insertAtEnd(dllNode1);
        doublyLinkedList.insertAtEnd(dllNode2);
        doublyLinkedList.insertAtEnd(dllNode3);
        System.out.println("Insert at end");
        doublyLinkedList.print();
        System.out.println("\nDelete Node 1");
        doublyLinkedList.delete(dllNode1);
        doublyLinkedList.print();
        System.out.println("\nInsert at head");
        DLLNode dllNode4 = new DLLNode(4);
        DLLNode dllNode5 = new DLLNode(5);
        doublyLinkedList.insertAtHead(dllNode4);
        doublyLinkedList.insertAtHead(dllNode5);
        doublyLinkedList.print();
        doublyLinkedList.deleteTail();
        System.out.println("\nDelete tail node");
        doublyLinkedList.print();
    }
}
