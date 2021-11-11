package com.datastructures.tries;

public class TrieNode {

    boolean isEndOfWord;
    TrieNode[] children;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }

//    //Function to mark the currentNode as Leaf
//    public void markAsLeaf() {
//        this.isEndOfWord = true;
//    }
//
//    //Function to unMark the currentNode as Leaf
//    public void unMarkAsLeaf() {
//        this.isEndOfWord = false;
//    }
}
