package com.datastructures.tries;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String dict[] = {"the", "hello", "there", "answer", "any", "Dragon",
                "world", "their", "inc"};
        for (String word : dict) {
            trie.insert(word);
        }
//        trie.insert("their");
//        trie.insert("hello");
//        trie.insert("the");
        System.out.println(trie.isFormationPossible("helloworlda"));
//        trie.delete("the");
//        System.out.println(trie.totalWords(trie.root));
//        System.out.println(Arrays.toString(trie.findAllWords(trie.root).toArray()));
    }
}
