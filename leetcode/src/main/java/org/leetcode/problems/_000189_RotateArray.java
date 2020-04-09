package org.leetcode.problems;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
public class _000189_RotateArray {

	// O(n) time; O(n) space
	public void rotate(int[] nums, int k) {
		final int n = nums.length;
		k %= n;
		if (k == 0)
			return;
		final int[] ans = new int[n];
		for (int i = 0; i < n ; i++, k = (k + 1) % n) {
			ans[k] = nums[i];
		}
		for (int i = 0; i < n; i++)
			nums[i] = ans[i];
	}
	
   // O(n) time; O(1) space; 
	public void rotate2(int[] nums, int k) {
		final int n = nums.length;
		k %= n;
		if (k == 0)
			return;
		int mid = n - k;
		int next = mid;
		int curr = 0;
		while (curr != next & next < n) {
			int swap = nums[next];
			nums[next] = nums[curr];
			nums[curr] = swap;
			curr++;
            next++;
			if (next == n) {
				next = mid;
			} else if (curr == mid) {
				mid = next;
			}
		}
	}

}
