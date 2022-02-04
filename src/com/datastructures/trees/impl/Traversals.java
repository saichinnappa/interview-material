package com.datastructures.trees.impl;

import java.util.*;

public class Traversals {
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = binarySearchTree.buildTree();
        dfsIterative(root);
        dfsRecursive(root);
        System.out.println("DFS RECURSIVE: " + result);
        bfs(root);
        System.out.print("PREORDER -> ");
        preOrder(root);
        System.out.print("\nINORDER -> ");
        inOrder(root);
        System.out.print("\nPOSTORDER -> ");
        postOrder(root);
    }

    private static void postOrder(Node root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    private static void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static void preOrder(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }


    private static void bfs(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        if (root == null)
            return;
        else
            queue.offer(root);
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node first = queue.poll();
            result.add(first.val);
            if (first.left != null)
                queue.offer(first.left);
            if (first.right != null)
                queue.offer(first.right);
        }
        System.out.println("BFS ITERATIVE: " + result);
    }

    private static void dfsRecursive(Node root) {
        if (root == null)
            return;
        result.add(root.val);
        dfsRecursive(root.left);
        dfsRecursive(root.right);

    }

    // 50 30 10 5 40 70 60 80 85
    //[50, 30, 10, 5, 40, 70, 60, 80, 85]
    private static void dfsIterative(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            System.out.println("Tree is empty!");
            return;
        } else {
            stack.push(root);
        }
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node top = stack.pop();
            result.add(top.val);
            if (top.right != null)
                stack.push(top.right);
            if (top.left != null)
                stack.push(top.left);
        }
        System.out.println("DFS ITERATIVE: " + result);
    }


}
