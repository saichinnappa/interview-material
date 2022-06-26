package com.interview.doordash.oa;

import java.util.PriorityQueue;

/**
 * 1. Sorting
 * 2. Insertion sort -> pick middle elements compute
 * 3. Using priority queues
 *      1. Keep track of smaller half array
 *      2. Keep track of larger half array
 *      3. Pick top two elements if sizes are equal
 *      4. Pick top element from, min heap if size is larger than max heap.
 */

public class RunningMedian {
    public static void main(String[] args) {
        RunningMedian runningMedian = new RunningMedian();
        runningMedian.addNum(1);
        runningMedian.addNum(2);
        runningMedian.addNum(3);
        System.out.println(runningMedian.findMedian());
    }


    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public RunningMedian() {
        //
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        // if(maxHeap.peek() < num){
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size())
            return (double)maxHeap.peek();
        else
            return (double)(maxHeap.peek() + minHeap.peek()) * 0.5;

    }
}
