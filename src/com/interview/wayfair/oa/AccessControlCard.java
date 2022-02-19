package com.interview.wayfair.oa;

import java.util.*;

// Find two lists, one - who entered without badge, two - who left without swiping the badge.
public class AccessControlCard {
    public static void main(String[] args) {
        String[][] badgeRecords = {
                {"Martha", "exit" },
                {"Paul", "enter" },
                {"Martha", "enter" },
                {"Martha", "exit" },
                {"Jennifer", "enter" },
                {"Paul", "enter" },
                {"Curtis", "enter" },
                {"Paul", "exit" },
                {"Martha", "enter" },
                {"Martha", "exit" },
                {"Jennifer", "exit" },
        };

        Set<String> exitList = new HashSet<>();
        Set<String> entryList = new HashSet<>();

        Map<String, List<String>> userRecord = new HashMap<>();
        for (String[] record : badgeRecords) {
            String name = record[0];
            String type = record[1];
            if (!userRecord.containsKey(name))
                userRecord.put(name, new ArrayList<>());
            List<String> list = userRecord.get(name);
            if (type.equals("exit")) {
                if (list.size() == 0) {
                    entryList.add(name);
                } else if (list.get(list.size() - 1).equals("exit")) {
                    entryList.add(name);
                }
            } else {
                if (list.size() > 0 && list.get(list.size() - 1).equals("enter")) {
                    exitList.add(name);
                }
            }
            userRecord.get(name).add(type);
        }

        for (Map.Entry<String, List<String>> entry : userRecord.entrySet()) {
            if (entry.getValue().size() == 1 && entry.getValue().get(0).equals("enter")) {
                exitList.add(entry.getKey());
            }
        }
        String[][] arr = new String[2][entryList.size() + exitList.size()];
        entryList.toArray(arr[0]);
        exitList.toArray(arr[1]);
        System.out.println("Entry List-> " + Arrays.deepToString(arr));
        System.out.println("Exit List-> " + exitList);

    }
}
