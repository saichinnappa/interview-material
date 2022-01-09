package com.interview.amazon.oa;

/**
 * A question about Amazon student badges but ultimately the problem was given an arr of -1 or 1, return the maximum subarray length with a product of 1.
 * The array is of size 2 and above and only contains -1 and 1
 * e.g arr = [-1,-1,1,1,-1], return 4, since index 0 to 3 have the max length with product equal to 1
 * <p>
 * I tried to use a sliding window but only passed 4/13 cases. there was somthing i had to fix in the logic for the case arr = [ -1,-1,-1,-1,-1, 1]
 * <p>
 * https://leetcode.com/discuss/interview-question/1655441/Amazon-or-OA
 * https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/discuss/819278/Java-O(n)-time-O(1)-space
 */
public class MaxSubArrayProductOne {
    public static void main(String[] args) {
        int[] a = {-1, 1, 1};
        int c = 0;
        int fnegindex = -1;//for the first negative index
        int lnegindex = -1;//for the last negative index
        for (int i = 0; i < a.length; i++) {
            if (a[i] == -1) {
                if (fnegindex == -1) {
                    fnegindex = i;
                }
                lnegindex = i;
                c++;
            }
        }
        int result = 0;
        if (c % 2 == 0) {
            System.out.println(a.length);
        } else {
            result = Math.max(a.length - fnegindex - 1, lnegindex);
            System.out.println(result);
        }
    }
}
