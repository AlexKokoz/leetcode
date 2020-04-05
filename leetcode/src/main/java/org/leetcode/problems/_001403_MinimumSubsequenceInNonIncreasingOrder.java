package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001403_MinimumSubsequenceInNonIncreasingOrder {
	public List<Integer> minSubsequence(int[] nums) {
		int n = nums.length;
		int[][] aux = new int[n][2];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			aux[i][0] = nums[i];
			aux[i][1] = i;
			sum += nums[i];
		}

		Arrays.sort(aux, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int subsum = 0;
		int start;
		for (start = n - 1; start >= 0; start--) {
			subsum += aux[start][0];
			if (subsum > sum / 2)
				break;
		}

		List<Integer> ans = new LinkedList<>();
		for (int i = n - 1; i >= start; i--) {
			ans.add(aux[i][0]);
		}
		return ans;
	}
}
