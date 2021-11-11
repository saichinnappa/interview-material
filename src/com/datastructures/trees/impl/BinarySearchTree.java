package com.datastructures.trees.impl;

class BinarySearchTree {
    Node root;

    public static void main(String[] args) {
        Node root = new Node(50);
        Node node1 = new Node(30);
        Node node2 = new Node(70);
        Node node3 = new Node(10);
        Node node4 = new Node(40);
        Node node5 = new Node(60);
        Node node6 = new Node(80);
        Node node7 = new Node(5);
        Node node8 = new Node(85);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        /* Iterative insertion
        binarySearchTree.insertNodeIterative(root, node1);
        binarySearchTree.insertNodeIterative(root, node2);
        binarySearchTree.insertNodeIterative(root, node3);
        binarySearchTree.insertNodeIterative(root, node4);
        binarySearchTree.insertNodeIterative(root, node5);
        binarySearchTree.insertNodeIterative(root, node6);
         */
        /*
        50 30 10 40 70 60 80
            Recursive Insertion
         */
        binarySearchTree.insertRecursive(root, node1);
        binarySearchTree.insertRecursive(root, node2);
        binarySearchTree.insertRecursive(root, node3);
        binarySearchTree.insertRecursive(root, node4);
        binarySearchTree.insertRecursive(root, node5);
        binarySearchTree.insertRecursive(root, node6);
        binarySearchTree.insertRecursive(root, node7);
        binarySearchTree.insertRecursive(root, node8);
        binarySearchTree.print(root);

        System.out.println(binarySearchTree.delete(root, node7));
        System.out.println(binarySearchTree.delete(root, node8));
        binarySearchTree.print(root);

    }

    public Node buildTree() {
        Node root = new Node(50);
        Node node1 = new Node(30);
        Node node2 = new Node(70);
        Node node3 = new Node(10);
        Node node4 = new Node(40);
        Node node5 = new Node(60);
        Node node6 = new Node(80);
        Node node7 = new Node(5);
        Node node8 = new Node(85);
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insertRecursive(root, node1);
        binarySearchTree.insertRecursive(root, node2);
        binarySearchTree.insertRecursive(root, node3);
        binarySearchTree.insertRecursive(root, node4);
        binarySearchTree.insertRecursive(root, node5);
        binarySearchTree.insertRecursive(root, node6);
        binarySearchTree.insertRecursive(root, node7);
        binarySearchTree.insertRecursive(root, node8);
        binarySearchTree.print(root);
        return root;
    }

    Node insertNodeIterative(Node root, Node newNode) {
        if (root == null) {
            this.root = newNode;
            return newNode;
        }
        while (root != null) {
            if (newNode.val <= root.val) {
                if (root.left == null) {
                    root.left = newNode;
                    return root;
                }
                root = root.left;
            } else {
                if (root.right == null) {
                    root.right = newNode;
                    return root;
                }
                root = root.right;
            }
        }
        return root;
    }

    Node insertRecursive(Node root, Node newNode) {
        if (root == null)
            return newNode;
        if (newNode.val <= root.val) {
            root.left = insertRecursive(root.left, newNode);
        } else {
            root.right = insertRecursive(root.right, newNode);
        }
        return root;
    }


    boolean searchIterative(Node root, int val) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            } else if (val > root.val) {
                root = root.right;
            } else {
                return true;
            }
        }
        return false;
    }

    boolean searchRecursive(Node root, int val) {
        if (root == null)
            return false;
        if (root.val == val)
            return true;
        else if (val < root.val)
            return searchRecursive(root.left, val);
        else
            return searchRecursive(root.right, val);
    }

    boolean delete(Node root, Node delNode) {
        if (root == null)
            return false;
        //if(root.val == delNode.val)
        Node parentNode = root;
        while (root != null) {
            if (delNode.val < root.val) {
                parentNode = root;
                root = root.left;
            } else if (delNode.val > root.val) {
                parentNode = root;
                root = root.right;
            } else {
                Node leftChild = root.left;
                Node rightChild = root.right;
                if (leftChild == null && rightChild == null) {  // if the node searching is a leaf node, set parent left or right to null
                    if (root.val < parentNode.val)
                        parentNode.left = null;
                    else
                        parentNode.right = null;
                } else if (leftChild == null) {
                    if (root.val > parentNode.val)
                        parentNode.right = root.right;
                    else
                        parentNode.left = root.right;
                } else if (rightChild == null) {
                    if (root.val > parentNode.val)
                        parentNode.right = root.left;
                    else
                        parentNode.left = root.left;
                }
                return true;
            }
        }
        return false;
    }

    void print(Node root) {
        if (root == null)
            return;
        System.out.print(root.val + " ");
        print(root.left);
        print(root.right);
    }
}