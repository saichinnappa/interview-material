package com.interview.doordash;

//https://leetcode.com/discuss/interview-question/1367130/Doordash-Phone-Interview

import java.util.*;

public class MenuItems {

    public static void main(String[] args) {

        //TREE ONE
//        Node nodeD = new Node("d", 4, true, null);
//        Node nodeE = new Node("e", 5, true, null);
//        Node nodeB = new Node("b", 2, true, Arrays.asList(nodeD, nodeE));
//        Node nodeF = new Node("f", 6, true, null);
//        Node nodeC = new Node("c", 3, true, Arrays.asList(nodeF));
//        Node root1 = new Node("a", 1, true, Arrays.asList(nodeB, nodeC));
//
//        //TREE TWO
//        Node nodeF1 = new Node("f", 66, true, null);
//        Node nodeC1 = new Node("c", 3, false, Arrays.asList(nodeF1));
//        Node root2 = new Node("a", 1, true, Arrays.asList(nodeC1));

        //TREE THREE
        Node nodeE = new Node("e", 1, true, null);
        Node nodeB = new Node("b", 2, true, Arrays.asList(nodeE));
        Node nodeC = new Node("c", 3, true, null);
        Node root1 = new Node("a", 4, true, Arrays.asList(nodeB, nodeC));

        //TREE FOUR
        Node nodeE1 = new Node("e", 1, true, null);
        Node nodeB1 = new Node("b", 2, true, Arrays.asList(nodeE1));
        Node nodeD1 = new Node("d", 5, true, Arrays.asList(nodeB1));
        Node nodeC1 = new Node("c", 3, true, null);
        Node root2 = new Node("a", 4, true, Arrays.asList(nodeD1, nodeC1));

        System.out.println("Total Differences: "+ calculateDifferences(root1, root2));
    }



    private static int calculateDifferences(Node root1, Node root2) {

        int result = 0;

        if(root1 == null && root2 == null)
            return result;

        if(root1 == null || root2 == null || !compareMenuItems(root1, root2)){

            result++;
        }

        Map<String, Node> map1 = getChildren(root1);
        Map<String, Node> map2 = getChildren(root2);

        for(Map.Entry<String, Node> entry : map1.entrySet()){
            result += calculateDifferences(entry.getValue(), map2.getOrDefault(entry.getKey(), null));
        }

        for(Map.Entry<String, Node> entry : map2.entrySet()){
            if(!map1.containsKey(entry.getKey())){
                result += calculateDifferences(null, entry.getValue());
            }
        }

        return result;
    }

    private static Map<String, Node> getChildren(Node root) {
        Map<String, Node> map = new HashMap<>();
        if(root == null || root.children == null)
            return map;
        for(Node n : root.children){
            map.put(n.key, n);
        }
        return map;
    }

    private static boolean compareMenuItems(Node root1, Node root2) {
        return (root1.key.equals(root2.key) && root1.value == root2.value && root1.active == root2.active);
    }


}

class Node {
    String key;
    int value;
    boolean active;
    List<Node> children;

    public Node(String key, int value, boolean active, List<Node> children) {
        this.key = key;
        this.value = value;
        this.active = active;
        this.children = children;
    }
}

