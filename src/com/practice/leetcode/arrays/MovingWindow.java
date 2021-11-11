package com.practice.leetcode.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingWindow {

    Queue queue = new ArrayDeque();
    int size = 0, count = 0, sum = 0;

    public MovingWindow(int size) {
        this.size = size;
    }


    public static void main(String[] args) {
        MovingWindow movingWindow = new MovingWindow(3);
        System.out.println(movingWindow.next(1));
        System.out.println(movingWindow.next(10));
        System.out.println(movingWindow.next(5));
        System.out.println(movingWindow.next(3));
    }

    public double next(int val) {
        ++count;
        queue.add(val);
        int tail = count > size ? (int) queue.poll() : 0;
        sum = sum - tail + val;
        return (double) sum / Math.min(count, size);
    }

}

    /*
    class MovingAverage {

        int count =0;
        int[] elementArray;
    public MovingAverage(int size) {
        elementArray = new int[size];
    }



    public double next(int val) {
        int sum = 0;
        if (count <= elementArray.length - 1) {
            elementArray[count] = val;
            for (int i = 0; i < elementArray.length; i++) {
                sum += elementArray[i];
            }
            count++;
        } else {
            for (int i = 0; i < elementArray.length - 1; i++) {
                elementArray[i] = elementArray[i + 1];
                sum += elementArray[i + 1];
            }
            elementArray[elementArray.length - 1] = val;
            sum += val;
        }
        return (double) sum / count;
    }
}
*/
