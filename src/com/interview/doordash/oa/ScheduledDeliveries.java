package com.interview.doordash.oa;

// https://leetcode.com/company/doordash/discuss/1920251/Doordash-or-Phone-or-Claim-Scheduled-Deliveries
// https://leetcode.com/discuss/interview-question/1544410/Doordash-TPS-Senior-Software-Engineer

//import java.time.LocalDateTime;
//import java.util.*;
//
///**
// * deliveries = [
// * { “id”: “one”, “pickupTime”: “2021/01/15 10:00”, “storeId”: “store_1” },
// * { “id”: “two”, “pickupTime”: “2021/01/16 6:00”, “storeId”: “store_1” }
// * ];
// *
// * dasher = { “id”: “dasher_1”, “tier”: “low” };
// *
// * getAvailableDeliveries(dasher, deliveries, 2021/01/15 18:00) -> [“one”]
// */
//public class ScheduledDeliveries {
//
//    public static void main(String[] args) {
//        List<Delivery> deliveries = new ArrayList<>();
//        deliveries.add(new Delivery("one", LocalDateTime.of(2022, 5, 8, 10, 0), "store_1"));
//        deliveries.add(new Delivery("two", LocalDateTime.of(2022, 5, 8, 12, 0), "store_1"));
//        deliveries.add(new Delivery("three", LocalDateTime.of(2022, 5, 7, 20, 0), "store_1"));
//
//        List<Dasher> dasherList = new ArrayList<>();
//        dasherList.add(new Dasher("dasher_1", "low"));
//        dasherList.add(new Dasher("dasher_2", "high"));
//
//
//        Map<String, Set<String>> result = getDeliveries(deliveries, dasherList, LocalDateTime.now());
//        System.out.println(result);
//
//    }
//
//    private static Map<String, Set<String>> getDeliveries(List<Delivery> deliveries, List<Dasher> dasherList, LocalDateTime now) {
//
//        int currentHour = 18;
//        int currentMin = now.getMinute();
//
//        Map<String, Set<String>> result = new HashMap<>();
//        Set<String> lowTierList = new HashSet<>();
//        Set<String> highTierList = new HashSet<>();
//
//        for(Delivery delivery : deliveries){
//            if(currentHour >= 18 && currentHour < 19){
//                highTierList.add(delivery.id);
//            } else if(currentHour >= 19 ){
//                highTierList.add(delivery.id);
//                lowTierList.add(delivery.id);
//            }
//            if(delivery.localDateTime.getDayOfMonth() == now.getDayOfMonth()){
//                highTierList.add(delivery.id);
//                lowTierList.add(delivery.id);
//            }
//        }
//
//        for(Dasher dasher : dasherList) {
//            if (dasher.tier.equals("low"))
//                result.put(dasher.id, lowTierList);
//            else
//                result.put(dasher.id, highTierList);
//        }
//    return result;
//    }
//}
//
//class Delivery {
//    String id;
//    LocalDateTime localDateTime;
//    String storeId;
//
//    Delivery(String id, LocalDateTime localDateTime, String storeId){
//        this.id = id;
//        this.localDateTime = localDateTime;
//        this.storeId = storeId;
//    }
//}
//
//class Dasher{
//    String id;
//    String tier;
//
//    Dasher(String id, String tier){
//        this.id = id;
//        this.tier = tier;
//    }
//}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

enum Status {
    LOW,
    HIGH
}
class Dasher{
    String name;
    Status status;
    public Dasher(){}
    public Dasher(String name, Status status){
        this.name = name;
        this.status = status;
    }
}
class Delivery{
    //Delivery('1', today + timedelta(hours=10), 'store_1'),
    String name;
    long timedelta;
    String store;
    public Delivery(){}
    public Delivery(String name, long timedelta, String store){
        this.name = name;
        this.timedelta = timedelta;
        this.store = store;
    }
}

class Time{
    //2021, 1, 15
    int year;
    int month;
    int day;
    int hour;

    public Time(){}
    public Time(int year, int month, int day, int hour){
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }
    public boolean compareTime(Time t2, Status status, LocalDateTime today){
        boolean canSeeNextDay = false;
        if((today.getHour() >= 18 && status == Status.HIGH) || today.getHour() >= 19){
            canSeeNextDay = true;
        }

        if(this.year != t2.year || this.month != t2.month)
            return false;

        int diffDay = Math.abs(t2.day - today.getDayOfMonth());
        if(diffDay == 0)
            return true;
        if(canSeeNextDay && diffDay  == 1){
            return true;
        }


        return false;

    }
}

public class ScheduledDeliveries {

    /*
     high tier dashers can see all of next day deliveries if the current time is 18:00 or later
     all dashers can see all of next day deliveries if the current time is 19:00 or later
     all dashers can see same day deliveries anytime
     * */
    public static Time getTime(long timedelta, LocalDateTime today){
        LocalDateTime newDate = today.plusHours(timedelta);
        System.out.println(newDate);
        Time time = new Time(newDate.getYear(), newDate.getMonthValue(), newDate.getDayOfMonth(), newDate.getHour());
        return time;
    }

    private static List<Delivery> getAvailableDeliveries(Dasher dasher, List<Delivery> all_deliveries, LocalDateTime today){
        Time time = getTime(0, today);
        List<Delivery> available_delivery_list = new ArrayList<>();
        for(Delivery delivery : all_deliveries){
            Time delivery_time = getTime(delivery.timedelta, today);
            if(time.compareTime(delivery_time, dasher.status, today)){
                available_delivery_list.add(delivery);
            }
        }
        return available_delivery_list;
    }

    public static void main(String[] args) {
        /*
        Sample test.
        today = datetime(2021, 1, 15)
        dasher = Dasher('dasher', 'low')
        deliveries = [
        Delivery('1', today + timedelta(hours=10), 'store_1'),
        Delivery('2', today + timedelta(hours=30), 'store_1')
        ]
        available_deliveries = get_available_deliveries(
        dasher=dasher,
        deliveries=deliveries,
        current_time=today + timedelta(hours=18)
        )*/

        Dasher dasher = new Dasher("Dasher_1", Status.HIGH);
        List<Delivery> all_deliveries = new ArrayList<>();
        Delivery delivery1 = new Delivery("DEL_1", 10, "Store_1");
        all_deliveries.add(delivery1);
        Delivery delivery2 = new Delivery("DEL_2", 11, "Store_2");
        all_deliveries.add(delivery2);

        Delivery delivery3 = new Delivery("DEL_3", 12, "Store_2");
        all_deliveries.add(delivery3);

        Delivery delivery4 = new Delivery("DEL_4", 14, "Store_2");
        all_deliveries.add(delivery4);

        String inputTodayDate = "2021-01-15 18:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime today = LocalDateTime.parse(inputTodayDate, formatter);

        List<Delivery> available_delivery_list = getAvailableDeliveries(dasher, all_deliveries, today);
//        System.out.print("available_delivery_list is :  ");
        for(Delivery del : available_delivery_list){
            System.out.println(del.name + " <> "+ today.plusHours(del.timedelta));
        }

    }
}
