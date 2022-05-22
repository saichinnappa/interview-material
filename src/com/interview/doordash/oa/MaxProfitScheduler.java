package com.interview.doordash.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxProfitScheduler {
    static int[] memo = new int[500001];
    public static void main(String[] args) {
        int[] startTime = {1,2,3,3};
        int[] endTime =   {3,4,5,6};
        int[] profit =     {50,10,40,70};
        int sTime = 3;
        int eTime = 7;

        System.out.println(findMaxProfit(startTime, endTime, profit, sTime, eTime));

    }

    private static int findMaxProfit(int[] startTime, int[] endTime, int[] profit, int sTime, int eTime) {
        Arrays.fill(memo, - 1);
        List<List<Integer>> jobs = new ArrayList<>();
        for(int i = 0; i < startTime.length; i++){
            if(startTime[i] >= sTime && endTime[i] <= eTime){
                List<Integer> job = new ArrayList<>();
                job.add(startTime[i]);
                job.add(endTime[i]);
                job.add(profit[i]);
                jobs.add(job);
            }

        }

        jobs.sort((j1, j2) -> j1.get(0) - j2.get(0));

        int[] newStartTime = new int[jobs.size()];
        for(int i = 0; i < newStartTime.length; i++){
            newStartTime[i] = jobs.get(i).get(0);
        }

        return maxProfit(newStartTime, jobs, 0, newStartTime.length);
    }

    private static int maxProfit(int[] startTime, List<List<Integer>> jobs, int position, int length) {
        if(position == length)
            return 0;

        if(memo[position] != -1)
            return memo[position];

        int nextIndex = findNextIndex(startTime, jobs.get(position).get(1));
        int profit = Math.max(maxProfit(startTime, jobs, position + 1, length) , jobs.get(position).get(2) + maxProfit(startTime, jobs, nextIndex, length));
//        int profit = 0;
//        Profit p = new Profit(0, new ArrayList<>());
//        if(maxProfit(startTime, jobs, position + 1, length) > jobs.get(position).get(2) + maxProfit(startTime, jobs, nextIndex, length)){
//            profit = maxProfit(startTime, jobs, position + 1, length);
//            p.value = profit;
//            p.jobs.add(new int[]{position + 1});
//        } else{
//            profit = jobs.get(position).get(2)  + maxProfit(startTime, jobs, nextIndex, length);
//            p.value = profit;
//            p.jobs.add(new int[]{position, nextIndex});
//        }
//        memo[position] = p;
        return memo[position] = profit;
    }

    private static int findNextIndex(int[] startTime, int endValue) {
        int start = 0, end = startTime.length - 1 , nextIndex = startTime.length;
        while(start <= end){
            int mid = (start + end) / 2;
            if(startTime[mid] >= endValue){
                nextIndex = mid;
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return nextIndex;
    }
}

//class Profit{
//    int value;
//    List<int[]> jobs;
//
//    Profit(int value, List<int[]> jobs){
//        this.value = value;
//        this.jobs = jobs;
//    }
//}
