package com.practice.ctci.linkedlists;

public class SinglyLinkedList<T> {
    Node head = null;
    int size = 0;
    Node tail = null;

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.insertAtHead(1);
        singlyLinkedList.insertAtHead(2);
        singlyLinkedList.insertAtHead(3);
        singlyLinkedList.insertAtTail(4);
        singlyLinkedList.print();
        System.out.println("\nisEmpty: " + singlyLinkedList.isEmpty());

        singlyLinkedList.reverse();
        singlyLinkedList.print();
        System.out.println("\nCycle exists: " + singlyLinkedList.detectCycle());

    }

    public boolean detectCycle() {
//        this.tail.nextNode = this.head;
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.nextNode != null) {
            slow = head.nextNode;
            fast = fast.nextNode.nextNode;
            if (slow == fast)
                return true;
        }

        return false;
    }

    public void print() {
        Node head = this.head;
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.nextNode;
        }
    }

    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = head;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        this.head = prev;
    }

    public void insertAtHead(T data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.nextNode = this.head;
            this.head = newNode;
        }
        this.size++;
    }

    public void insertAtTail(T data) {
        Node newNode = new Node(data, null);
        if (this.tail == null) {
            this.head = newNode;
        } else {
            this.tail.nextNode = newNode;
        }
        this.tail = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    class Node<T> {
        T data;
        Node nextNode;

        Node(T data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }
    }

}
