package org.leetcode.contests.weekly.w0311;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] sumPrefixScores(String[] words) {
		int n = words.length;
		int[] ans = new int[n];
		MapTrie trie = new MapTrie();
		for (int i = 0; i < n; i++) {
			trie.put(words[i]);
		}
		for (int i = 0; i < n; i++) {
			ans[i] = trie.get(words[i]);
		}
		return ans;
	}

	static class MapTrie {
		final private TrieNode root;

		public MapTrie() {
			root = new TrieNode();
		}

		public boolean contains(final String key) {
			assert key != null;
			return get(key) != null;
		}

		public Integer get(final String key) {
			int ans = 0;
			assert key != null;
			TrieNode cur = root;
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				cur = cur.find(c);
				ans += cur.val;
			}
			return ans;
		}

		public void put(final String key) {
			assert key != null;
			TrieNode cur = root;
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				cur = cur.putAndReturn(c);
			}
		}

		private static class TrieNode {
			private int val;
			private Map<Character, TrieNode> next;

			public TrieNode() {
				next = new HashMap<>();
			}

			public TrieNode find(final char c) {
				return next.get(c);
			}

			public TrieNode putAndReturn(final char c) {
				TrieNode node = next.get(c);
				if (node == null) {
					node = new TrieNode();
					next.put(c, node);
				}
				node.val += 1; // adhoc
				return node;
			}
		}
	}

}
