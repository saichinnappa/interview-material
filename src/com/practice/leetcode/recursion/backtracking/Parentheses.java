package com.practice.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Parentheses {
    static int open;
    static int close;
    static int n;
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        n = 3;
        solve(n, new StringBuilder());
        System.out.println(result);
    }

    private static boolean isValid(){
        return (open == n) && (close == n);
    }

    private static void solve(int n, StringBuilder stringBuilder) {
        if(isValid()){
            result.add(stringBuilder.toString());
            return;
        }
        if(open < n && close <= open){
            open++;
            solve(n, stringBuilder.append("("));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            open--;
        }
        if(close < n){
            close++;
            solve(n, stringBuilder.append(")"));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            close--;
        }
    }
}
