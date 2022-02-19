package com.interview.wayfair.oa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestContiuousSequence {
    public static void main(String[] args) {
        String[] user1 = {"/home", "/register", "/login", "/user", "/one", "/two" };
        String[] user2 = {"/home", "/red", "/login", "/user", "/one", "/pink" };
        List<String> result = new ArrayList<>();
        int[][] dp = new int[user1.length + 1][user2.length + 1];
        int endRow = 0;
        int endCol = 0;
        int maxLength = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (user1[i - 1].equals(user2[j - 1])) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (maxLength < dp[i][j]) {
                        maxLength = dp[i][j];
                        endRow = i;
                        endCol = j;
                    }
                }
            }
        }
        int startRow = endRow;
        while (maxLength != 0) {
            result.add(user1[--startRow]);
//            startRow--;
            maxLength--;
        }

        Collections.reverse(result);
        System.out.println(result);
//        System.out.println(Arrays.asList(user1).subList((startRow - 1), (endRow)));
//        System.out.println((startRow - 1) + " " + (endRow - 1));

    }
}
