package com.practice.leetcode.graphs;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Topological sort - Graph theory (Kahn's algorithm)
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int courses = 4;

        int[] result = findOrder(prerequisites, courses);
        System.out.println(Arrays.toString(result));
    }

    private static int[] findOrder(int[][] prerequisites, int courses) {
        int[] result = new int[courses];
        //Course pre-req calculation (in degree of a vertex in graph)
        int[] preReqCount = new int[courses];

        for (int[] prerequisite : prerequisites) {
            preReqCount[prerequisite[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        for (int c : preReqCount) {
            if (c == 0) {
                queue.offer(c);
            }
        }

        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
            for (int i = 0; i < preReqCount.length; i++) {
                preReqCount[i]--;
                if (preReqCount[i] == 0) {
                    queue.offer(i);
                }
            }
        }

        return result;
    }

}
