package com.datastructures.queues.impl;

public class Main {

    public static void main(String[] args) {

        //Regular Queue
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(6);
        arrayQueue.enqueue(8);
        arrayQueue.enqueue(10);
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.enqueue(12);
        arrayQueue.enqueue(14);
        arrayQueue.print();

        //Circular Queue
//        CircularQueue circularQueue = new CircularQueue(5);
//        circularQueue.enqueue(1);
//        circularQueue.enqueue(2);
//        circularQueue.enqueue(3);
//        circularQueue.enqueue(4);
//        circularQueue.enqueue(5);
//        circularQueue.dequeue();
//        circularQueue.dequeue();
//        circularQueue.enqueue(12);
//        circularQueue.enqueue(14);
//        circularQueue.print();
    }
}
