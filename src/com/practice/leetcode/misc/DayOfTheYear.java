package com.practice.leetcode.misc;

public class DayOfTheYear {
    public static void main(String[] args) {
        System.out.println(dayOfYear("2019-03-29"));
    }

    static int dayOfYear(String date) {
        int year = Integer.parseInt(date.split("-")[0]);
        int month = Integer.parseInt(date.split("-")[1]);
        int day = Integer.parseInt(date.split("-")[2]);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    days[1] = 29;
                }
            } else {
                days[1] = 29;
            }
        }
        int totalDays = day;
        if (month == 1) {
            return day;
        } else {
            for (int i = 0; i < month - 1; i++) {
                totalDays += days[i];
            }
        }
        return totalDays;
    }
}
