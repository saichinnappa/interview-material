package com.interview.doordash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/discuss/interview-question/1293040/Doordash-or-Phone-Screen-or-Software-Engineer-E4-or-Closest-Drivers-to-Restaurant
public class ClosestDrivers {

    static class Dasher {
        int id;
        Location lastKnownLocation;
        int rating;

        public Dasher(int id, Location lastKnownLocation, int rating) {
            this.id = id;
            this.lastKnownLocation = lastKnownLocation;
            this.rating = rating;
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

    static class Result {
        int dasherId;
        double dist;

        public Result(int dasherId, double dist) {
            this.dasherId = dasherId;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "dasherId=" + dasherId +
                    ", dist=" + dist +
                    '}';
        }
    }


    public static void main(String[] args) {

        Dasher d1 = new Dasher(1, new Location(1.0, 3.0), 50);
        Dasher d2 = new Dasher(2, new Location(2.0, 5.0), 80);
        Dasher d3 = new Dasher(3, new Location(3.0, 6.0), 60);
        Dasher d4 = new Dasher(4, new Location(3.0, 6.0), 90);
        Dasher d5 = new Dasher(5, new Location(5.0, 8.0), 91);
        Dasher d6 = new Dasher(6, new Location(6.0, 9.0), 60);
        Dasher d7 = new Dasher(6, new Location(6.0, 9.0), 61);
        List<Dasher> dashers = Arrays.asList(d1, d2, d3, d4, d5, d6, d7);
        List<Integer> result = getDashers(dashers, new Location(3, 5));
        System.out.println(result);
    }

    private static List<Integer> getDashers(List<Dasher> dashers, Location location) {
        PriorityQueue<Result> queue = new PriorityQueue<>((r1, r2) -> Double.compare(r1.dist, r2.dist));
        for(Dasher d : dashers){
            double dist = Math.sqrt(Math.pow(location.latitude - d.lastKnownLocation.latitude, 2) + Math.pow(location.longitude - d.lastKnownLocation.longitude, 2));
            Result r = new Result(d.id, dist);
            if(queue.size() > 0){
                Result r1 = queue.peek();
            }
            System.out.println(r);
            queue.offer(r);

        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            result.add(queue.poll().dasherId);
        }

        return result;
    }


}

