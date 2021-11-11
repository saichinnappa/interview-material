package com.datastructures.stacks.impl;

public class ArrayStack {

    public int[] array;
    public int top;
    private int maxSize;

    //initialize
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[this.maxSize];
        top = -1;
    }

    //isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    //isFull
    boolean isFull() {
        return top == maxSize - 1;
    }

    //push
    public void push(int value) {
        if (!isFull())
            array[++top] = value;
        else
            System.out.println("STACK IS FULL: cannot push: " + value);
    }

    //pop
    public int pop() {
        if (!isEmpty())
            return array[top--];
        else {
            System.out.println("STACK IS EMPTY!");
            return top;
        }
    }
}
