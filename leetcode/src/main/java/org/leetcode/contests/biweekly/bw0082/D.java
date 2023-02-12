package org.leetcode.contests.biweekly.bw0082;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public int validSubarraySize(int[] nums, int threshold) {
		int n = nums.length;
		int[] right = new int[n];
		right[n - 1] = n;
		for (int i = n - 2; i >= 0; i--) {
			int next = i + 1;
			while (next != n && nums[i] <= nums[next]) {
				next = right[next];
			}
			right[i] = next;
		}
		int[] left = new int[n];
		left[0] = -1;
		for (int i = 1; i < n; i++) {
			int next = i - 1;
			while (next != -1 && nums[i] <= nums[next]) {
				next = left[next];
			}
			left[i] = next;
		}
		for (int i = 0; i < n; i++) {
			int len = right[i] - left[i] - 1;
			if (len > threshold / nums[i]) {
				return nums[i];
			}
		}
		return -1;
	}
}
