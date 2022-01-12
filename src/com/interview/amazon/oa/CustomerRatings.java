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
        int[] ratings = {4, 3, 5, 4, 3};
        int ans = bruteForce(ratings);
        int ans1 = optimized(ratings);
        System.out.println(ans + " " + ans1);
    }

    private static int bruteForce(int[] ratings) {
        if (ratings.length == 0)
            return 0;

        int j = 0, result = 0;
        for (int i = 0; i < ratings.length; i++) {
            result++;
            j = i + 1;
            while (j < ratings.length && ratings[i] > ratings[j]) {
                result++;
                j++;
            }
        }
        return result;
    }

    private static int optimized(int[] ratings) {
        if (ratings.length == 0) return 0;

        int result = ratings.length, j = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[j] - ratings[i] >= 1) {
                result += (i - j);
            } else {
                j = i;
            }
        }
        return result;
    }
}