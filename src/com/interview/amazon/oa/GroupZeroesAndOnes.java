package com.interview.amazon.oa;

import java.util.Arrays;

/**
 * Given an array containing only 0 and 1 as its elements. We have to sort the array in such a manner that all the ones are grouped together and all the zeros are grouped together.
 * The group of ones can be either at the start of the array or at the end of the array. The constraint while sorting is that every one/zero can be swapped only with its adjacent zero/one. Find the minimum number of moves to sort the array as per the description.
 * Example:
 * input array ={0,1,0,1}
 * Final array = {0,0,1,1}
 * Minimum moves = 1 (1 at index 1 is swapped with 0 at index 2)
 * <p>
 * input array = { 1101}
 * Final array - {1110}
 * Minimum moves = 1 {1 at index 2 is swapped with index 3}
 * <p>
 * https://leetcode.com/discuss/interview-question/1655441/Amazon-or-OA
 */
public class GroupZeroesAndOnes {

    public static void main(String[] args) {
        int[] input = {1, 1, 0, 1};
        int[] copy = input.clone();

        int start = 0, min1 = 0, min2 = 0;

        //First try moving all zeroes to the left
        for (int i = start; i < input.length; i++) {
            if (i == start && input[i] == 0)
                start++;
            else if (input[i] == 0) {
                int temp = input[start];
                input[start] = 0;
                input[i] = temp;
                min1 += i - start;
                start++;
            }
        }

        System.out.println(Arrays.toString(input) + " " + min1);

        start = 0;
        //Second try moving all Ones to the left
        for (int i = start; i < copy.length; i++) {
            if (i == start && copy[i] == 1)
                start++;
            else if (copy[i] == 1) {
                int temp = copy[start];
                copy[start] = 1;
                copy[i] = temp;
                min2 += i - start;
                start++;
            }
        }


        System.out.println(Arrays.toString(copy) + " " + min2);

        System.out.println("Result-> " + Math.min(min1, min2));

    }
}
