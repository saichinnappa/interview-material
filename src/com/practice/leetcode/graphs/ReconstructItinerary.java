package com.practice.leetcode.graphs;

import java.util.*;

public class ReconstructItinerary {

    List<String> result = new ArrayList<>();
    Map<String, List<String>> path = new HashMap<>();
    Map<String, Integer> counts = new HashMap<>();
//    String[][] tickets;
//
//    ReconstructItinerary(String[][] tickets) {
//        this.tickets = tickets;
//    }

    public List<String> findItinerary(List<List<String>> tickets) {

        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            List<String> list = path.getOrDefault(src, new ArrayList<>());
            list.add(ticket.get(1));
            Collections.sort(list);
            path.put(src, list);
            counts.put(src, counts.getOrDefault(src, 0) + 1);
        }

        dfs("JFK");


        return result;
    }

    private void dfs(String city) {

        if (counts.get(city) > 0) {
            result.add(city);
            counts.put(city, counts.get(city) - 1);
        }

        List<String> cities = path.get(city);
        for (String city1 : cities) {
            dfs(city1);
        }

    }
}

class Solution {
    public static void main(String[] args) {
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<List<String>>();
        tickets.add(Arrays.asList("MUC", "LHR"));
        tickets.add(Arrays.asList("JFK", "MUC"));
        tickets.add(Arrays.asList("SFO", "SJC"));
        tickets.add(Arrays.asList("LHR", "SFO"));
        reconstructItinerary.findItinerary(tickets);
    }
}
