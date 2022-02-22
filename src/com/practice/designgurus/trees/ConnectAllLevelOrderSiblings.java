package com.practice.designgurus.trees;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllLevelOrderSiblings {
    public static void main(String[] args) {
        TreeNodeWithNext root = new TreeNodeWithNext(12);
        root.left = new TreeNodeWithNext(7);
        root.right = new TreeNodeWithNext(1);
        root.left.left = new TreeNodeWithNext(9);
        root.right.left = new TreeNodeWithNext(10);
        root.right.right = new TreeNodeWithNext(5);
        ConnectAllLevelOrderSiblings.connect(root);
        root.printTree();
    }

    private static void connect(TreeNodeWithNext root) {

        if (root == null || (root.left == null && root.right == null))
            return;

        Queue<TreeNodeWithNext> queue = new LinkedList();
        queue.offer(root);
        TreeNodeWithNext prev = root;
        while (!queue.isEmpty()) {
            TreeNodeWithNext first = queue.poll();
            if (first.left != null)
                queue.offer(first.left);
            if (first.right != null)
                queue.offer(first.right);
            prev.next = first;
            prev = first;

        }

    }
}


class TreeNodeWithNext {
    int val;
    TreeNodeWithNext left;
    TreeNodeWithNext right;
    TreeNodeWithNext next;

    TreeNodeWithNext(int x) {
        val = x;
        left = right = next = null;
    }

    // tree traversal using 'next' pointer
    public void printTree() {
        TreeNodeWithNext current = this;
        System.out.print("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
};