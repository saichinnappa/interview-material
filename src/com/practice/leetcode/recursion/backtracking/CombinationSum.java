package com.practice.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result = new ArrayList<>();
    static int[] input = {2, 3, 5};
    static int target = 8;
    public static void main(String[] args) {
        solve(input,target, 0, new ArrayList<>(), 0);
        System.out.println(result);
    }

    static boolean isValid(int sum, int target){
        return sum == target;
    }

//    static int[] getCandidates(){
//        return input;
//    }

    static void solve(int[] nums, int target, int sum, List<Integer> list, int index){
        if(isValid(sum, target)){
            result.add(new ArrayList<>(list));
//            return;
        }
        for(int i = index;  i < nums.length; i++){
            sum += nums[i];
            list.add(nums[i]);
            if(sum <= target){
                solve(nums, target, sum, list, i);
            } else {
                sum -= nums[i];
                list.remove(list.size() - 1);
            }
        }
    }
}
