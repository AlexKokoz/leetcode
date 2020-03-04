package org.leetcode.contests.biweekly.bw0019;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001343_NumberOfSubarraysOfSizeKandAverageGreaterEqualToThreshold {
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int n = arr.length;
		int[] pre = new int[n];
		pre[0] = arr[0];
		for (int i = 1; i < n; i++)
			pre[i] = arr[i] + pre[i - 1];
		int count = 0;
		for (int i = 0; i <= n - k; i++) {
			int sum = sum(i, i + k - 1, pre);
			double curAvg = sum * 1.0 / k;
			if (curAvg >= threshold)
				count++;
		}
		return count;
	}

	int sum(int from, int to, int[] pre) {
		if (from == 0)
			return pre[to];
		return pre[to] - pre[from - 1];
	}
}
