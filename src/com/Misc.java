package com;

public class Misc {
    public static void main(String[] args) {
        int i = 10;
        test(i);
    }

    private static void test(int i) {
        i--;
        System.out.println(i);
        if (i == 1)
            i = 10;
        test(i);
    }
}
