package com.interview.amazon.oa;

/**
 * A question about Amazon student badges but ultimately the problem was given an arr of -1 or 1, return the maximum subarray length with a product of 1.
 * The array is of size 2 and above and only contains -1 and 1
 * e.g arr = [-1,-1,1,1,-1], return 4, since index 0 to 3 have the max length with product equal to 1
 * <p>
 * https://leetcode.com/discuss/interview-question/1655441/Amazon-or-OA
 */
public class MaximumLengthOfProduct {

    public static void main(String[] args) {
        int[] input = {-1, -1, 1, 1, -1};
        int startIdx = 0;
        int firstNegIdx = 0;
        int result = 0;
        boolean isFirst = false;
        int negCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] < 0) {
                negCount++;
                if (!isFirst) {
                    firstNegIdx = i;
                    isFirst = true;
                }
            }
            int x = 0;
            if (negCount % 2 == 0)
                x = i - startIdx + 1;
            else
                x = i - firstNegIdx;
            result = Math.max(result, x);
        }

        System.out.println("Result: " + result);
    }
}
