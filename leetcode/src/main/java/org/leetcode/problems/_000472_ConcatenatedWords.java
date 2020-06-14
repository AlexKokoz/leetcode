package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000472_ConcatenatedWords {

	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		Trie<Boolean> trie = new Trie<>();
		Set<String> set = new HashSet<>();

		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});
		for (String word : words) {
			dfs(word, 0, trie, trie.getRoot(), set);
			trie.put(word, true);
		}
		List<String> ans = new LinkedList<>(set);
		return ans;
	}

	static void dfs(String s, int d, Trie<Boolean> trie, Trie.TrieNode<Boolean> node, Set<String> set) {
		if (set.contains(s) || node == null)
			return;
		if (d == s.length()) {
			if (node.val != null)
				set.add(s);
			return;
		}
		node = trie.get(node, s.substring(d, d + 1));
		if (node == null)
			return;
		dfs(s, d + 1, trie, node, set);
		if (node.val != null) {
			dfs(s, d + 1, trie, trie.getRoot(), set);
		}
	}

	static class Trie<V> {

		private TrieNode<V> root;

		public static class TrieNode<V> {
			TrieNode<V> next;
			TrieNode<V> firstChild;
			char c;
			V val;

			public TrieNode(char c) {
				this.c = c;
			}

			public TrieNode<V> searchChild(char c) {
				TrieNode<V> ch;
				for (ch = firstChild; ch != null && ch.c != c; ch = ch.next)
					;
				return ch;
			}

			public String toString() {
				return toString("  ");
			}

			public String toString(String indent) {
				StringBuilder sb = new StringBuilder();
				sb.append(indent + c + " " + val + "\n");
				for (TrieNode<V> ch = firstChild; ch != null; ch = ch.next)
					sb.append(ch.toString(indent + "  "));
				return sb.toString();
			}
		}

		public Trie() {
			root = new TrieNode<>('\0');
		}

		public boolean contains(String s) {
			return get(s) != null;
		}

		public V get(String s) {
			if (s == null)
				throw new NullPointerException("string is null");
			TrieNode<V> node = get(root, s);
			if (node == null || node.val == null)
				return null;
			return node.val;
		}

		private TrieNode<V> get(TrieNode<V> node, String s) {
			if (node == null)
				return null;
			TrieNode<V> cur = node;
			for (int i = 0; i < s.length() && cur != null; i++) {
				char c = s.charAt(i);
				cur = cur.searchChild(c);
			}
			return cur;
		}

		public void put(String s, V val) {
			if (s == null)
				throw new NullPointerException("string is null");
			if (val == null)
				throw new NullPointerException("value is null");
			put(root, s, val);
		}

		private void put(TrieNode<V> node, String s, V val) {
			if (node == null)
				throw new NullPointerException("node is null");
			TrieNode<V> par = node;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (par.firstChild == null) {
					TrieNode<V> x = new TrieNode<>(c);
					par.firstChild = x;
					par = x;
				} else {
					TrieNode<V> pre = null;
					TrieNode<V> cur = par.firstChild;
					while (cur != null && cur.c != c) {
						pre = cur;
						cur = cur.next;
					}
					if (cur == null) {
						TrieNode<V> x = new TrieNode<>(c);
						pre.next = x;
						par = pre.next;
					} else {
						par = cur;
					}
				}
			}
			par.val = val;
		}

		/**
		 * Custom methods for this problem
		 */

		public TrieNode<V> getRoot() {
			return root;
		}

		public String toString() {
			return root.toString();
		}
	}
}
