package com.interview.amazon.oa;

/**
 * Efficient Harvest: A farmer uses pivot irrigation to water a circular field of crops. Due to varying conditions, the field does not produce consistently.
 * The farmer wants to achieve maximum profit using limited resources for harvest. The field is segmented into a number of equal segments, and a profit is calculated for each segment.
 * This profit is the cost to harvest versus the sale price a the produce. The farmer will harvest a number of contiguous segments along with those opposite.
 * Determine the maximum profit the farmer can achieve. For example, the field is divided into n = 6 sections and will select k = 2 contiguous sections and those opposite for harvest. The profit estimates are profit = [1, 5, 1, 3, 7.-3) respectively.
 * The diagrams below show the possible choices with profits(0) at the 9 o'clock position and filling counterclockwise. -3 The profit levels, from left to right, are 1 + 5+7 + 3 - 16,5+1 +7 +-3-10, and 1 + 3+3+1 -2.
 * The maximum profit is 16. Function Description Complete the function maxProfit in the editor below.
 * The function must return the maximum profit achievable. maxProfit has the following parameters: k an integer denoting the half of the needed amount of pieces of the field. profit[profit[0],..profit[n-1].
 * <p>
 * https://leetcode.com/discuss/interview-question/1321204/efficient-harvest-faang-oa-question-2021
 */

public class EfficientHarvest {
    public static void main(String[] args) {
        int[] field = {1, 5, 1, 3, 7, -3};
        int k = 2;
        int n = field.length;
        int result = Integer.MIN_VALUE;
        int currentSum = 0, start = 0;
        //Iterating half the array is good enough, since for the first half of the array we do compute the opposite indices
        //To compute opposite index, given current index i -> [i + (length of the array)/2];
        for (int i = 0; i < field.length / 2; i++) {
            currentSum += field[i];
            //once we reach minimum fields
            if (i >= k - 1) {
                int x = i;
                int localSum = currentSum;
                //add the opposite fields profits to current window
                while (x >= start) {
                    localSum += field[(x + n / 2)];
                    x--;
                }
                //store if max in result
                result = Math.max(localSum, result);
                //since we need to compute the next field, first field removed from the calc
                currentSum = Math.abs(currentSum - field[start]);
                //move start position by 1
                start++;
            }
        }
        System.out.println("Maximum Profit: " + result);
    }
}
