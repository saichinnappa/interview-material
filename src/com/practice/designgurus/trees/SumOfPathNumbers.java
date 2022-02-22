package com.practice.designgurus.trees;

import java.util.ArrayList;
import java.util.List;

public class SumOfPathNumbers {


    private static void findSum(TreeNode root, List<String> result, String s) {
        if (root == null)
            return;
        s += root.val;
        if (root.left == null && root.right == null) {
            result.add(s);
        } else {
            findSum(root.left, result, s);
            findSum(root.right, result, s);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(9);
        List<String> result = new ArrayList();
        findSum(root, result, "");
        int sum = 0;
        for (String i : result) {
            sum += Integer.parseInt(i);
        }
        System.out.println("Path sum is: " + sum);
    }
}


