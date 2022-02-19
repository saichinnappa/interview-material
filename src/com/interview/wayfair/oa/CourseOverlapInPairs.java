package com.interview.wayfair.oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are a developer for a university. Your current project is to develop a system for students to find courses they share with friends. The university has a system for querying courses students are enrolled in, returned as a list of (ID, course) pairs.
 * Write a function that takes in a list of (student ID number, course name) pairs and returns, for every pair of students, a list of all courses they share.
 * <p>
 * student_course_pairs_1 = {
 * {"58", "Software Design"},
 * {"58", "Linear Algebra"},
 * {"94", "Art History"},
 * {"94", "Operating Systems"},
 * {"17", "Software Design"},
 * {"58", "Mechanics"},
 * {"58", "Economics"},
 * {"17", "Linear Algebra"},
 * {"17", "Political Science"},
 * {"94", "Economics"},
 * {"25", "Economics"},
 * }
 * <p>
 * Output:
 * {
 * [58, 17]: ["Software Design", "Linear Algebra"]
 * [58, 94]: ["Economics"]
 * [58, 25]: ["Economics"]
 * [94, 25]: ["Economics"]
 * [17, 94]: []
 * [17, 25]: []
 * }
 */
public class CourseOverlapInPairs {
    public static void main(String[] args) {
        String[][] courses = {
                {"58", "Software Design" },
                {"58", "Linear Algebra" },
                {"94", "Art History" },
                {"94", "Operating Systems" },
                {"17", "Software Design" },
                {"58", "Mechanics" },
                {"58", "Economics" },
                {"17", "Linear Algebra" },
                {"17", "Political Science" },
                {"94", "Economics" },
                {"25", "Economics" },
        };
        Map<String, List<String>> courseMap = new HashMap<>();
        for (String[] course : courses) {
            courseMap.putIfAbsent(course[0], new ArrayList<>());
            courseMap.get(course[0]).add(course[1]);
        }

//        for (Map.Entry<String, List<String>> entry : courseMap.entrySet()) {
//            System.out.println(entry.getKey() + " -> " + entry.getValue());
//        }

        List<String> studentIdList = new ArrayList<>(courseMap.keySet());

        for (int i = 0; i < studentIdList.size(); i++) {
            String studentOneId = studentIdList.get(i);
            List<String> studentOneCourseList = courseMap.get(studentOneId);
            for (int l = i + 1; l < studentIdList.size(); l++) {
                String studentTwoId = studentIdList.get(l);
                List<String> studentTwoCourseList = courseMap.get(studentTwoId);
                List<String> overLap = new ArrayList<>();
                for (String s : studentOneCourseList) {
                    for (String value : studentTwoCourseList) {
                        if (s.equals(value)) {
                            overLap.add(s);
                        }
                    }
                }
                System.out.println("[" + studentOneId + ", " + studentTwoId + "]" + overLap);
            }
        }
    }
}
