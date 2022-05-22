package com.interview.doordash.oa;

import java.util.*;

/**
 * API spec:
 * get(path): String -> returns the value of the node at the given path
 * create(path, value) -> creates a new node and sets it to the given value. Should error out if the node already exists or if the node’s parent does not exist. That is /Sweetgreen/naan_roll cannot be created if /Sweetgreen has not already been created
 * delete(path) -> deletes a node, but ONLY if it has no children
 */
public class MenuPath {
    static class TrieNode {
        String key;
        int value = -1;
        Map<String, TrieNode> children = new HashMap<>();

        public TrieNode(String key) {
            this.key = key;
        }

        public TrieNode() {
        }
    }

    static TrieNode root = new TrieNode();


    static class Path {
        String path;
        int value;

        public Path(String path, int value) {
            this.path = path;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Path{" +
                    "path='" + path + '\'' +
                    ", value=" + value +
                    '}';
        }
    }

    public static void main(String[] args) {
        Path[] newPaths = {new Path("/a", 1), new Path("/a/b", 2), new Path("/d/e", 3), new Path("/a/b/c", 4)};
        for(Path p : newPaths){
            System.out.println(p +"-> "+ createPath(p));
        }

        System.out.println("===================BEFORE DELETION===================");

        for(Path p : newPaths){
            System.out.println(p +"-> "+ getPath(p));
        }

        System.out.println("===================");

        deletePath(new Path("/a/b/c", 1));

        System.out.println("===================AFTER DELETION===================");

        for(Path p : newPaths){
            System.out.println(p +"-> "+ getPath(p));
        }

    }

    private static boolean createPath(Path newPath) {
        String[] p = newPath.path.split("/");
        TrieNode curr = root;
        for (int j = 1; j < p.length; j++) {
            if (!curr.children.containsKey(p[j])) {
                if (j == p.length - 1) {
                    TrieNode node = new TrieNode(p[j]);
                    curr.children.put(p[j], node);
                } else {
                    return false;
                }
            }
            curr = curr.children.get(p[j]);
        }
        if (curr.value != -1)
            return false;
        curr.value = newPath.value;
        return true;
    }

    private static int getPath(Path path){

        String[] p = path.path.split("/");
        TrieNode curr = root;
        for(int i = 1; i < p.length; i++){
            if(curr.children.containsKey(p[i])){
                curr = curr.children.get(p[i]);
                if(i == p.length - 1)
                    return curr.value;
            } else
                return -1;
        }
        return -1;
    }


    private static void deletePath(Path path){
        String[] p = path.path.split("/");
        TrieNode curr = root;
        String[] p1 = new String[p.length - 1];
        for(int i = 1; i < p.length; i++){
            p1[i - 1] = p[i];
        }
        deleteNode(p1, 0, root);
    }

    static void deleteNode(String[] p1, int level, TrieNode node){
        if(level == p1.length - 1){
            TrieNode curr = node.children.get(p1[level]);
            if(curr.children.size() == 0){
                node.children.remove(p1[level]);
                System.out.println(" deleted successfully ");
                return;
            } else{
                System.out.println(" children exists, cannot delete node ");
                return;
            }
        }

        if(node.children.containsKey(p1[level])){
            deleteNode(p1, level + 1, node.children.get(p1[level]));
        } else{
            System.out.println("Parent doesn't exist");
        }

    }


}
