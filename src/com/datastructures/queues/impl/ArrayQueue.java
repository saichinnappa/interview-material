package com.datastructures.queues.impl;

public class ArrayQueue {

    int front = 0;
    int rear = -1;
    int[] queueArray;
    int size;

    public ArrayQueue(int size) {
        queueArray = new int[size];
        this.size = size;
    }

    boolean isFull() {
        return size - 1 == rear;
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public void enqueue(int val) {
        if (!isFull()) {
            queueArray[++rear] = val;
        } else {
            System.out.println("Queue is full.");
        }
    }

    public int dequeue() {
        int dequeuedElement = queueArray[front];
        if (!isEmpty()) {
            for (int i = 0; i < rear; i++) {
                queueArray[i] = queueArray[i + 1];
            }
            rear--;
            return dequeuedElement;
        } else {
            return -1;
        }
    }

    void print() {
        for (int n : queueArray) {
            System.out.print(n + " ");
        }
    }
}
