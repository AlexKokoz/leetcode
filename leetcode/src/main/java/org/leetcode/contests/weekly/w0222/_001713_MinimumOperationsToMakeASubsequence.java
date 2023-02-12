package org.leetcode.contests.weekly.w0222;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001713_MinimumOperationsToMakeASubsequence {
	public int minOperations(int[] target, int[] nums) {
		int nt = target.length;
		Map<Integer, Integer> num2order = new HashMap<>();
		for (int i = 0; i < nt; i++)
			num2order.put(target[i], i);
		SegmentTreeMax st = new SegmentTreeMax(nt);
		int max = 0;
		for (int num : nums) {
			if (!num2order.containsKey(num))
				continue;
			int order = num2order.get(num);
			int cand = Math.max(0, st.query(0, order - 1)) + 1;
			st.update(order, cand);
			max = Math.max(max, cand);
		}
		return nt - max;
	}

	static class SegmentTreeMax {
		private int[] tree;
		private final int L; // number of leaves
		private final int T; // number of total nodes for the tree; 0 is dummy

		public SegmentTreeMax(int n) {
			L = 1 << (32 - Integer.numberOfLeadingZeros(n - 1));
			T = L << 1;
			tree = new int[T];
			Arrays.fill(tree, Integer.MIN_VALUE);
		}

		public void update(int pos, int value) {
			tree[L + pos] = value;
			int p = (L + pos) >> 1;
			while (p > 0) {
				propagate(p);
				p >>= 1;
			}
		}

		private void propagate(int pos) {
			tree[pos] = Math.max(tree[pos << 1], tree[(pos << 1) + 1]);
		}

		public int query(int ql, int qr) {
			return ql > qr ? Integer.MIN_VALUE : query(ql, qr, 0, L - 1, 1);
		}

		private int query(int ql, int qr, int l, int r, int pos) {
			// no overlap
			if (ql > qr || qr < l || r < ql)
				return Integer.MIN_VALUE;

			// full overlap
			if (l == r || ql <= l && r <= qr)
				return tree[pos];

			// partial overlap
			int mid = l + (r - l) / 2;
			int left = query(ql, qr, l, mid, 2 * pos);
			int right = query(ql, qr, mid + 1, r, 2 * pos + 1);
			return Math.max(left, right);
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append(Arrays.toString(tree));
			return sb.toString();
		}
	}
}
