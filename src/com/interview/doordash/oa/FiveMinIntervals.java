package com.interview.doordash.oa;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////https://leetcode.com/discuss/interview-question/1387937/Doordash-new-Q
//public class FiveMinIntervals {
//
//    public static void main(String[] args) {
//        String[] input = {"Mon 10:00 AM", "Mon 11:05 AM"};
//        Map<String, Integer> dayToVal = new HashMap<>();
//        dayToVal.put("Mon", 1);
//        dayToVal.put("Tue", 2);
//        dayToVal.put("Wed", 3);
//        dayToVal.put("Thu", 4);
//        dayToVal.put("Fri", 5);
//        dayToVal.put("Sat", 6);
//        dayToVal.put("Sun", 7);
//
//        String[] startTimeValues = input[0].split(" ");
//        if(startTimeValues.length < 3)
//            System.out.println("Invalid Input");
//        int startDay = dayToVal.get(startTimeValues[0]);
//        String[] hhmm = startTimeValues[1].split(":");
//        int startHour = Integer.valueOf(hhmm[0]);
//        int startMin = Integer.valueOf(hhmm[1]);
//        String startMeridian = startTimeValues[2];
//
//
//        String[] endTimeValues = input[1].split(" ");
//        if(endTimeValues.length < 3)
//            System.out.println("Invalid Input");
//        int endDay = dayToVal.get(startTimeValues[0]);
//        String[] hhmm1 = endTimeValues[1].split(":");
//        int endHour = Integer.valueOf(hhmm1[0]);
//        int endMin = Integer.valueOf(hhmm1[1]);
//        String endMeridian = endTimeValues[2];
//
//
//        if(startMeridian.equalsIgnoreCase("PM"))
//            startHour += 12;
//        if(endMeridian.equals("PM"))
//            endHour += 12;
//
//
//        List<String> result = new ArrayList<>();
//
//        while(startDay <= endDay && startHour <= endHour){
//
//            startMin += 5;
//            if(startHour == endHour && startMin > endMin)
//                break;
//
//            if(startMin > 59){
//                startMin = 0;
//                if(startHour == 23) {
//                    startHour = 0;
//                    startDay++;
//                }
//                else
//                    startHour++;
//            }
////            if(startMin > 60)
////                startMin = 0;
//
//            String val = String.valueOf(startDay);
//            if(startHour < 10)
//                val += "0";
//            val += String.valueOf(startHour);
//
////            System.out.println("SM: "+ startMin);
//            if(startMin < 10)
//                val += "0";
//            val += String.valueOf(startMin);
//
//            result.add(val);
//        }
//        System.out.println(startHour+" "+ endHour);
//        System.out.println(result);
//
//
//
//
//
//
//
//    }
//
//
//}


import java.util.*;

public class FiveMinIntervals {
    class Time {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Time time = (Time) o;
            return day == time.day && hour == time.hour && min == time.min && dayTime == time.dayTime;
        }

        @Override
        public int hashCode() {
            return Objects.hash(day, hour, min, dayTime);
        }

        int day;
        int hour;
        int min;
        boolean dayTime;

        Time(int day, int hour, int min, boolean isDay) {
            this.day = day;
            this.hour = hour;
            this.min = min;
            this.dayTime = isDay;
        }

        private void add(int mins) {
            hour += (mins + min) / 60; // every hour has 60 minutes so do by 60
            min = (mins + min) % 60; // max minutes in an hour is 60 % 60, to reset counter back.
            if (hour == 12) { // if hour is 12, need to check if its am or pm and change day accordingly
                dayTime = !dayTime; //check if morning or evening
                hour = 0;
                if (dayTime) { // if evening, falls to next day
                    day = (day + 1) % 7;
                }
            }
        }

        private int getNumeric() {
            int addHour = hour;
            if (format.equals("24 HOUR")) { // if 24 hour format, then check daytime, if its true, add + 12 to hour.
                addHour = dayTime ? hour : hour + 12;
            }

            int dayAndHour = (day * 100) + addHour;
            return (dayAndHour * 100) + min;
        }

        private boolean areEqual(Time t2) {
            return day == t2.day &&
                    hour == t2.hour &&
                    min == t2.min &&
                    Boolean.compare(dayTime, t2.dayTime) == 0;
        }
    }

    private Map<String, Integer> mapDays = new HashMap<>();
    private String format;

    private List<Integer> getIntervals(String start, String end, String format) {
        this.format = format;
        mapDays();
        List<Integer> intervals = new ArrayList<>();
        Time startTime = getTime(start);
        Time endTime = getTime(end);
        while (!startTime.areEqual(endTime)) {
            startTime.add(5);
            intervals.add(startTime.getNumeric());
        }
        return intervals;
    }

    //Convert string to time format
    private Time getTime(String time) {
        String[] info = time.split(" ");
        String[] hrMin = info[1].split(":");
        boolean dayTime = info[2].equals("am");
        return new Time(mapDays.get(info[0]), Integer.parseInt(hrMin[0]), Integer.parseInt(hrMin[1]), dayTime);
    }

    private void mapDays() {
        mapDays.put("mon", 1);
        mapDays.put("tue", 2);
        mapDays.put("wed", 3);
        mapDays.put("thu", 4);
        mapDays.put("fri", 5);
        mapDays.put("sat", 6);
        mapDays.put("sun", 7);
    }

    public static void main(String[] args) {
        FiveMinIntervals startEndTimeInterval = new FiveMinIntervals();
        List<Integer> data = startEndTimeInterval.getIntervals("mon 11:50 am", "mon 1:00 pm", "12 HOUR");
        System.out.println(data.size());
        System.out.println(data);

//        List<Integer> data2 = startEndTimeInterval.getIntervals("mon 10:00 pm", "tue 11:00 pm", "24 HOUR");
//        System.out.println(data2.size());
//        System.out.println(data2);
//
//        List<Integer> data3 = startEndTimeInterval.getIntervals("sun 10:00 pm", "mon 11:00 pm", "24 HOUR");
//        System.out.println(data3.size());
//        System.out.println(data3);
    }
}


//[11155, 10000, 10005, 10010, 10015, 10020, 10025, 10030, 10035, 10040, 10045, 10050, 10055, 10100]
