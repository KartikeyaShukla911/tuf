package com.tuf.GC;

//Trie Node
class TrieNode {
 TrieNode[] children;
 boolean isEndOfWord;

 public TrieNode() {
     children = new TrieNode[26]; // Assuming only lowercase English letters
     isEndOfWord = false;
 }
}

//Trie Implementation
class Trie {
 private TrieNode root;

 public Trie() {
     root = new TrieNode();
 }

 // Inserts a word into the Trie
 public void insert(String word) {
     TrieNode node = root;
     for (char ch : word.toCharArray()) {
         int index = ch - 'a';
         if (node.children[index] == null) {
             node.children[index] = new TrieNode();
         }
         node = node.children[index];
     }
     node.isEndOfWord = true;
 }

 // Returns true if the word is in the Trie
 public boolean search(String word) {
     TrieNode node = getNode(word);
     return node != null && node.isEndOfWord;
 }

 // Returns true if there is any word in the Trie that starts with the given prefix
 public boolean startsWith(String prefix) {
     return getNode(prefix) != null;
 }

 // Helper function to traverse the Trie
 private TrieNode getNode(String word) {
     TrieNode node = root;
     for (char ch : word.toCharArray()) {
         int index = ch - 'a';
         if (node.children[index] == null) {
             return null;
         }
         node = node.children[index];
     }
     return node;
 }
}

//Example Usage
public class Main {
 public static void main(String[] args) {
     Trie trie = new Trie();
     
     trie.insert("apple");
     System.out.println(trie.search("apple"));   // true
     System.out.println(trie.search("app"));     // false
     System.out.println(trie.startsWith("app")); // true
     
     trie.insert("app");
     System.out.println(trie.search("app"));     // true
 }
}
/*
 * Time Complexity Breakdown
Insert (insert(word)): 
𝑂
(
𝐿
)
O(L)

We traverse the word character by character, inserting nodes if they don't exist.

Search (search(word)): 
𝑂
(
𝐿
)
O(L)

We check if each character exists in the Trie. If we reach the end and isEndOfWord is true, the word exists.

Prefix Search (startsWith(prefix)): 
𝑂
(
𝐿
)
O(L)

We traverse the Trie to check if the prefix exists.

Advantages of Trie
✅ Fast Search & Insert - Works better than HashMaps for prefix searches.
✅ Efficient Auto-complete & Spell-checking - Common use cases in text applications.
✅ Memory Efficient for Short Strings - Does not store duplicate prefixes.

When to Use a Trie?
Prefix-based searching (autocomplete, spell checkers, search suggestions).

When storing a dictionary of words efficiently.

Efficient word filtering (e.g., profanity filters).
 */

