package com.practice.leetcode.misc;

import java.util.HashMap;
import java.util.Map;

public class LuckyInteger {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 3, 4};
        System.out.println(findLucky(arr));
    }

    private static int findLucky(int[] arr) {
        Map<Integer, Integer> arrMap = new HashMap<>();
        for (Integer num : arr) {
            arrMap.put(num, arrMap.getOrDefault(num, 0) + 1);
        }
        int temp = -1;
        for (int i : arr) {
            if (arrMap.get(i) == i && i > temp) {
                temp = i;
            }
        }
        return temp;
    }
}
