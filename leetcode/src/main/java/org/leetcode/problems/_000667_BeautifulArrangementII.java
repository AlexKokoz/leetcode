package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000667_BeautifulArrangementII {
	public int[] constructArray(int n, int k) {
		int[] ans = new int[n];
		int lo = 1;
		int hi = n;
		int mi = lo + (hi - lo >>> 1);
		for (int i = 0, val = lo; i < k; i++) {
			ans[i] = val;
			if (val <= mi) {
				lo++;
				val = hi;
			} else {
				hi--;
				val = lo;
			}
		}
		int step, val;
		if (ans[k - 1] <= mi) {
			val = lo;
			step = 1;
		} else {
			val = hi;
			step = -1;
		}
		for (int i = k; i < n; i++) {
			ans[i] = val;
			val += step;
		}
		return ans;
	}
}
