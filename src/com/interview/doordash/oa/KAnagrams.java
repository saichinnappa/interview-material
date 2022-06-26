package com.interview.doordash.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a restaurant name, find other restaurants in the list that are k-anagrams with each other. A name is a k-anagram with another name if both the conditions below are true:
 * The names contain the same number of characters.
 * The names can be turned into anagrams by changing at most k characters in the string
 * For example:
 * name = "grammar", k = 3, and list = ["anagram"], "grammar" is k-anagram with "anagram" since they contain the same number of characters and you can change 'r' to 'n' and 'm' to 'a'.
 * name = "omega grill", k = 2 and list = ["jmegra frill"], "omega grill" is k-anagram with "jmega frill" since they contain same number of characters and you can change 'o' to 'j' and 'g' to 'f'
 * public List findKAnagrams(String name, String[] list, int K) {}
 */
public class KAnagrams {
    public static void main(String[] args) {
        String input = "omexyb grillg";
        String[] list = {"omgxcag rilld"};
        int k = 2;
        List<String> result = printfindKAnagrams(input, list, k);
        System.out.println(result);
    }

    private static List<String> printfindKAnagrams(String input, String[] list, int k) {
        List<String> result = new ArrayList<>();
        for(String s : list){
            int[] charCount = new int[128];
            for(int i = 0; i< input.length(); i++){
                if(s.length() == input.length()){
                    if(s.charAt(i) - 'a' < 0 || input.charAt(i) - 'a' < 0 ){
                        charCount[s.charAt(i)]++;
                        charCount[input.charAt(i)]--;
                    }else{
                        charCount[s.charAt(i) - 'a']++;
                        charCount[input.charAt(i) - 'a']--;
                    }
                }
            }
            int maxValue = 0;
            for(int c : charCount){
                if(c < 0){
                    maxValue += Math.abs(c);
                }
            }
            if(maxValue <= k)
                result.add(s);
        }
    return result;
    }


}
