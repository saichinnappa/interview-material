package com.datastructures.queues.impl;

public class CircularQueue {

    int front = -1;
    int rear = -1;
    int[] circularArrayQueue;
    int maxSize;
    int currentSize;

    CircularQueue(int size){
        this.circularArrayQueue = new int [size];
        this.maxSize = size;
    }

    boolean isEmpty(){
        return (currentSize == 0);
    }

    boolean isFull(){
        return currentSize == circularArrayQueue.length;
    }

    void enqueue(int val){
        if (isFull()) {
            System.out.println("Queue is full");
        }
        rear = (rear + 1) % circularArrayQueue.length;
        circularArrayQueue[rear] = val;
        currentSize++;
        if (front == -1) {
            front = rear;
        }
    }

    int dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
        }
        int deQueuedElement = circularArrayQueue[front];
        front = (front + 1) % circularArrayQueue.length;
        currentSize--;
        return deQueuedElement;
    }

    void print(){
        for(int n : circularArrayQueue){
            System.out.print(n+" ");
        }
    }


}
