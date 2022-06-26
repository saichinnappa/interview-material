package com.interview.doordash.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Nearest Neighbour City
 *
 * A number of cities are arranged on a graph that has been divided up like an ordinary Cartesian plane. Each city is located at an integral (x, y) coordinate intersection.
 * City names and locations are given in the form of three arrays: c, x, and y, which are aligned by the index to provide the city name (c[i]), and its coordinates, (x[i], y[i]).
 * Determine the name of the nearest city that shares either an x or a y coordinate with the queried city. If no other cities share an x or y coordinate, return 'NONE'.
 * If two cities have the same distance to the queried city, q[i], consider the one with an alphabetically shorter name (i.e. 'ab' < 'aba' < 'abb') as the closest choice.
 * The distance is the Manhattan distance, the absolute difference in x plus the absolute difference in y.
 */
public class NearestNeighborCity {
    public static void main(String[] args) {
        String[] cities = {"c1", "c2", "c3"};
        int[] xValues = {3,2,1};
        int[] yValues = {3,2,3};
        String[] queries = {"c1", "c2", "c3"};
        System.out.println(closestCities(cities, xValues, yValues, queries));
    }

    private static List<String> closestCities(String[] cities, int[] x, int[] y, String[] queries) {
        int n = cities.length;
        Map<String, Integer> map = new HashMap<>(); // city : index
        for(int i=0; i<n; i++) {
            map.put(cities[i], i);
        }

        List<String> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++) {
            res.add(getClosestCity(cities, x, y, queries[i], map));
        }
        return res;
    }

    private static String getClosestCity(String[] cities, int[] x, int[] y, String queryCity, Map<String, Integer> map) {
        int res = -1, minDist = Integer.MAX_VALUE;
        if(!map.containsKey(queryCity)) return "NONE";

        int queryIndex = map.get(queryCity);
        int r = x[queryIndex], c = y[queryIndex];
        for(int i=0; i<cities.length; i++) {
            if(i == queryIndex) continue;
            if(x[i] == r || y[i] == c) {
                int dist = Math.abs(x[i]-r) + Math.abs(y[i]-c);
                if(dist < minDist) {
                    res = i;
                    minDist = dist;
                } else if(dist == minDist) {
                    if(cities[i].compareTo(cities[res]) < 0) {
                        res = i;
                    }
                }
            }
        }
        return res == -1 ? "NONE" : cities[res];
    }
}
