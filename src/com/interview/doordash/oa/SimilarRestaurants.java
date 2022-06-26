package com.interview.doordash.oa;

import java.util.ArrayList;
import java.util.List;

/**
 * Two restaurants R1 and R2 are similar if we can swap a maximum of two letters (in different positions) of R1, so that it equals R2.
 * For example, source one may have a restaurant named "omega grill" while another source may have the same restaurant as "omgea grill".
 * For example, "biryani" and "briyani" are similar (swapping at positions 1 and 2). "biryani" is not similar to following, "biryeni" (no e to swap with), "briynai"(Needs 2 swap)
 * For a given restaurant name, find and return all the similar restaurant names in the list.
 * Implement the function below:
 * public List findSimilarRestaurants(String name, String[] list) {}
 */
public class SimilarRestaurants {
    public static void main(String[] args) {
        SimilarRestaurants similarRestaurants = new SimilarRestaurants();
        String input = "omega grill";
        String[] list = {"omeag grill", "omeea grill", "omega gril", "omegla gril"};
        List<String> result = findSimilarRestaurants(input, list);
        System.out.println(result);
    }

    public static List<String> findSimilarRestaurants(String name, String[] list) {
        List<String> result = new ArrayList<>();
        for(String s : list){
            if(s.length() == name.length() && !s.equals(name)){
                char[] inputArray = name.toCharArray();
                List<Integer> diff = new ArrayList<>();
                for(int i = 0; i < inputArray.length; i++){
                    if(s.charAt(i) != inputArray[i]){
//                        if(diff.size() < 2)
                            diff.add(i);
//                        else
//                            break;
                    }
                }

                if(diff.size() == 2 && s.charAt(diff.get(0)) == inputArray[diff.get(1)] && s.charAt(diff.get(1)) == inputArray[diff.get(0)]){
                    result.add(s);
                }

            } else if(s.equals(name))
                result.add(s);
        }
        return result;
    }
}
