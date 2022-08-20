//package com.practice.misc.java.concepts;
//
//import org.junit.jupiter.api.DisplayNameGenerator;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.Instant;
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZoneOffset;
//import java.time.ZonedDateTime;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//import java.util.TimeZone;
//
//public class Demo {
//    public static void main(String[] args) {
//
//
////        List<Integer> list = Arrays.asList(1,2,3,4,5);
////        System.out.println(list.toArray(new int[0][0]));
////        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
////
////
////        //covert char to int;
////        String s = "abcde";
////        System.out.println("############ CHAR -> INT ##############");
////        for(char c : s.toCharArray()){
////            System.out.println(c +"->"+ (int)(c));
////        }
////
////        //convert int to char;
////        int[] arr = {65, 66, 67, 68, 69, 122};
////        System.out.println("############ INT -> CHAR ##############");
////        for(int i : arr){
////            System.out.println(i +"->"+ (char)(i));
////        }
////
////        //convert string to int array
////        System.out.println("############ STRING -> INT[] ##############");
////        String s1 = "abcd";
////        int[] arr1 = new int[26];
////        for(int i = 0; i < s1.length(); i++){
////            arr1[s1.charAt(i) - 'a']++;
////        }
////        System.out.println(Arrays.toString(arr1));
//
//
////        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
////        String dateInString = "2022-09-17T16:22:06Z";
////
////        try {
////
////            Date date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
////            System.out.println(date);
////
////            System.out.println("time zone : " + TimeZone.getDefault().getID());
////            System.out.println(formatter.format(date));
////
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//
//
//        String dateInString = "2022-09-17T16:22:06Z";
//
//        Instant instant = Instant.parse(dateInString);
//
//        System.out.println(instant);
//
//        //get date time only
//        LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of(ZoneOffset.UTC.getId()));
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss z a");
//
//        simpleDateFormat.parse(dateInString);
//        Date date = Date.from(result.atZone(ZoneId.systemDefault()).toInstant());
//        String dateFormat = simpleDateFormat.format(date);
//
//        System.out.println(dateFormat+"<<<<");
//
//        //get date time + timezone
////        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Africa/Tripoli"));
////        System.out.println(zonedDateTime);
////
////        //get date time + timezone
////        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
////        System.out.println(zonedDateTime2);
//
//
//    }
//}
