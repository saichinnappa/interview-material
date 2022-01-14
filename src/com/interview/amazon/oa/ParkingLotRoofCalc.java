package com.interview.amazon.oa;

public class ParkingLotRoofCalc {
    public static void main(String[] args) {
        int[] lot = {12, 6, 5, 2};
        int k = 3;
        int roofLength = Integer.MAX_VALUE;
        int startWindow = 1;
        int currentLength = 0;
        for (int endWindow = 1; endWindow < lot.length; endWindow++) {
            int diff = Math.abs(lot[endWindow] - lot[endWindow - 1]);
            currentLength += diff;
            if (endWindow >= k - 1) {
                roofLength = Math.min(currentLength, roofLength);
                currentLength -= Math.abs(lot[startWindow] - lot[startWindow - 1]);
                startWindow++;
            }
        }
        System.out.println("RESULT>>>>" + (roofLength + 1));
    }
}
