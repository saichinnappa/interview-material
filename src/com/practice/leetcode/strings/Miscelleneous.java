package com.practice.leetcode.strings;

public class Miscelleneous {
    StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Miscelleneous miscelleneous = new Miscelleneous();
        miscelleneous.reverseStringRecursion("ABCD");
        System.out.println(miscelleneous.stringBuilder.toString());
    }

    private void reverseStringRecursion(String s) {
        helper(s, s.length() - 1);
    }

    private void helper(String s, int i) {
        if (i < 0) {
            return;
        }
        stringBuilder.append(s.charAt(i));
        helper(s, --i);
        System.out.println(i);
    }

}
