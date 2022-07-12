package com.practice.misc.java.concepts;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        //covert char to int;
        String s = "abcde";
        System.out.println("############ CHAR -> INT ##############");
        for(char c : s.toCharArray()){
            System.out.println(c +"->"+ (int)(c));
        }

        //convert int to char;
        int[] arr = {65, 66, 67, 68, 69, 122};
        System.out.println("############ INT -> CHAR ##############");
        for(int i : arr){
            System.out.println(i +"->"+ (char)(i));
        }

        //convert string to int array
        System.out.println("############ STRING -> INT[] ##############");
        String s1 = "abcd";
        int[] arr1 = new int[26];
        for(int i = 0; i < s1.length(); i++){
            arr1[s1.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(arr1));


    }
}
