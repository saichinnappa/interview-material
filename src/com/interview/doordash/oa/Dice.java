package com.interview.doordash.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/discuss/interview-question/1515046/DoorDash-Data-Eng-Tech-phone-screen
public class Dice {

    static boolean[] checker = new boolean[7];
    static List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        solve(new ArrayList<>(), 2);
        System.out.println(result.size());
        System.out.println(result);
    }

    static boolean isValid(List<Integer> list, int size){
        return list.size() == size;
    }

    static List<Integer> getCandidates(){
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    static void solve(List<Integer> list, int size){
        if(isValid(list, size)){
            result.add(new ArrayList(list));
            return;
        }
        for(int c : getCandidates()){
            list.add(c);
//            checker[c] = true;
            solve(list, size);
//            checker[c] = false;
            list.remove(list.size() - 1);
        }
    }




}
