package com.leet;

/**
 * Definition for a Trie node for leetcode problems
 */
public class TrieNode {

    // for the use case of 26 lowercase characters only
    final int N = 26;

    // Alternatively can use HashMap for large character set or dynamically
    public TrieNode[] children;
    public boolean isWord;
    public String word;

    public TrieNode() {
        this.children = new TrieNode[N];
    }

}
