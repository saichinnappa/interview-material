package com.datastructures.queues.impl;

import java.util.*;

public class Main {

//    public static void main(String[] args) {
//
//        //Regular Queue
//        ArrayQueue arrayQueue = new ArrayQueue(5);
//        arrayQueue.enqueue(2);
//        arrayQueue.enqueue(4);
//        arrayQueue.enqueue(6);
//        arrayQueue.enqueue(8);
//        arrayQueue.enqueue(10);
//        arrayQueue.dequeue();
//        arrayQueue.dequeue();
//        arrayQueue.enqueue(12);
//        arrayQueue.enqueue(14);
//        arrayQueue.print();
//
//        //Circular Queue
////        CircularQueue circularQueue = new CircularQueue(5);
////        circularQueue.enqueue(1);
////        circularQueue.enqueue(2);
////        circularQueue.enqueue(3);
////        circularQueue.enqueue(4);
////        circularQueue.enqueue(5);
////        circularQueue.dequeue();
////        circularQueue.dequeue();
////        circularQueue.enqueue(12);
////        circularQueue.enqueue(14);
////        circularQueue.print();
//    }


    public static void main(String[] args) {

        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("Naveen", 2);
        hm.put("Santosh", 3);
        hm.put("Ravi", 4);
        hm.put("Pramod", 1);
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
                set);
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
//            @Override
//            public int compare(Map.Entry<String, Integer> o1,
//                               Map.Entry<String, Integer> o2) {
//
//            }
        });

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getValue());

        }

    }
}