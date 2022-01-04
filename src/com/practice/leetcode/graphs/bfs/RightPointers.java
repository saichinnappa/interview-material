package com.practice.leetcode.graphs.bfs;

public class RightPointers {
    static Node result;

    public static void main(String[] args) {


//        int[] root = {1, 2, 3, 4, 5, 6, 7};
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        Node leftOf2 = new Node(4);
        Node rightOf2 = new Node(5);
        Node leftOf3 = new Node(6);
        Node rightOf3 = new Node(7);
        root.left = left;
        root.right = right;
        left.left = leftOf2;
        left.right = rightOf2;
        right.left = leftOf3;
        right.right = rightOf3;

        connect(root);
    }

    public static Node connect(Node root) {


        if (root == null) return root;

        result = new Node(root.val);
        recursive(result, root);
        return result;

    }


    public static void recursive(Node result, Node root) {

        System.out.println(root.val + "<<<<<");
        if (root.left == null)
            return;
        Node left = new Node(root.left.val);
        Node right = new Node(root.right.val);

        result.left = left;
        result.right = right;

        result.left.right = result.right;
        recursive(result.left, root.left);
        recursive(result.right, root.right);

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
