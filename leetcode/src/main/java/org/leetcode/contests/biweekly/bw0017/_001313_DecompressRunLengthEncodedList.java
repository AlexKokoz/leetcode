package org.leetcode.contests.biweekly.bw0017;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001313_DecompressRunLengthEncodedList {
	public int[] decompressRLElist(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return new int[0];
		int len = 0;
		for (int i = 0; i < n; i += 2)
			len += nums[i];
		int[] ans = new int[len];
		int index = 0;
		for (int i = 1; i < n; i += 2)
			for (int j = 0; j < nums[i - 1]; j++)
				ans[index++] = nums[i];
		return ans;
	}
}
