package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000283_MoveZeros {
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return;
		int firstZero = 0;
		while (true) {
			while (firstZero < n && nums[firstZero] != 0)
				firstZero++;
			int cur = firstZero + 1;
			while (cur < n && nums[cur] == 0)
				cur++;
			if (cur >= n)
				break;
			swap(firstZero, cur, nums);
		}
	}

	void swap(int i, int j, int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
