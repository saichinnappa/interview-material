package com.practice.leetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    int sum = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Node root = new Node();
//        root.val = 1;
//        Node node1 = new Node();
//        node1.val = 3;
//        Node node2 = new Node();
//        node2.val = 2;
//        Node node3 = new Node();
//        node3.val = 4;
//        Node node4 = new Node();
//
//        List<Node> childrenOfRoot = new ArrayList<>();
//        childrenOfRoot.add(node3);
//        childrenOfRoot.add(node2);
//        childrenOfRoot.add(node4);
//        root.children = childrenOfRoot;
//        List<Node> childrenOfThree = new ArrayList<>();
//        Node node5 = new Node();
//        node5.val = 5;
//        Node node6 = new Node();
//        node6.val = 6;
//        childrenOfThree.add(node5);
//        childrenOfThree.add(node6);
//        node3.children = childrenOfThree;
//        System.out.println(Arrays.toString(solution.postorder(root).toArray()));

        TreeNode root = new TreeNode();
        root.val = 1;
        TreeNode node1 = new TreeNode();
        node1.val = 0;
        TreeNode node2 = new TreeNode();
        node2.val = 2;
//        TreeNode node3 = new TreeNode();
//        node3.val = 0;
//        TreeNode node4 = new TreeNode();
//        node4.val = 1;
//        TreeNode node5 = new TreeNode();
//        node5.val = 0;
//        TreeNode node6 = new TreeNode();
//        node6.val = 1;
        root.left = node1;
        root.right = node2;
//        node1.left = node3;
//        node1.right = node4;
//        node2.left = node5;
//        node2.right = node6;
//        System.out.println(solution.sumRootToLeaf(root));
//        TreeNode root = solution.sortedArrayToBST(new int[]{0, 1, 2, 3, 4, 5});

        solution.print(root);
    }


    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v : vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    public List<Integer> postorder(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            output.add(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null && left.val == val) {
            return left;
        } else if (right != null && right.val == val) {
            return right;
        }
        if (val <= root.val && left != null) {
            return searchBST(left, val);
        }
        if (val > root.val && right != null) {
            return searchBST(right, val);
        }
        return null;
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int left = maxDepth(root.left);
            int right = maxDepth(root.right);
            return Math.max(left, right) + 1;
        }
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root.left == null && root.right == null)
            return true;
        return helper(root, root.val);
    }

    boolean helper(TreeNode root, int val) {
        if (root == null)
            return true;
        if (root.val != val)
            return false;
        return helper(root.left, val) && helper(root.right, val);
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            if (root.val == 1)
                return 1;
            else
                return 0;
        }
        helperSumRootToLeaf(root, "");
        return sum;
    }

    private void helperSumRootToLeaf(TreeNode root, String s) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum += Integer.parseInt(s + root.val, 2);
        }
        helperSumRootToLeaf(root.right, s + root.val);
        helperSumRootToLeaf(root.left, s + root.val);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int mid = (nums.length - 1) / 2;
        TreeNode root = new TreeNode();
        root.val = nums[mid];
        return newMethod(root, nums, 0, nums.length - 1);
    }

    public TreeNode newMethod(TreeNode root, int[] nums, int start, int end) {
        if (start == end)
            return root;
        int mid = start + end / 2;
//        for (int i = 0; i < mid; i++) {
        TreeNode newNode = new TreeNode(nums[mid]);
        insertNode(root, newNode);
//        }
        newMethod(root, nums, 0, mid - 1);
        newMethod(root, nums, mid + 1, nums.length - 1);
        return root;
    }

    private TreeNode insertNode(TreeNode root, TreeNode newNode) {
        if (root == null) return newNode;
        if (newNode.val <= root.val) {
            root.left = insertNode(root.left, newNode);
        } else {
            root.right = insertNode(root.right, newNode);
        }
        return root;
    }


    private void print(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
