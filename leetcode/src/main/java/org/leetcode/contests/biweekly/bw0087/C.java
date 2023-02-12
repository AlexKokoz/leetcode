package org.leetcode.contests.biweekly.bw0087;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int[] smallestSubarrays(int[] nums) {
		int n = nums.length;
		int[] ans = new int[n];
		int[][] bits = new int[31][n + 1];
		for (int i = 0; i < n; i++) {
			for (int b = 0; b < bits.length; b++) {
				bits[b][i + 1] = bits[b][i];
				if (nums[i] << ~b < 0) {
					bits[b][i + 1]++;
				}
			}
		}
		int j = n - 1;
		ans[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			while (j > i) {
				boolean skip = true;
				for (int b = 0; b < bits.length; b++) {
					// if one of the ones of nums[j] does not exist anywhere else between nums[i:j + 1] do not skip, else skip nums[j]
					if (nums[j] << ~b < 0 && bits[b][j + 1] - bits[b][i] == 1) { 
						skip = false;
						break;
					}
				}
				if (!skip)
					break;
				j--;
			}
			ans[i] = j - i + 1;
		}
		return ans;
	}
}
