package com.practice.leetcode.misc;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
//        Double.com
        String[] input = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        PriorityQueue<Test> queue = new PriorityQueue<>((t1, t2) -> t1.a - t2.a);
        int k = 4;
        Map<String, Integer> map = new HashMap<>();
        for(String s: input){
            map.putIfAbsent(s, 0);
            map.put(s, map.get(s) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new CustomComparator());
        String[] result = new String[k];
        int count = 0;
        while(k != count){
            result[count] = list.get(count).getKey();
            count++;
        }
        System.out.println(Arrays.toString(result));
    }

    static class CustomComparator implements Comparator<Map.Entry<String, Integer>> {

        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            if(o1.getValue() == o2.getValue()){
                return o1.getKey().compareTo(o2.getKey());
            }
            return o2.getValue().compareTo(o1.getValue());
        }
    }

    static class Test{
        int a;
        int b;

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

}


