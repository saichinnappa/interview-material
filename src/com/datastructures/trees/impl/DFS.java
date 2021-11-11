//package com.datastructures.trees.impl;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Stack;
//
//public class DFS {
//    public static void main(String[] args) {
//        DFS dfs = new DFS();
//        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        Node root = new Node(6);
//        Node node1 = new Node(4);
//        Node node2 = new Node(3);
//        Node node3 = new Node(5);
//        root.leftChild = node1;
//        node1.leftChild = node2;
//        node2.rightChild = node3;
//        Node node4 = new Node(7);
//        Node node5 = new Node(1);
//        Node node6 = new Node(8);
//        root.rightChild = node4;
//        node4.leftChild = node5;
//        node4.rightChild = node6;
//        binarySearchTree.print(root);
//        dfs.preOrderTraversalUsingDFS(root);
///**
// * 6
// * 4
// * 3
// * 5
// * 7
// * 1
// * 8
// */
//    }
//
//    void preOrderTraversalUsingDFS(Node root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<Node> stack = new Stack<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            Node topNode = stack.pop();
//            result.add(topNode.value);
//            if (topNode.rightChild != null)
//                stack.push(topNode.rightChild);
//            if (topNode.leftChild != null)
//                stack.push(topNode.leftChild);
//        }
//        System.out.println(Arrays.toString(result.toArray()));
//    }
//
//    void inOrderTraversalUsingDFS(Node root) {
//        List<Integer> result = new ArrayList<>();
//        Stack<Node> stack = new Stack<>();
//        stack.push(root.leftChild);
//        while (!stack.isEmpty()) {
//            Node topNode = stack.pop();
//            result.add(topNode.value);
//            if (topNode.rightChild != null) {
//                stack.push(topNode.rightChild);
//            }
//            if (root != null)
//                stack.push(root);
//        }
//    }
//
//
//}
