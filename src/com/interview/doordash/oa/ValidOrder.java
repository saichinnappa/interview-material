package com.interview.doordash.oa;

import java.util.*;

// given an pickup delivery list, return whether it is valid or not
public class ValidOrder {
    public static void main(String[] args) {
//        String[] input = {"P1", "P3", "P2", "D3", "P4", "P404", "D2", "D1", "D404", "D4",
//                "P33", "D33"};
//        System.out.println(validateOrder(input));

        List<String> input = Arrays.asList("P1", "D1");
        System.out.println(getLongestValidOrderBetter(input));

    }

    private static boolean validateOrder(String[] input){
        Set<Integer> pickupSet = new HashSet<>();
        Set<Integer> dropoffSet = new HashSet<>();
        for(String s : input){
            char prefix = s.charAt(0);
            int id = Integer.parseInt(s.substring(1));
            if(prefix == 'P'){
                if(pickupSet.contains(id))
                    return false;
                pickupSet.add(id);
            }else if(prefix == 'D'){
                if(!pickupSet.contains(id) || dropoffSet.contains(id))
                    return false;
                else
                    dropoffSet.add(id);
            } else{
                return false;
            }
        }
        return pickupSet.size() == dropoffSet.size();
    }



    public static List<String> getLongestValidOrderBetter(List<String> orders) {
        int n = orders.size();
        Map<Integer, Integer> picks = new HashMap<>(); // stores the last index of Pick i.
        Set<Integer> drops = new HashSet<>(); // stores the drop index
        boolean[] isValid = new boolean[n]; // will store if pick or drop at index i is valid or invalid.
        for(int i = 0;i<orders.size();i++) {
            String ord = orders.get(i);
            int id = Integer.parseInt(ord.substring(1));
            isValid[i] = false; // assume to be invalid by default.
            if (ord.charAt(0) == 'P') {
                picks.put(id, i);  // update this regardless since this will always reset and store last index for ith Pick.
            } else {
                if (picks.containsKey(id) && !drops.contains(id)) {
                    int idx = picks.get(id);
                    isValid[idx] = true;
                    isValid[i] = true;
                }
                drops.add(id);
            }
        }
        // below we apply longest valid parenthesis string algo. Here any pickup is equal to "(" and drop is equal to ")".
        int l = 0, r = 0;
        int max = 0, maxStart = 0, maxEnd = 0;
        //Scan list from left to right
        for(int i = 0;i<isValid.length;i++) {
            //only if order is valid
            if (isValid[i]) {
                //and its pickup increment pickup
                if (orders.get(i).startsWith("P")) {
                    l++;
                // else increment Drop
                } else {
                    r++;
                }
                //if an order is invalid reset pickup and drop to zero
            } else {
                l = 0;
                r = 0;
            }
            // if both are equal, keep track of the start and end index.
            if (l == r) {
                int curr = l + r;
                if (curr > max) {
                    max = curr;
                    maxStart = i - curr + 1;
                    maxEnd = i;
                }
                //at any point if deliveries are more than pickups reset the counter.
            } else if (r > l) {
                l = 0;
                r = 0;
            }
        }
        l = r = 0;
        //Now start right to left
        for(int i = isValid.length - 1;i>=0;i--) {
            if (isValid[i]) {
                if (orders.get(i).startsWith("P")) {
                    l++;
                } else {
                    r++;
                }
            } else {
                l = 0;
                r = 0;
            }
            if (l == r) {
                int curr = l + r;
                if (curr > max) {
                    max = curr;
                    maxEnd= i + curr - 1;
                    maxStart = i;
                }
            } else if ( l > r) {
                l = 0;
                r = 0;
            }
        }
        List<String> ans = new ArrayList<>();
        if (max > 1) { // orders are in pair we need minimum valid length of 2.
            for (int i = maxStart; i <= maxEnd; i++) {
                ans.add(orders.get(i));
            }
        }
        return ans;
    }



}
