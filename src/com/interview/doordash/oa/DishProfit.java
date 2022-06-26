package com.interview.doordash.oa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * I own a restaurant and hire various chefs for specific expertise and need to find the maximum profit from the orders.
 * i.e.
 * input :
 * chef expertise :  [1,1,2,2,1,3,4,4] : ith chef can make specific num dish
 * chef profit level: [4,5,1,3,9,2,3,4] : ith chef can make specific profit by cooking that dish
 * Dish orders: [1,4,1,4,2,3] : I have list of orders and need to maximize the profit.
 *
 * for the above example, I have 8 chefs, who can make specific dishes and make a specific profit.
 * for example,
 * 0th chef can make dish 1 with a profit $4
 * 1st chef can make dish 1 with a profit $5
 * ....
 *
 * I can assign any number of dishes to any chef and want to maximize the profit, how can I assign and what will be the final maximum profit:
 * for the above example,
 * Dish Orders :   [1,4,1,4,2,3] : Profit I can make with  best chef expertise for specific dish : [9, 4, 9, 4, 3, 2] = 27
 */
public class DishProfit {
    public static void main(String args[]) {

        int[] chefDish = {1, 1, 2, 2, 1, 3, 4, 4};
        int[] chefProfit = {4, 5, 1, 3, 9, 2, 3, 4};
        int[] orders = {1, 4, 1, 4, 2, 3};

        DishProfit mp = new DishProfit();

        System.out.println("Max profit->" + mp.findMaxProfit(chefDish, chefProfit, orders));
    }

    public int findMaxProfit(int[] chefDish, int[] chefProfit, int[] orders) {
        //Find max profit for a dish and store it in a map
        HashMap<Integer, Integer> dishProfit = new HashMap<Integer, Integer>();
        //Find which chef makes the max profit for a dish and store it in a map
        //HashMap<Integer,Integer> topChefForDish = new HashMap<Integer,Integer>();

        for (int i = 0; i < chefDish.length; i++) {
            if (dishProfit.containsKey(chefDish[i])) {
                if (dishProfit.get(chefDish[i]) < chefProfit[i]) {
                    dishProfit.put(chefDish[i], chefProfit[i]);
                    //topChefForDish.put(chefDish[i], i);
                }
            } else {
                dishProfit.put(chefDish[i], chefProfit[i]);
                //topChefForDish.put(chefDish[i], i);
            }
        }

        //System.out.println(Arrays.asList(dishProfit));
        //System.out.println(Arrays.asList(topChefForDish));

        int maxProfit = 0;
        for (int i = 0; i < orders.length; i++) {
            maxProfit += dishProfit.get(orders[i]);
            //System.out.print(topChefForDish.get(orders[i])+",");
        }

        return maxProfit;
    }
}
