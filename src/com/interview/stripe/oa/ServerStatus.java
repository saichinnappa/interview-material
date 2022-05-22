package com.interview.stripe.oa;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ServerStatus {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindPenalty.class);
        for(Failure failure : result.getFailures()){
            System.out.println(failure.toString());
        }
        if(result.wasSuccessful())
            System.out.println("*** ALL TEST CASES PASSED ***");
        else
            System.out.println("*** ONE OR MORE TEST CASES FAILED ***");

    }

    @Test
    public void testFindStatus(){
        System.out.println("-- Running Find Status testcases --");
        assertEquals(findStatus("1  0", 1), 1);
        assertEquals(findStatus("1 0 1 0", 2), 1);
        assertEquals(findStatus("1 1 1 0", 0), 1);
        assertEquals(findStatus("0 0 0 0", 0), 4);
        assertEquals(findStatus("1 1 1 1", 1), 0);
    }

    @Test
    public void testBestTimeToShutDown(){
        System.out.println("-- Running Best time to shut down testcases --");
        assertEquals(bestTimeToShutDown("1 1 0 0 0 1"), 5);
        assertEquals(bestTimeToShutDown("1 1 1 1 1 1"), 0);
        assertEquals(bestTimeToShutDown("0 0 0 0 0 0"), 5);
        assertEquals(bestTimeToShutDown("1 1 0 0 1 1"), 4);
        assertEquals(bestTimeToShutDown("1 0 1 0 1 0"), 4);
    }

    @Test
    public void testValidLogEntries(){
        System.out.println("-- Running valid log entries testcases --");
        assertEquals(validLogEntries("BEGIN 1 0 1 END"), 1);
        assertEquals(validLogEntries("BEGIN 1 0 1 END BEGIN 1 0 1 END"), 2);
        assertEquals(validLogEntries("BEGIN 1 0 1 END BEGIN 1 0 "), 1);
        assertEquals(validLogEntries("BEGIN \n1 \n0 1 \n\n\nEND BEGIN\n \n\n1 0 1 END"), 2);
        assertEquals(validLogEntries("BEGIN 1 0 0"), 0);
    }

    @Test
    public void testNestedLogEntries(){
        System.out.println("-- Running nested log entries test cases --");
        Map<String, Integer> map1 = Map.of("0 1 1 0", 1);
        assertEquals(findInnerValidLogEntries("BEGIN 0 1 BEGIN 0 1 1 0 END END"), map1);

        Map<String, Integer> map2 = Map.of();
        assertEquals(findInnerValidLogEntries("BEGIN 0 1 BEGIN END END"), map2);

        Map<String, Integer> map3 = Map.of("0 1 1 0", 1, "1 1 1 0",  0);
        assertEquals(findInnerValidLogEntries("BEGIN 0 1 BEGIN 0 1 1 0 END BEGIN 1 1 1 0 END END"), map3);

        Map<String, Integer> map4 = Map.of("0 0 0 0",  3);
        assertEquals(findInnerValidLogEntries("BEGIN 0 1 BEGIN 0 0 0 0 END END"), map4);

        Map<String, Integer> map5 = Map.of("1 1 0 0",  3);
        assertEquals(findInnerValidLogEntries("BEGIN 0 1 BEGIN 0 1 BEGIN 1 1 0 0 END END"), map5);
    }


    private int findStatus(String input, int time){
        String[] arr = input.split("\\s+");
        if( time >= arr.length ){
            return time - (arr.length - 1);
        }
        int result = 0;
        for(int i = arr.length - 1; i >= 0 ; i--){
            if(arr[i].equals("0"))
                result++;
            if(i == time)
                return result;
        }
        return result;
    }

    private int bestTimeToShutDown(String input){
        String[] arr = input.split(" ");
        int size = arr.length;
        int minPenalty = Integer.MAX_VALUE;
        int bestTime = -1;
        for(int i = 0; i < size; i++){
            int penalty = findStatus(input, i);
            if(minPenalty > penalty){
                minPenalty = penalty;
                bestTime = i;
            }
        }
        return bestTime;
    }

    private int validLogEntries(String input){
        String[] arr = input.replace("\n","").split(" ");
        boolean bFound = false, eFound = false;
        int count = 0;
        for(String s : arr){
            if(s.equals("BEGIN"))
                bFound = true;
            if(s.equals("END"))
                eFound = true;
            if(bFound && eFound){
                count++;
                bFound = false;
                eFound = false;
            }
        }
        return count;
    }

    private Map<String, Integer> findInnerValidLogEntries(String input){
        Map<String, Integer> map = new HashMap<>();
        String[] arr = input.substring(input.indexOf(" "), input.lastIndexOf(" ")).split(" ");
        boolean bFound = false;
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            if(s.equalsIgnoreCase("BEGIN")){
                if(!bFound)
                    bFound = true;
                else
                    sb = new StringBuilder();
            }
            if(bFound && !s.equalsIgnoreCase("BEGIN") && !s.equalsIgnoreCase("END")){
                sb.append(s).append(" ");
            }
            if(s.equalsIgnoreCase("END")){
                if(sb.length() > 0)
                    map.put(sb.toString().trim(), bestTimeToShutDown(sb.toString()));
                sb = new StringBuilder();
                bFound = false;
            }
        }
        return map;
    }

}
