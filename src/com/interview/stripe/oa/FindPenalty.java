package com.interview.stripe.oa;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

/**
 *  1. Case sensitive
 *  2. Delimiter always space
 *  3. Can shop be closed beyond working hours
 *  4. Can input string be empty?
 *
 */

public class FindPenalty {

    int bestTime = -1;

    public static void main(String[] args) {
//        String x = "BEGIN \n Y N\n Y N END \nBEGIN Y\n\n N N END";
//        String a = "BEGIN Y N Y N END BEGIN Y N N END";
//        //x.replaceAll("\\r|\\n", "");
//        String y = x.replace("\n", "").replace("\r", "");
//        System.out.println(y);

        Result result = JUnitCore.runClasses(FindPenalty.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }

    @Test
    public void findPenaltyTest() {
        System.out.println("-- Running find penalty testcases --");
        FindPenalty fP1 = new FindPenalty();
        assertEquals(fP1.findPenaltyForShop("Y Y Y N", 3), 0);
        assertEquals(fP1.findPenaltyForShop("Y Y Y N", 2), 1);
        assertEquals(fP1.findPenaltyForShop("Y Y Y N", 1), 2);
        assertEquals(fP1.findPenaltyForShop("Y Y Y N", 0), 3);
        assertEquals(fP1.findPenaltyForShop("Y Y Y N", 5), 2);
    }

    @Test
    public void bestTimeTest(){
        System.out.println("-- Running best time to close shop testcases --");
        FindPenalty findPenalty = new FindPenalty();
        assertEquals(findPenalty.bestTimeToClose("Y Y Y N"), 3);
        assertEquals(findPenalty.bestTimeToClose("Y Y N Y"), 2);
        assertEquals(findPenalty.bestTimeToClose("Y N N Y"), 1);
        assertEquals(findPenalty.bestTimeToClose("Y N N N"), 1);
        assertEquals(findPenalty.bestTimeToClose("N N N N"), 0);
        assertEquals(findPenalty.bestTimeToClose("Y Y Y Y"), 3);
    }

    @Test
    public void validLogEntries(){
        System.out.println("-- Running valid log entries testcases --");
        FindPenalty findPenalty = new FindPenalty();
        assertEquals(findPenalty.findValidLogEntries("BEGIN Y N Y N END"), 1);
        assertEquals(findPenalty.findValidLogEntries("BEGIN Y N Y N"), 0);
        assertEquals(findPenalty.findValidLogEntries("BEGIN Y N Y N END BEGIN Y N Y N END BEGIN"), 2);
        assertEquals(findPenalty.findValidLogEntries("BEGIN Y N Y N END BEGIN Y N Y N END END"), 2);
        assertEquals(findPenalty.findValidLogEntries("BEGIN Y N Y N END END Y N Y N END END"), 1);
        assertEquals(findPenalty.findValidLogEntries("BEGIN Y N Y N BEGIN"), 0);
        assertEquals(findPenalty.findValidLogEntries("BEGIN \n Y N\n Y N END \nBEGIN Y\n\n N N END"), 2);
        assertEquals(findPenalty.findValidLogEntries("BEGIN \n Y N\n"), 0);
        assertEquals(findPenalty.findValidLogEntries(""), 0);
    }

    @Test
    public void nestedStatusTest(){
        System.out.println("-- Running nested status testcases --");
        FindPenalty findPenalty = new FindPenalty();
        Map<String, Integer> map = Map.of("Y Y N", 2);
        Map<String, Integer> result = findPenalty.nestedStatus("BEGIN BEGIN Y Y N END BEGIN Y N END");
        assertEquals(map, result);

        Map<String, Integer> map1 = Map.of("Y Y N", 2, "Y N", 1);
        Map<String, Integer> result1 = findPenalty.nestedStatus("BEGIN BEGIN Y Y N END BEGIN Y N END END");
        assertEquals(map1, result1);


        Map<String, Integer> map2 = Map.of();
        Map<String, Integer> result2 = findPenalty.nestedStatus("BEGIN Y Y N END BEGIN Y N END");
        assertEquals(map2, result2);


        Map<String, Integer> map3 = Map.of("Y Y N", 2, "N Y N", 2);
        Map<String, Integer> result3 = findPenalty.nestedStatus("BEGIN BEGIN Y Y N END BEGIN END BEGIN N Y N END END");
        assertEquals(map3, result3);
    }

    public int findPenaltyForShop(String input, int closingTime) {
        String[] inputList = input.split(" ");

        //Assuming the shop is closed and customer will show up
        if (closingTime >= inputList.length)
            return closingTime - (inputList.length-1);

        int result = 0;
        for (int i = inputList.length - 1; i >= 0; i--) {
            if (inputList[i].equalsIgnoreCase("Y"))
                result++;

            if (i == closingTime) {
                return result;
            }
        }
        return result;
    }

    // Can we assume status / shop close after the input hours?
    public int bestTimeToClose(String input){
        int size = input.split(" ").length;
        int penalty = Integer.MAX_VALUE;

        for(int i = 0; i < size; i++){
            int temp = findPenaltyForShop(input, i);
            if(temp < penalty){
                penalty = temp;
                bestTime = i;
            }
        }
        return bestTime;
    }

    public int findValidLogEntries(String input){
        if(input.length() == 0)
            return 0;
        String newInput = input.replace("\n", "");
        String[] inputArr = newInput.split(" ");
        int bIdx = 0;
        int eIdx = 0;
        int count = 0;
        for(String s : inputArr){
            if(s.equals("BEGIN")){
                bIdx++;
            }
            else if(s.equals("END")){
                eIdx++;
            }
            if(bIdx == eIdx){
                count++;
                bIdx = 0;
                eIdx = 0;
            }
        }
        return count;
    }

//    public int isValidInput(String str){
//        if(str == null || str.length() < 1)
//            return 0;
//
//        String[] strInput = str.split("\\s");
//
//        String prev = "";
//        int idx = 0;
//        int result = 0;
//        for(int i = 0; i < strInput.length; i++){
//            String in = strInput[i].replaceAll("[\n\r]$", "");
//
//            if(in.equalsIgnoreCase("BEGIN")){
//                prev = in;
//                idx = i;
//            }
//            if(in.equalsIgnoreCase("END")){
//                if(prev.length() > 0 && (i - idx) > 1){
//                    result++;
//                }
//                prev = "";
//                idx = i;
//            }
//        }
//
//        return result;
//    }

    //what if input doesnt start with BEGIN or end with END
    //only inner most or all valid inner most substrings
    public Map<String, Integer> nestedStatus(String input){
        Map<String, Integer> map = new HashMap<>();
        String newInput = input.substring(input.indexOf(" "), input.lastIndexOf(" "));
        String[] arr =  newInput.split(" ");
        StringBuilder sb = new StringBuilder();
        boolean bFound = false;
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
//                System.out.println(sb);
                if(sb.length() > 0)
                    map.put(sb.toString().trim(), bestTimeToClose(sb.toString().trim()));
                bFound = false;
                sb = new StringBuilder();
            }
        }
        return map;
    }


}
