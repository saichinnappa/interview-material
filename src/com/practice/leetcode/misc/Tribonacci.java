package com.practice.leetcode.misc;

import java.util.ArrayList;
import java.util.List;

public class Tribonacci {

    public static void main(String args[]) {
        System.out.println(tribonacci(25));
    }

    private static int tribonacci(int n) {
        List<Integer> listT = new ArrayList<>();
        listT.add(0);
        listT.add(1);
        listT.add(1);
        for (int i = 3; i <= n; i++) {
            listT.add(listT.get(i - 3) + listT.get(i - 2) + listT.get(i - 1));
        }
        return listT.get(n);
    }
}
