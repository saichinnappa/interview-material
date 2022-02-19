package com.interview.wayfair.oa;

public class FreeTime {
    public static void main(String[] args) {
        int[][] schedule = {{1300, 1500}, {930, 1200}, {830, 845}};
        int start = 835;
        int end = 850;

        for (int[] s : schedule) {
            if (start < s[0] && end > s[1]
                    || start >= s[0] && start < s[1]
                    || end > s[0] && end <= s[1]) {
                System.out.println("FALSE");
            }
        }

        System.out.println("TRUE");

    }
}
