package com.concepts.recursion;


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Solution {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        Solution solution = new Solution();
        solution.reverseList(listNode1);
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        ListNode currentNode = reverseList(next);
        next.next = currentNode;
        next = null;
        return currentNode;
    }

    public void reverseListIterative(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

    }

//    void reverse() {
//        Node current = head; //start traversing from head
//        Node next = null; // next node set to null
//        Node previous = null; // previous node set to null
//        while (current != null) { // traverse the list until the current node is null i.e. end of list
//            next = current.next; // store the next value of current
//            current.next = previous; // reverse the link here - next value of current must be previous
//            previous = current; // previous moves to current
//            current = next; // current moves to next
//        }
//        this.head = previous; // at the end head of the list will be previous
//        print();
//    }
}