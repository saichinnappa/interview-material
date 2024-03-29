package com.interview.amazon.oa;

/**
 * https://leetcode.com/discuss/interview-question/1643403/Amazon-OA-SDE-1
 * https://leetcode.com/problems/range-addition/
 */
public class WifiCoverage {
    public static void main(String[] args) {
        int[] buildingCount = {1, 2, 1, 2, 2};
        int[] routerLocation = {3, 1};
        int[] routerRange = {1, 2};
        int[] coverage = new int[buildingCount.length];

        int coverageArea = 0;

        // BRUTE FORCE
//        for (int i = 0; i < routerLocation.length; i++) {
//            int startCoverage = Math.abs(routerLocation[i] - routerRange[i]) - 1; //covert 1 based to 0 based index;
//            int endCoverage = routerLocation[i] + routerRange[i] - 1;
//            while (startCoverage != endCoverage + 1) {
//                coverage[startCoverage]++;
//                startCoverage++;
//            }
//        }
//
//        for (int i = 0; i < coverage.length; i++) {
//            if (buildingCount[i] <= coverage[i]) {
//                coverageArea++;
//            }
//        }
//        System.out.println(coverageArea);
        // OPTIMIZED
        for (int i = 0; i < routerLocation.length; i++) {
            int startBuilding = Math.abs(routerLocation[i] - routerRange[i]) - 1;
            int endBuilding = (Math.abs(routerLocation[i] + routerRange[i]) - 1) + 1;
            coverage[startBuilding] = 1;
            if (endBuilding + 1 < coverage.length)
                coverage[endBuilding + 1] = -1;
        }

        if (coverage[0] == buildingCount[0]) coverageArea++;

        for (int i = 1; i < coverage.length; i++) {
            coverage[i] += coverage[i - 1];
            if (coverage[i] == buildingCount[i])
                coverageArea++;
        }

        System.out.println("Total Coverage is: " + coverageArea);

    }

}
