package com.practice.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Find all the elements in an array which matches the input sum;
//return all possible answers.
public class SubArraySum {

    static List<List<Integer>> result = new ArrayList();

    public static void main(String[] args) {
        int[] input = {1, 5, 0, 2};

        String a = "    123";
        String b = "123      ";
        System.out.println(a.trim() + " " + b.trim());
//        int sum = 4;
//        for (int i = 0; i < input.length; i++) {
//        backtrack(0, new ArrayList<Integer>(), sum, input, 0);
//        }

        for (List<Integer> l : result) {
            System.out.println(Collections.singletonList(l));
        }
    }

//    private static void backtrack(int index, ArrayList<Integer> integers, int sum, int[] input, int temp) {
//
//        if (temp == sum) {
//            result.add(new ArrayList(integers));
////            System.out.println("Added to result");
//            return;
//        } else if (temp > sum) {
//            return;
//        }
//        for (int i = index; i < input.length; i++) {
//            System.out.println(index + " " + i);
//            temp += input[i];
//            integers.add(input[i]);
//            backtrack(index + 1, integers, sum, input, temp);
////            System.out.println("Current Integers--> " + Collections.singletonList(integers));
////            System.out.println("Removing--->" + integers.get(integers.size() - 1));
//
//            temp -= input[i];
//            integers.remove(integers.size() - 1);
////            System.out.println("After removing--> " + Collections.singletonList(integers));
////            break;
//        }
//    }

}
