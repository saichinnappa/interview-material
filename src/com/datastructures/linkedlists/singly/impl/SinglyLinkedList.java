package com.datastructures.linkedlists.singly.impl;

public class SinglyLinkedList {

    public Node head;

    public SinglyLinkedList(Node head) {
        this.head = head;
    }

    public void insert(Node newNode) {
        Node currentNode = head;
        if (head == null)
            head = newNode;
        else {
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    void insertAfter(Node previousNode, Node newNode) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.data == previousNode.data) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                break;
            } else {
                currentNode = currentNode.next;
            }
        }
    }

    void delete(Node delNode) {
        Node prevNode = head;
        Node nextNode = head.next;
        if (head.data == delNode.data) {
            head = nextNode;
        } else {
            while (nextNode != null) {
                if (nextNode.data == delNode.data) {
                    prevNode.next = delNode.next;
                    break;
                } else {
                    prevNode = nextNode;
                    nextNode = nextNode.next;
                }
            }
        }
    }

    boolean search(Node searchNode) {
        Node currentNode = head;
        if (head.data == searchNode.data)
            return true;
        else {
            while (currentNode != null) {
                if (currentNode.data == searchNode.data) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    int length() {
        Node currentNode = head;
        if (head == null)
            return -1;
        int count = 0;
        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    void reverse() {
        Node current = head; //start traversing from head
        Node next = null; // next node set to null
        Node previous = null; // previous node set to null
        while (current != null) { // traverse the list until the current node is null i.e. end of list
            next = current.next; // store the next value of current
            current.next = previous; // reverse the link here - next value of current must be previous
            previous = current; // previous moves to current
            current = next; // current moves to next
        }
        this.head = previous; // at the end head of the list will be previous
        print();
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
}
