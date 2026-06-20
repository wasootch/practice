package org.example.strings;

/// 208. Implement Trie (Prefix Tree)
/// Medium
///
/// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
///
/// Implement the Trie class:
///
/// Trie() Initializes the trie object.
/// void insert(String word) Inserts the string word into the trie.
/// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
/// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
///
/// Example 1:
/// Trie trie = new Trie();
/// trie.insert("apple");
/// trie.search("apple");   // return True
/// trie.search("app");     // return False
/// trie.startsWith("app"); // return True
/// trie.insert("app");
/// trie.search("app");     // return True
///
/// Constraints:
/// 1 <= word.length, prefix.length <= 2000
/// word and prefix consist only of lowercase English letters.
/// At most 3 * 104 calls in total will be made to insert, search, and startsWith.
public class Trie {

    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    private final TrieNode root = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    private TrieNode traverse(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null) return null;
        }
        return node;
    }

}
