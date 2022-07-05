package com.practice.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {2,4,6,9,12};
        int x = 10;
        for(int i = 0; i < 10; i++){
            int val = -1;
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(nums[mid] <= i){
                    val = mid;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            System.out.println(i +" -- "+val);

        }


    }

}
