package com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Misc {
    public static void main(String[] args) {
        String x = "hit";
        String[] arr = {"hot", "hut", "dot"};
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        for (int i = 0; i < x.length(); i++) {
            String y = x;
            for (char j = 'a'; j <= 'z'; j++) {
                y = x.replace(x.charAt(i), j);
                System.out.println(y + "<<<<<");
                if (set.contains(y)) {
                    System.out.println("FOUND--> " + y);
//                    y = x;
                }
            }
        }

    }
}
