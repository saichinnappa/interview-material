package com.interview.doordash.oa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// Substrings with K distinct characters
public class KDistinctStrings {

    static Set<String> set = new HashSet<>();
    public static void main(String[] args) {
        String input = "abcdef";
        int k = 2;
        process(input, k);
        System.out.println(set);
    }

    private static void process(String input, int k) {

        if(input.isBlank())
            return;

        Queue<Character> queue = new LinkedList<>();
        int start = 0;
        queue.offer(input.charAt(start));
        for(int end = start + 1; end < input.length(); end++){

        }



    }

}
