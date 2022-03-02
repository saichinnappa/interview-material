package com.practice.leetcode.strings;

public class CompressAndDecompress {
    public static void main(String[] args) {
        String input = "aaabbcccdd";
        char[] arr = input.toCharArray();
        char prev = arr[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < arr.length; i++) {
            if (prev == arr[i]) {
                count++;
            } else {
                sb.append(count).append(prev);
                prev = arr[i];
                count = 1;
            }
        }
        sb.append(count).append(prev);
        System.out.println(sb);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < sb.length(); i += 2) {
            int count1 = (int) sb.charAt(i) - '0';
            while (count1 != 0) {
                output.append(sb.charAt(i + 1));
                count1--;
            }
        }
        System.out.println(output);

    }
}
