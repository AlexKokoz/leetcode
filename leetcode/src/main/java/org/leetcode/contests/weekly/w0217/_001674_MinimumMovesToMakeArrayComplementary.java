package org.leetcode.contests.weekly.w0217;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001674_MinimumMovesToMakeArrayComplementary {

	public int minMoves(int[] nums, int limit) {
		int cap = 200000;
		int n = nums.length;
		int h = n / 2;
		int ans = Integer.MAX_VALUE;
		int[] cum = new int[cap + 1];
		for (int i = 0; i < h; i++) {
			int l = nums[i];
			int r = nums[n - 1 - i];
			int min = Math.min(l, r);
			int max = Math.max(l, r);
			int sum = l + r;
			cum[2] += 2;
			cum[min + 1]--;
			cum[max + limit + 1]++;
			cum[sum]--;
			cum[sum + 1]++;
		}
		for (int i = 1; i < cum.length; i++)
			cum[i] += cum[i - 1];
		for (int i = 2; i < cum.length; i++)
			ans = Math.min(ans, cum[i]);
		return ans;
	}
}
