package com.practice.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1313. Decompress Run-Length Encoded List
 * <p>
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * <p>
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0).
 * For each such pair, there are freq elements with value val concatenated in a sublist. Concatenate all the sublists from left to right to generate the decompressed list.
 * <p>
 * Return the decompressed list.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 * <p>
 * Constraints:
 * <p>
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class DecompressRunLengthEncodedList {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4};
        System.out.println(Arrays.toString(decompressRLElist(input)));
    }

    public static int[] decompressRLElist(int[] nums) {
        int startIdx = 0, endIdx = 0;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            startIdx = 2 * i;
            endIdx = 2 * i + 1;
            if (startIdx < nums.length && endIdx < nums.length) {
                int[] temp = new int[nums[startIdx]];
                int counter = 0;
                while (counter != temp.length) {
                    resultList.add(nums[endIdx]);
                    counter++;
                }
            }
        }
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
