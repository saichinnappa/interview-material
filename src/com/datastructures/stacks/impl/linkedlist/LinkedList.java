package com.datastructures.stacks.impl.linkedlist;

public class LinkedList {

   public Node head;

//    public static void main(String[] args) {
//        LinkedList linkedList = new LinkedList();
//        Node node1 = new Node(0);
//        Node node2 = new Node(1);
//        Node node3 = new Node(2);
//        linkedList.insert(linkedList, node1);
//        linkedList.insert(linkedList, node2);
//        linkedList.insert(linkedList, node3);
//        linkedList.print(linkedList);
//        linkedList.delete(linkedList, node3);
//        linkedList.delete(linkedList, node2);
//        linkedList.print(linkedList);
//    }

   public LinkedList insert(LinkedList linkedList, Node newNode){
        if(head == null){
            linkedList.head = newNode;
        } else{
            Node lastNode = linkedList.head;
            while(lastNode.next != null){
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        return linkedList;
    }

    public LinkedList delete(LinkedList linkedList, Node delNode){
        Node headNode = linkedList.head;
        if(linkedList.head.data == delNode.data){
            linkedList.head = delNode.next;
        } else{
            Node prevNode = headNode;
            Node currentNode = headNode.next;
            while(currentNode != null){
                if(currentNode.data == delNode.data){
                    prevNode.next = delNode.next;
                } else{
                    prevNode = currentNode;
                }
                currentNode = currentNode.next;
            }
        }
        return linkedList;
    }

    public LinkedList pop(LinkedList linkedList){
       linkedList.head = linkedList.head.next;
       return linkedList;
    }

    public void print(LinkedList linkedList){
        if(linkedList.head != null){
            Node node = linkedList.head;
            while(node != null){
                System.out.print(node.data +"->");
                node = node.next;
            }
            System.out.print("null");
        }
        System.out.println("\n");
    }
}
