package com.datastructures.graphs;

public class Main {
    public static void main(String[] args) {
//        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
//        DLLNode dllNode1 = new DLLNode(1);
//        DLLNode dllNode2 = new DLLNode(2);
//        DLLNode dllNode3 = new DLLNode(3);
//        doublyLinkedList.insertAtHead(dllNode1);
//        doublyLinkedList.insertAtHead(dllNode2);
//        doublyLinkedList.insertAtHead(dllNode3);
//        DLLNode dllNode4 = new DLLNode(4);
//        doublyLinkedList.insertAtTail(dllNode4);
//        doublyLinkedList.print();
        Graph graph = new Graph(4);
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 3);
        graph.printGraph();
    }
}
