package com.practice.misc.java.concepts;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class Demo {
    public static void main(String[] args) throws ParseException {


//        List<Integer> list = Arrays.asList(1,2,3,4,5);
//        System.out.println(list.toArray(new int[0][0]));
//        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
//
//
//        //covert char to int;
//        String s = "abcde";
//        System.out.println("############ CHAR -> INT ##############");
//        for(char c : s.toCharArray()){
//            System.out.println(c +"->"+ (int)(c));
//        }
//
//        //convert int to char;
//        int[] arr = {65, 66, 67, 68, 69, 122};
//        System.out.println("############ INT -> CHAR ##############");
//        for(int i : arr){
//            System.out.println(i +"->"+ (char)(i));
//        }
//
//        //convert string to int array
//        System.out.println("############ STRING -> INT[] ##############");
//        String s1 = "abcd";
//        int[] arr1 = new int[26];
//        for(int i = 0; i < s1.length(); i++){
//            arr1[s1.charAt(i) - 'a']++;
//        }
//        System.out.println(Arrays.toString(arr1));


//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
//        String dateInString = "2022-09-17T16:22:06Z";
//
//        try {
//
//            Date date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
//            System.out.println(date);
//
//            System.out.println("time zone : " + TimeZone.getDefault().getID());
//            System.out.println(formatter.format(date));
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


        String dateInString = "2022-09-22T18:40:44Z";
        Instant instant = Instant.parse(dateInString);
        System.out.println(instant);
        Date myDate = Date.from(instant);
        Timestamp current = Timestamp.from(instant);
        System.out.println(current.toString());
        Date dateInAmerica = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a").parse(current.toString());
        System.out.println(dateInAmerica); // 2017-03-14 08:16:32.621

        DateFormat df = DateFormat.getDateTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("CST"));
        System.out.println("Timestamp in UTC: " + df.format(current));

//        System.out.println(myDate);
//        String convertedDate = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a").format(myDate);
//        System.out.println(convertedDate);
//        SimpleDateFormat sdfAmerica = new SimpleDateFormat("dd-MMM-yy hh:mm:sss a");
//        Date dateInAmerica = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a").parse(dateInString);
//        System.out.println(dateInAmerica);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a");
//        formatter.setTimeZone(TimeZone.getTimeZone("CST"));
//        String formattedDate = formatter.format(myDate);
//        System.out.println(formattedDate);
//
//        System.out.println(instant);
//
//        //get date time only
//        LocalDateTime result = LocalDateTime.ofInstant(instant, ZoneId.of());
//
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yy hh:mm:ss a");
//        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("CST"));
////        simpleDateFormat.parse(dateInString);
//        Date date = Date.from(result.atZone(ZoneId.systemDefault()).toInstant());
//        String dateFormat = simpleDateFormat.format(date);
//
//        System.out.println(dateFormat);

        //get date time + timezone
//        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Africa/Tripoli"));
//        System.out.println(zonedDateTime);
//
//        //get date time + timezone
//        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Europe/Athens"));
//        System.out.println(zonedDateTime2);

//        String sDate1="2022-09-10 22:01:31";
//        Date date1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sDate1);
//        DateFormat gmtFormat = new SimpleDateFormat();
//        TimeZone gmtTime = TimeZone.getTimeZone("GMT");
//        gmtFormat.setTimeZone(gmtTime);
//        System.out.println("GMT Time: " + gmtFormat.format(date1));

    }
}
