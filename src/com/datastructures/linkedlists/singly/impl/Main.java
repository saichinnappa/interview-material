package com.datastructures.linkedlists.singly.impl;

public class Main {

    public static void main(String[] args) {
        Node head = new Node(3);
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(head);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        singlyLinkedList.insert(node1);
        singlyLinkedList.insert(node2);
        singlyLinkedList.print();
        singlyLinkedList.delete(node2);
        singlyLinkedList.print();
        singlyLinkedList.delete(node1);
        singlyLinkedList.print();
        singlyLinkedList.delete(head);
        singlyLinkedList.print();
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        singlyLinkedList.insert(node4);
        singlyLinkedList.insert(node5);
        singlyLinkedList.print();
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        singlyLinkedList.insertAfter(node4, node6);
        singlyLinkedList.insertAfter(node6, node7);
        singlyLinkedList.print();
        Node node8 = new Node(8);
        singlyLinkedList.insert(node8);
        singlyLinkedList.print();
        System.out.println(singlyLinkedList.search(node8));
        System.out.println(singlyLinkedList.length());
        singlyLinkedList.reverse();
    }
}
