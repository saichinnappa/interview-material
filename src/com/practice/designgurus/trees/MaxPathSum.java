package com.practice.designgurus.trees;

public class MaxPathSum {
    static int result = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        MaxPathSum.findMaximumPathSum(root);
        System.out.println("Maximum Path Sum: " + result);

        MaxPathSum.result = Integer.MIN_VALUE;

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        MaxPathSum.findMaximumPathSum(root);
        System.out.println("Maximum Path Sum: " + result);

        MaxPathSum.result = Integer.MIN_VALUE;

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaxPathSum.findMaximumPathSum(root));
    }

    private static int findMaximumPathSum(TreeNode root) {
        if (root == null)
            return 0;
        int left = findMaximumPathSum(root.left);
        int right = findMaximumPathSum(root.right);

        int temp = Math.max(left, right);
        int ans = left + right + root.val;
        result = Math.max(result, ans);
        return temp + root.val;
    }
}
