package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Misc {
    static List<String> result = new ArrayList();
    static Set<Character> set = new HashSet<>();
    static int length;

    public static void main(String[] args) {
        length = 3;
        for (int i = 0; i < length; i++) {
            set.add((char) (97 + i));
        }
        solve("");
        System.out.println(result);
    }


    private static boolean isValid(String s) {
        return s.length() == length;

    }

    private static List<Character> getCandidates() {
        return new ArrayList<>(set);
    }


    private static void solve(String s) {
        if (isValid(s)) {
            result.add(s);
        }

        for (char c : getCandidates()) {
            s += c;
            set.remove(c);
            solve(s);
            System.out.println("Adding-->" + c);
            set.add(c);
            s = s.substring(0, s.length() - 1);
        }
        String[] a1 = "abc abc".split(" ", 2);
    }
}
