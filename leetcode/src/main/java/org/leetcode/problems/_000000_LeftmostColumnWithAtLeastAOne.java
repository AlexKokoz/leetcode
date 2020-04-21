package org.leetcode.problems;

import java.util.List;

public class _000000_LeftmostColumnWithAtLeastAOne {
	interface BinaryMatrix {
		public int get(int x, int y);

		public List<Integer> dimensions();
	};

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int n = dimensions.get(0);
		int m = dimensions.get(1);

		int leftMost = m;
		for (int r = 0; r < n; r++) {
			int lo = 0;
			int hi = m - 1;
			while (lo <= hi) {
				int mi = lo + ((hi - lo) >>> 1);
				int query = binaryMatrix.get(r, mi);
				if (query != 1) {// go right
					lo = mi + 1;
				} else {
					leftMost = Math.min(leftMost, mi);
					hi = mi - 1;
				}

			}
		}

		return leftMost == m ? -1 : leftMost;
	}
}
