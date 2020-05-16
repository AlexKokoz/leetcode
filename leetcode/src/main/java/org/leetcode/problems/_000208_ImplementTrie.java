package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000208_ImplementTrie {
	class Trie {
		TrieNode root;

		/** Initialize your data structure here. */
		public Trie() {
			root = new TrieNode('\0');
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			if (search(word) || word == null) {
				return;
			}
			insert(root, word, 0);
		}

		private void insert(TrieNode node, String word, int d) {
			if (d == word.length()) {
				node.endOfWord = true;
				return;
			}
			char c = word.charAt(d);
			TrieNode next = node.next.get(c);
			if (next != null) {
				insert(next, word, d + 1);
			} else {
				TrieNode newNext = new TrieNode(c);
				node.next.put(c, newNext);
				insert(newNext, word, d + 1);
			}
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			return search(root, word, 0);

		}

		private boolean search(TrieNode node, String word, int d) {
			if (d == word.length()) {
				if (node.endOfWord)
					return true;
				else
					return false;
			}
			TrieNode next = node.next.get(word.charAt(d));
			if (next == null) {
				return false;
			}
			return search(next, word, d + 1);
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			int d = 0;
			TrieNode cur = root;
			while (d < prefix.length()) {
				char c = prefix.charAt(d);
				if (!cur.next.containsKey(c))
					break;
				cur = cur.next.get(c);
				d++;
			}
			if (d < prefix.length()) { // prefix doesn't exist
				return false;
			}
			return dfs(cur);
		}

		boolean dfs(TrieNode node) {
			if (node == null)
				return false;
			if (node.endOfWord)
				return true;
			for (char key : node.next.keySet()) {
				TrieNode next = node.next.get(key);
				boolean found = dfs(next);
				if (found)
					return true;
			}
			return false;
		}

		class TrieNode {
			final char c;
			final Map<Character, TrieNode> next;
			boolean endOfWord;

			public TrieNode(char c) {
				this.c = c;
				next = new HashMap<>();
			}
		}
	}
}
