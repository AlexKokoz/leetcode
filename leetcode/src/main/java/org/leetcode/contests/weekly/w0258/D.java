package org.leetcode.contests.weekly.w0258;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
		int n = nums.length;
		int[] from = new int[n - 1];
		int[] to = new int[n - 1];
		for (int i = 1; i < n; i++) {
			from[i - 1] = parents[i];
			to[i - 1] = i;
		}
		int[][] adj = packD(n, from, to);
		int[] ans = new int[n];
		dfs(-1, 0, adj, nums, ans);
		return ans;

	}

	List<int[]> dfs(int p, int ch, int[][] adj, int[] nums, int[] ans) {
		List<int[]> ret = new ArrayList<>();
		ret.add(new int[] { nums[ch], nums[ch] + 1 });
		for (int nch : adj[ch]) {
			if (nch == p)
				continue;
			List<int[]> desc = dfs(ch, nch, adj, nums, ans);
			for (int[] interval : desc) {
				ret.add(interval);
			}
			merge(ret);
			if (ret.get(0)[0] != 1) {
				ans[ch] = 1;
			} else {
				ans[ch] = ret.get(0)[1];
			}
			
		}
		return ret;
	}

	void merge(List<int[]> is) {
		Collections.sort(is, (a, b) -> {
			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			return Integer.compare(b[1], a[1]);
		});
		int p = 0;
		int[] node = new int[] { is.get(0)[0], is.get(p)[1] };
		for (int i = 1; i < is.size(); i++) {
			int[] cur = is.get(i);
			if (node[1] >= cur[0]) {
				node[1] = Math.max(node[1], cur[1]);
			} else {
				is.set(p++, node);
				node = new int[] { cur[0], cur[1] };
			}
		}
		is.set(p++, node);
		for (int i = is.size() - 1; i >= p; i--)
			is.remove(i);
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
