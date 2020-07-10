package org.leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _000212_WordSearchII {
	int[] dr = { 1, 0, -1, 0 };
	int[] dc = { 0, 1, 0, -1 };

	public List<String> findWords(char[][] board, String[] words) {
		int n = board.length;
		int m = board[0].length;
		Set<String> set = new HashSet<>();
		boolean[][] seen = new boolean[n][m];
		Trie trie = new Trie();
		for (String word : words)
			trie.add(word);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				dfs(r, c, board, seen, set, trie, trie.root(), new StringBuilder());
			}
		}
		List<String> ans = new ArrayList<>(set);
		return ans;
	}

	void dfs(int r, int c, char[][] board, boolean[][] seen, Set<String> set, Trie trie, Trie.TrieNode cur,
			StringBuilder sb) {
		char ch = board[r][c];

		if (cur.next[trie.id(ch)] == null) {
			return;
		}

		seen[r][c] = true;
		Trie.TrieNode next = cur.next[trie.id(ch)];
		sb.append(ch);
		if (next.flag)
			set.add(sb.toString());

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nc < 0 || nr == board.length || nc == board[0].length || seen[nr][nc])
				continue;
			dfs(nr, nc, board, seen, set, trie, next, sb);
		}

		seen[r][c] = false;
		sb.deleteCharAt(sb.length() - 1);

	}

	static class Trie {

		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		class TrieNode {
			boolean flag;
			TrieNode[] next;

			public TrieNode() {
				next = new TrieNode[26];
			}
		}

		void add(String word) {
			TrieNode cur = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int id = id(c);
				if (cur.next[id] == null)
					cur.next[id] = new TrieNode();
				cur = cur.next[id];
			}
			cur.flag = true;
		}

		int id(char c) {
			return c - 'a';
		}

		TrieNode root() {
			return root;
		}
	}
}
