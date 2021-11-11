package com.datastructures.graphs;

public class DLLNode {

    int data;
    DLLNode next;
    DLLNode prev;

    DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
