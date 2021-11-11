package com.datastructures.graphs;

public class Graph {
    int vertices;
    DoublyLinkedList adjacencyList[];

    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new DoublyLinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new DoublyLinkedList();
        }
    }


    void printGraph() {
        for (int i = 0; i < adjacencyList.length; i++) {
            System.out.print(i + ":");
            DoublyLinkedList doublyLinkedList = adjacencyList[i];
            doublyLinkedList.print();
        }
    }

    void insertEdge(int source, int destination) {
        if (source < vertices && destination < vertices) {
            DLLNode destinationNode = new DLLNode(destination);
            this.adjacencyList[source].insertAtTail(destinationNode);
        }
    }
}
