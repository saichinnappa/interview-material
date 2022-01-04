package com.interview.amazon.oa;

/**
 * Given ratings, determine all the groups (at least 1) where the customer ratings are decreasing
 * ex: [4,3,5,4,3]
 * 1 group: [4], [3], [5], [4], [3]
 * 2 group: [4,3], [5,4], [4,3]
 * 3 group: [5, 4, 3]
 * <p>
 * Total 9.
 * Ref: https://leetcode.com/playground/Knh68TCX
 */

public class CustomerRatings {
    public static void main(String[] args) {
        int[] ratings = {3, 2, 1};
        int ans = bruteForce(ratings);
        int ans1 = optimized(ratings);
        System.out.println(ans + " " + ans1);
    }

    private static int bruteForce(int[] ratings) {
        if (ratings.length == 0)
            return 0;

        int j = 0;
        int result = 0;
        int prev = 0;

        for (int i = 0; i < ratings.length; i++) {

            result++; //increment result, to consider group of 1
            prev = ratings[i]; //compare remaining elements with the prev element;
            j = i + 1; // update j, to compare the prev value;

            while (j < ratings.length && prev > ratings[j]) { // while j is within the array limits and also value of j is greater than prev, keep going.
                result++;
//                prev = ratings[j];
                j++;
            }

        }
        return result;
    }

    private static int optimized(int[] ratings) {

        if (ratings.length == 0)
            return 0;

        int j = 0;
        int result = ratings.length;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[j] - ratings[i] >= 1) { //compare with previous element, and add the difference in indexes to result (which covers multiple groups)
                result += (i - j);
            } else {
                j = i; //at any point, if the difference between current and previous element is negative, move the i -> j
            }
        }

        return result;
    }


}
