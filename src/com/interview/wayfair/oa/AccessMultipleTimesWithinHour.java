package com.interview.wayfair.oa;

import java.util.*;

public class AccessMultipleTimesWithinHour {
    public static void main(String[] args) {
        String[][] input = {{"James", "1300" }, {"Martha", "1600" }, {"Martha", "1620" }, {"Martha", "1530" }};
        Map<String, List<String>> map = new HashMap<>();
        for (String[] i : input) {
            map.putIfAbsent(i[0], new ArrayList<>());
            map.get(i[0]).add(i[1]);
        }

        Map<String, List<String>> resultMap = new HashMap<>();

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            Collections.sort(entry.getValue());
            List<String> timeList = entry.getValue();
            int count = 1;
            List<String> resultTime = new ArrayList<>();
            resultTime.add(timeList.get(0));
            for (int i = 0; i < timeList.size() - 1; i++) {
                if (!moreThan1Hr(timeList.get(i + 1), timeList.get(i))) {
                    count++;
                    resultTime.add(timeList.get(i + 1));
                }
                if (count == 3) {
                    resultMap.put(entry.getKey(), resultTime);
                    break;
                }
            }
        }
        System.out.println(resultMap);

    }

    static boolean moreThan1Hr(String t1, String t2) {
        int t1Hour = Integer.parseInt(t1.substring(0, 2));
        int t2Hour = Integer.parseInt(t2.substring(0, 2));
        int t1Min = Integer.parseInt(t1.substring(2, 4));
        int t2Min = Integer.parseInt(t2.substring(2, 4));

        return (t1Hour - t2Hour) > 1 || (t1Hour - t2Hour == 1) && (t1Min - t2Min) > 0;
    }
}

//class TimeComparator implements Comparator<String> {
//
//    @Override
//    public int compare(String s1, String s2) {
//        if (s1 == null || s2 == null) return 0;
//        if (s1.equals(s2)) return 0;
//        return s1.compareTo(s2);
//    }
//}
