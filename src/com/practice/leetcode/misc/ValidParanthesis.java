package com.practice.leetcode.misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
    }

    private static boolean isValid(String s) {
        if (s.length() % 2 != 0)
            return false;
        if (s.length() == 0)
            return true;
        Map<Character, Character> paranthesisMap = new HashMap<>();
        paranthesisMap.put('(', ')');
        paranthesisMap.put('[', ']');
        paranthesisMap.put('{', '}');
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        int count = 1;
        while (count != s.length()) {
            if (!stack.isEmpty() && paranthesisMap.get(stack.peek()) != null && (s.charAt(count) == paranthesisMap.get(stack.peek()))) {
                stack.pop();
            } else {
                stack.push(s.charAt(count));
            }
            count++;
        }
        return stack.isEmpty();
    }
}
