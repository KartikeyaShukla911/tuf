package com.tuf.GC;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Trie
{
	int frequency=0;
	Trie[] children = new Trie[27];
	String word="";
	
	
	public void insert(String word,int frequency)
	{
		Trie node = this;
		for(char ch : word.toCharArray())
		{
			int index = ch==' '? 26 : ch-'a';
			if(children[index]==null)
			{
				children[index]= new Trie();
			}
			node = node.children[index];
		}
		node.frequency=frequency;
		node.word=word;
	}
	
	public String search(String word)
	{
		Trie node = this;
		for(char ch : word.toCharArray())
		{
			int index = ch==' '? 26:ch-'a';
			if(node.children[index]==null)
				return "";
			node=node.children[index];
		}
		return node.word;
	}
}


class AutocompleteSystem {
    private Trie rootTrie = new Trie(); // Trie root
    private StringBuilder currentInput = new StringBuilder();

    // Constructor which takes an array of sentences and their corresponding
    // frequencies to build the trie
    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            rootTrie.insert(sentences[i], times[i]);
        }
    }

    // Processes input character by character to autocomplete
    public List<String> input(char inputChar) {
        List<String> autocompleteResult = new ArrayList<>();
        if (inputChar == '#') {
            rootTrie.insert(currentInput.toString(), 1); // Insert the current input into the trie
            currentInput = new StringBuilder(); // Reset builder for next input
            return autocompleteResult; // Autocomplete list is empty for new input
        }
        currentInput.append(inputChar); // Adding new character to current input
        Trie node = rootTrie.search(currentInput.toString());
        if (node == null) {
            return autocompleteResult; // If no node found, return empty list
        }
        PriorityQueue<Trie> minHeap
            = new PriorityQueue<>((a, b) -> a.frequency == b.frequency ? b.word.compareTo(a.word) : a.frequency - b.frequency);
        depthFirstSearch(node, minHeap);
        while (!minHeap.isEmpty()) {
            autocompleteResult.add(0, minHeap.poll().word);
        }
        return autocompleteResult; // Return the list of autocompleted words
    }

    // DFS to find all words with the same prefix, use a priority queue to sort them based on frequency and lexicographical order
    private void depthFirstSearch(Trie node, PriorityQueue<Trie> minHeap) {
        if (node == null || minHeap.size() > 3 && node.frequency < minHeap.peek().frequency) {
            return; // Early return condition to prune the search
        }
        if (node.frequency > 0) {
            minHeap.offer(node); // If it's a word, offer to the min-heap
            if (minHeap.size() > 3) {
                minHeap.poll(); // Keep the size of min-heap no larger than 3
            }
        }
        for (Trie childNode : node.children) {
            depthFirstSearch(childNode, minHeap); // Recursively search children
        }
    }
    // TC - On, S n
}

