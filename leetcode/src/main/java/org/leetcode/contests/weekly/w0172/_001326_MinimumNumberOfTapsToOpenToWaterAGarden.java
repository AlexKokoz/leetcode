package org.leetcode.contests.weekly.w0172;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001326_MinimumNumberOfTapsToOpenToWaterAGarden {
	public int minTaps(int n, int[] ranges) {
		int[] rightOf = new int[n + 1];
		for (int i = 0; i < ranges.length; i++) {
			int left = Math.max(0, i - ranges[i]);
			int right = Math.min(n, i + ranges[i]);
			rightOf[left] = Math.max(rightOf[left], right);
		}
		int count = 0;
		int right = 0;
		int newRight = 0;
		int inner = 0;
		while (right < n) {
			while (inner <= right) {
				newRight = Math.max(newRight, rightOf[inner]);
				inner++;
			}
			if (newRight <= right)
				return -1;
			right = newRight;
			count++;
		}
		return count;
	}
}
