package org.leetcode.contests.weekly.w0264;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int countHighestScoreNodes(int[] parents) {
		int np = parents.length;
		int[] from = new int[np - 1];
		int[] to = new int[np - 1];
		for (int i = 1; i < np; i++) {
			from[i] = parents[i];
			to[i] = i;
		}
		int[][] adj = packD(np, from, to);
		int[] sz = new int[np];
		dfs(0, adj, sz, np);
		List<Long> list = new ArrayList<>();
		for (int i = 0; i < np; i++) {
			long val;
			if(adj[i].length == 0) {
				val = np - 1;
			} else if (adj[i].length == 1) {
				int sz1 = sz[adj[i][0]];
				int up = np - 1 - sz1;
				val = sz1 * up;
			} else {
				int sz1 = sz[adj[i][0]];
				int sz2 = sz[adj[i][1]];
				int up = np - 1 - sz1 - sz2;
				val = sz1 * sz2 * up;
			}
			list.add(val);
		}
		Collections.sort(list);
		int ans = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
			ans++;
			if (i > 0) {
				long cur = list.get(i);
				long pre = list.get(i - 1);
				if (cur != pre) break;
			}
		}
		return ans;
	}
	
	
	void dfs(int cur, int[][] adj, int[] sz, int n) {
		int ans = 1;
		for (int nei : adj[cur]) {
			dfs(nei, adj, sz, n);
			ans += sz[nei];
		}
		sz[cur] = ans;
	}

	static int[][] packD(int n, int[] from, int[] to) {
		int[] out = new int[n];
		for (int i = 0; i < from.length; i++)
			out[from[i]]++;
		int[][] ret = new int[n][];
		for (int i = 0; i < ret.length; i++)
			ret[i] = new int[out[i]];
		for (int i = 0; i < from.length; i++)
			ret[from[i]][--out[from[i]]] = to[i];
		return ret;
	}
}
