package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001503_LastMomentBeforeAllAntsFallOutOfAPlank {
	
	// After collision its like they continue like nothing happened(2-way street)
	public int getLastMoment(int n, int[] left, int[] right) {
		int ans = 0;
		for (int l : left)
			ans = Math.max(ans, l);
		for (int r : right)
			ans = Math.max(ans, n - r);
		return ans;
	}
}
