package com;

import java.util.HashMap;
import java.util.Map;

public class Misc {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        System.out.println(map.size());
    }
}
