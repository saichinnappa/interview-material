package com.datastructures.tries;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    //    int sum = 0;


    int getIndex(char c) {
        return c - 'a';
    }

    void insert(String key) {
        if (key == null) {
            System.out.println("Empty key cannot be inserted!");
            return;
        }
        String keyInLowerCase = key.toLowerCase();
        TrieNode currentNode = this.root;
        if (currentNode != null) {
            for (char c : keyInLowerCase.toCharArray()) {
                if (currentNode.children[getIndex(c)] == null) {
                    currentNode.children[getIndex(c)] = new TrieNode();
                }
                currentNode = currentNode.children[getIndex(c)];
            }
            currentNode.isEndOfWord = true;
        }

    }

    boolean search(String word) {
        if (word == null) {
            System.out.println("Search Key cannot be null!");
            return false;
        }
        TrieNode currentNode = this.root;
        String keyInLowerCase = word.toLowerCase();
        for (int i = 0; i < keyInLowerCase.toCharArray().length; i++) {
            if (currentNode.children[getIndex(keyInLowerCase.charAt(i))] != null) {
                currentNode = currentNode.children[getIndex(keyInLowerCase.charAt(i))];
            } else {
                return false;
            }
        }
        return currentNode.isEndOfWord;
    }

    private boolean hasNoChildren(TrieNode currentNode) {
        for (int i = 0; i < currentNode.children.length; i++) {
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }

    //Recursive function to delete given key
    private boolean deleteHelper(String key, TrieNode currentNode, int length, int level) {
        boolean deletedSelf = false;

        if (currentNode == null) {
            System.out.println("Key does not exist");
            return deletedSelf;
        }

        //Base Case: If we have reached at the node which points to the alphabet at the end of the key.
        if (level == length) {
            //If there are no nodes ahead of this node in this path
            //Then we can delete this node
            if (hasNoChildren(currentNode)) {
                currentNode = null;
                deletedSelf = true;
            }
            //If there are nodes ahead of currentNode in this path
            //Then we cannot delete currentNode. We simply unmark this as leaf
            else {
                currentNode.isEndOfWord = false;
                deletedSelf = false;
            }
        } else {
            TrieNode childNode = currentNode.children[getIndex(key.charAt(level))];
            boolean childDeleted = deleteHelper(key, childNode, length, level + 1);
            if (childDeleted) {
                System.out.println(">>>>>>>>>>> " + getIndex(key.charAt(level)));
                //Making children pointer also null: since child is deleted
                currentNode.children[getIndex(key.charAt(level))] = null;
                //If currentNode is leaf node that means currntNode is part of another key
                //and hence we can not delete this node and it's parent path nodes
                if (currentNode.isEndOfWord) {
                    deletedSelf = false;
                }
                //If childNode is deleted but if currentNode has more children then currentNode must be part of another key.
                //So, we cannot delete currenNode
                else if (!hasNoChildren(currentNode)) {
                    deletedSelf = false;
                }
                //Else we can delete currentNode
                else {
                    currentNode = null;
                    deletedSelf = true;
                }
            } else {
                deletedSelf = false;
            }
        }
        return deletedSelf;
    }

    //Function to delete given key from Trie
    public void delete(String key) {
        if ((root == null) || (key == null)) {
            System.out.println("Null key or Empty trie error");
            return;
        }
        deleteHelper(key, root, key.length(), 0);
    }

    int totalWords(TrieNode root) {
        int sum = 0;
        if (root != null) {
            if (root.isEndOfWord) {
                return 1;
            } else {
                TrieNode[] children = root.children;
                for (int i = 0; i < children.length; i++) {
                    sum += totalWords(children[i]);
                }
            }
        } else {
            return 0;
        }
        return sum;
    }

    List<String> findAllWords(TrieNode root) {
        List<String> resultList = new ArrayList<>();
        char[] array = new char[20];
        getWord(root, resultList, array, 0);
        return resultList;
    }

    void getWord(TrieNode root, List<String> list, char[] array, int level) {
        if (root.isEndOfWord) {
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < level; i++) {
                word.append(array[i]);
            }
            list.add(word.toString());
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                array[level] = (char) (i + 'a');
                getWord(root.children[i], list, array, level + 1);
            }
        }
    }

    boolean isFormationPossible(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (search(word.substring(0, i)) && search(word.substring(i, word.length()))) {
                return true;
            }
        }
        return false;
    }


}
