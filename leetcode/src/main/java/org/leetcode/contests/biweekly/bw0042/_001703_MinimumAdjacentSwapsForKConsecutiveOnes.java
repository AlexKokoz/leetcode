package org.leetcode.contests.biweekly.bw0042;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001703_MinimumAdjacentSwapsForKConsecutiveOnes {
	public int minMoves(int[] nums, int k) {
		int n = nums.length;
		int ans = Integer.MAX_VALUE;
		int[] ones = new int[n];
		int nOnes = 0;

		for (int l = 0; l < n;) {
			if (nums[l] == 0) {
				l++;
				continue;
			}
			int r = l;
			while (r < n && nums[r] == 1) {
				ones[nOnes++] = r;
				r++;
			}
			if (r - l >= k)
				return 0;
			l = r;
		}
		ones = Arrays.copyOf(ones, nOnes);

		int onesMi = (k - 1) / 2;
		int numsMi = ones[onesMi];
		int cand = 0;
		for (int i = onesMi - 1, placed = 1; i >= 0; i--, placed++) {
			cand += numsMi - ones[i] - placed;
		}
		for (int i = onesMi + 1, placed = 1; i < k; i++, placed++) {
			cand += ones[i] - numsMi - placed;
		}
		ans = Math.min(ans, cand);

		for (int hi = k, lo = hi - k + 1; hi < ones.length; hi++, lo++) {
			cand -= numsMi - ones[lo - 1] - (onesMi - lo); // remove old leftmost
			onesMi = (hi + lo) / 2; // new ones middle
			numsMi = ones[onesMi]; // new ones middle position in nums
			cand += (onesMi - lo) * (ones[onesMi] - ones[onesMi - 1] - 1); // add newMiddle - oldMiddle
											// difference for all remaining
											// left ones
			cand -= (ones[onesMi] - ones[onesMi - 1] - 1) * (hi - onesMi); // remove newMiddle - oldMiddle
											// difference for all remaining
											// right ones
			cand += (ones[hi] - numsMi - (hi - onesMi - 1)); // add new rightmost
			ans = Math.min(ans, cand);
		}
		return ans;
	}

}
