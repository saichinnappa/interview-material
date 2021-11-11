package com.datastructures.stacks.impl.linkedlist;

public class LinkedListStack {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node node1 = new Node(0);
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        linkedList.insert(linkedList, node1);
        linkedList.insert(linkedList, node2);
        linkedList.insert(linkedList, node3);
        linkedList.print(linkedList);
        linkedList.pop(linkedList);
        linkedList.pop(linkedList);
        linkedList.print(linkedList);
    }
}
