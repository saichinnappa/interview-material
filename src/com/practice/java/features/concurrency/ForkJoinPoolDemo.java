package com.practice.java.features.concurrency;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        String input = "test";
        int[] arr = new int[input.length()];
        for(int i = 0; i < input.length(); i++){
            arr[i] = input.charAt(i) - 'a';
        }
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        int result  = forkJoinPool.invoke(customRecursiveTask);
        System.out.println(result);

        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("this is a forkjoinpool test");
        forkJoinPool.invoke(customRecursiveAction);


    }
}
