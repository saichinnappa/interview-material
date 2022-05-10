package com.interview.doordash.oa;

import java.util.*;

//https://leetcode.com/discuss/interview-question/1293040/Doordash-or-Phone-Screen-or-Software-Engineer-E4-or-Closest-Drivers-to-Restaurant
public class ClosestDrivers {

    static class Dasher {
        int id;
        Location lastKnownLocation;
        int rating;

        double distFromRestaurant;
        public Dasher(int id, Location lastKnownLocation, int rating, double distFromRestaurant) {
            this.id = id;
            this.lastKnownLocation = lastKnownLocation;
            this.rating = rating;
            this.distFromRestaurant = distFromRestaurant;
        }

    }

   static class Location {
        double longitude;
        double latitude;

        public Location(double longitude, double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }
    }

   static class ResultComparator implements Comparator<Dasher> {
       @Override
       public int compare(Dasher o1, Dasher o2) {
           if(o1.distFromRestaurant == o2.distFromRestaurant){
               return o1.rating > o2.rating ? -1 : 1;
           }
           return o1.distFromRestaurant > o2.distFromRestaurant ? 1 : -1;
       }
   }


    public static void main(String[] args) {

        Dasher d1 = new Dasher(1, new Location(2.0, 5.0), 95, 0);
        Dasher d2 = new Dasher(2, new Location(2.0, 5.0), 80, 0);
        Dasher d3 = new Dasher(3, new Location(3.0, 6.0), 60, 0);
        Dasher d4 = new Dasher(4, new Location(3.0, 6.0), 90, 0);
        Dasher d5 = new Dasher(5, new Location(5.0, 8.0), 91, 0);
        Dasher d6 = new Dasher(6, new Location(6.0, 9.0), 60, 0);
        Dasher d7 = new Dasher(6, new Location(6.0, 9.0), 61, 0);
        List<Dasher> dashers = Arrays.asList(d1, d2, d3, d4, d5, d6, d7);
        List<Integer> result = getDashers(dashers, new Location(3, 5), 3);
        System.out.println(result);
    }

    private static List<Integer> getDashers(List<Dasher> dashers, Location location, int maxSize) {
        PriorityQueue<Dasher> queue = new PriorityQueue<>(new ResultComparator());
        for(Dasher d : dashers){
            d.distFromRestaurant = Math.sqrt(Math.pow(location.latitude - d.lastKnownLocation.latitude, 2) + Math.pow(location.longitude - d.lastKnownLocation.longitude, 2));
            queue.offer(d);
        }
        List<Integer> result = new ArrayList<>();

        int i = 0;
        while(queue.size() >= maxSize && i != maxSize){
            result.add(queue.poll().id);
            i++;
        }

//        for(int i = 0; i < 3; i++){
//            result.add(queue.poll().id);
//        }
        return result;
    }
}



