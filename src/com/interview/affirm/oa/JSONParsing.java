package com.interview.affirm.oa;

public class JSONParsing {
    public static void main(String[] args) {
        String[] input = {"\"a\":1, \"b\":[\"hello\", \"world\"], \"c\":\"foo"};
        for (String s : input) {
            String[] arr = s.split(", \"");
            System.out.println(arr[1]);
        }
    }
}
