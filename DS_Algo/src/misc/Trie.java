package misc;

import java.util.*;

public class Trie {

	private class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		TrieNode () {
			children = new HashMap<Character, TrieNode> ();
			endOfWord = false;
		}
	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert (String word) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			TrieNode node = current.children.get(ch);

			if (node == null) {
				node = new TrieNode();
				current.children.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;
	}

	public boolean search (String word) {
		TrieNode current = root;

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);
			TrieNode node = current.children.get(ch);

			if (node == null)
				return false;

			current = node;
		}
		return current.endOfWord;
	}
	
	public String longestCommonPrefix () {
		TrieNode current = root;
		String prefix = "";
		
		while (current.children.size() == 1 && current.endOfWord == false) {
			Set<Character> s = current.children.keySet();
			TrieNode node = null;
			for (Character ch : s) {
				prefix += ch;
				node = current.children.get(ch);
			}
			current = node;
		}
		
		return prefix;
	}
}