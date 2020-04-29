package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001089_DuplicateZeros {
	public void duplicateZeros(int[] nums) {
		int n = nums.length;
		int zeros = 0;
		for (int num : nums)
			if (num == 0)
				zeros++;
		if (zeros == 0)
			return;
		boolean firstZero = false;
		int j = n - 1;
		for (int i = 0; i < zeros;) {
			if (nums[j] == 0) {
				if (!firstZero) {
					firstZero = true;
					i++;
				} else {
					firstZero = false;
					i++;
					j--;
				}
			} else {
				i++;
				j--;
			}
		}
		int newj = n - 1;
		if (firstZero) {
			nums[newj] = 0;
			j--;
			newj--;
		}
		while (j >= 0) {
			if (nums[j] == 0) {
				nums[newj] = 0;
				newj--;
				nums[newj] = 0;
				newj--;
				j--;
			} else {
				nums[newj--] = nums[j--];
			}
		}
	}
}
