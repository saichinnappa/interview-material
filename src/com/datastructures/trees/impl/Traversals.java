package com.datastructures.trees.impl;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Traversals {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = binarySearchTree.buildTree();
        dfs(root);
        bfs(root);
        System.out.print("PRE ORDER -> ");
        preOrder(root);
        System.out.print("\nIN ORDER -> ");
        inOrder(root);
        System.out.print("\nPOST ORDER -> ");
        postOrder(root);
    }

    private static void dfs(Node node) {
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            stringBuilder.append(top.val + " ");
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        System.out.println("\nDFS -> " + stringBuilder.toString());
    }

    private static void bfs(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        StringBuilder stringBuilder = new StringBuilder();
        long count = 0;
        while (!queue.isEmpty()) {
            Node first = queue.poll();
            stringBuilder.append(first.val + " ");
            if (first.left != null)
                queue.add(first.left);
            if (first.right != null)
                queue.add(first.right);
        }
        System.out.println("BFS -> " + stringBuilder.toString());
    }

    /**
     * PRE ORDER: ROOT -> LEFT -> RIGHT
     *
     * @param root
     */
    static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * IN ORDER: LEFT -> ROOT -> RIGHT
     *
     * @param root
     */
    static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    /**
     * POST ORDER: LEFT -> RIGHT -> ROOT
     *
     * @param root
     */
    static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
