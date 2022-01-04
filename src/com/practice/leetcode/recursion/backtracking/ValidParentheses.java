package com.practice.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {

    //    static int open = 0;
//    static int close = 0;
    static List<String> result = new ArrayList<>();
    static String s = "";

    public static void main(String[] args) {
//        open = 3;
//        close = 3;
        solve(3);
        System.out.println(result);
    }

    static boolean isValid(int n, int open, int close) {
        return open == n && close == n;
    }

//    static String getCandidates(int n) {
//        System.out.println(open + " " + close + " " + n);
//        if (open < n)
//            return "(";
//        else if (close < open) {
//            return ")";
//        }
//        return "#";
//    }

    static void solve(int n) {
        search(n, 0, 0);
    }

    static void search(int n, int open, int close) {
        if (isValid(n, open, close))
            result.add(s);
        if (open < n) {
            s = s.concat("(");
            search(n, open + 1, close);
        }
        if (close < open) {
            s = s.concat(")");
            search(n, open, close + 1);
        }
        if (s.length() > 1)
            s = s.substring(0, s.length() - 1);
    }
}

