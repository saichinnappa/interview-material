package com.interview.doordash.oa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PickupDeliveryPermutations {

    public static void main(String[] args) {
        Set<String> pickupSet = new HashSet<>();
        Set<String> deliverySet = new HashSet<>();
        List<String> patterns = new ArrayList<>();
        List<String> pattern = new ArrayList<>();
        int n = 2;
        findPattern(pickupSet, deliverySet, patterns, pattern, n);
        System.out.println(patterns);
    }

    private static void findPattern(Set<String> pickupSet, Set<String> deliverySet, List<String> patterns, List<String> pattern, int n) {
        if(pattern.size() == n * 2){
            patterns.add(String.join("->", pattern));
        } else{
            for(int i = 0; i < n ; i++){
                String pId = "P" + i;
                String dId =  "D" + i;
                if(!pickupSet.contains(pId)){
                    pickupSet.add(pId);
                    pattern.add(pId);
                    findPattern(pickupSet, deliverySet, patterns, pattern, n);
                    pattern.remove(pId);
                    pickupSet.remove(pId);
                }
                if(pickupSet.contains(pId) && !deliverySet.contains(dId)){
                    deliverySet.add(dId);
                    pattern.add(dId);
                    findPattern(pickupSet, deliverySet, patterns, pattern, n);
                    deliverySet.remove(dId);
                    pattern.remove(dId);
                }
            }
        }
    }
}

