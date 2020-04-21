package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000060_PermutationSequence {
	public String getPermutation(int n, int k) {
		k--;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++)
			nums[i] = i + 1;
		while (k-- > 0) {
			int next = n - 2;
			while (next > 0 && nums[next] > nums[next + 1])
				next--;
			int rightMostGreatest = n - 1;
			while (nums[rightMostGreatest] < nums[next])
				rightMostGreatest--;
			swap(next, rightMostGreatest, nums);
			reverse(nums, next + 1, n - 1);
		}
		StringBuilder sb = new StringBuilder();
		for (int num : nums)
			sb.append(num);
		return sb.toString();
	}

	void reverse(int[] arr, int lo, int hi) {
		int mi = lo + ((hi - lo) >>> 1);
		for (int i = 0; i + lo <= mi; i++)
			swap(lo + i, hi - i, arr);
	}

	void swap(int i, int j, int[] arr) {
		int swap = arr[i];
		arr[i] = arr[j];
		arr[j] = swap;
	}
}
