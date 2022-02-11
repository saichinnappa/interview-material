package com.practice.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    static List<String> result = new ArrayList<>();
    static boolean[] checker;

    public static void main(String[] args) {

        checker = new boolean[3];
        search(3, "");
        System.out.println(result);
    }

    static List<Integer> getCandidate() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < checker.length; i++) {
            if (!checker[i]) {
                list.add(i);
            }
        }
        return list;
    }

    static boolean isValid(String state, int n) {
        return state.length() == n;
    }

    static void search(int n, String state) {
        if (isValid(state, n))
            result.add(state);
        for (int candidate : getCandidate()) {
            state += "" + candidate;
            checker[candidate] = true;
            search(n, state);
            checker[candidate] = false;
            state = state.substring(0, state.length() - 1);
        }
    }
}
