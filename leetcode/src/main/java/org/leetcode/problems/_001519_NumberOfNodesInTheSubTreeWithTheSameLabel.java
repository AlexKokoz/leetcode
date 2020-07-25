package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001519_NumberOfNodesInTheSubTreeWithTheSameLabel {
	public int[] countSubTrees(int n, int[][] edges, String labels) {
		int p = edges.length;
		int[] from = new int[p];
		int[] to = new int[p];
		for (int i = 0; i < p; i++) {
			from[i] = edges[i][0];
			to[i] = edges[i][1];
		}
		int[][] adj = packU(n, from, to);

		int[] ans = new int[n];
		int[][] f = new int[26][n];
		dfs(-1, 0, labels, adj, ans, f);

		return ans;
	}

	void dfs(int p, int ch, String labels, int[][] adj, int[] ans, int[][] f) {
		int c = labels.charAt(ch) - 'a';
		f[c][ch] += 1;
		for (int nch : adj[ch]) {
			if (nch == p)
				continue;
			dfs(ch, nch, labels, adj, ans, f);
			for (int i = 0; i < 26; i++) {
				f[i][ch] += f[i][nch];
			}
		}
		ans[ch] = f[c][ch];
	}

	int[][] packU(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++) {
			out[to[i]]++;
			out[from[i]]++;
		}
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++) {
			ret[from[i]][--out[from[i]]] = to[i];
			ret[to[i]][--out[to[i]]] = from[i];
		}
		return ret;
	}
}
