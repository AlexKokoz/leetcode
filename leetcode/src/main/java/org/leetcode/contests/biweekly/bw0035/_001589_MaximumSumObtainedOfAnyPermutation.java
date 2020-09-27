package org.leetcode.contests.biweekly.bw0035;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001589_MaximumSumObtainedOfAnyPermutation {
	public int maxSumRangeQuery(int[] nums, int[][] requests) {
		int n = nums.length;
		int p = requests.length;
		long ans = 0;
		long mod = 1000000007;
		int[][] events = new int[2 * p][2];
		for (int i = 0; i < p; i++) {
			events[2 * i][0] = requests[i][0];
			events[2 * i][1] = 1;
			events[2 * i + 1][0] = requests[i][1];
			events[2 * i + 1][1] = -1;
		}
		Arrays.sort(events, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return a[0] - b[0];
				return b[1] - a[1];
			}
		});

		int[] w = new int[n];
		int ct = 0;
		for (int i = 0, j = 0; i < n; i++) {
			if (j < events.length && events[j][0] == i) {
				int jj = j;
				while (jj < events.length && events[j][0] == events[jj][0] && events[jj][1] > 0) {
					ct++;
					jj++;
				}
				w[i] = ct;
				while (jj < events.length && events[j][0] == events[jj][0] && events[jj][1] < 0) {
					ct--;
					jj++;
				}
				j = jj;
			} else {
				w[i] = ct;
			}
		}
		Arrays.sort(w);
		Arrays.sort(nums);

		for (int i = n - 1; i >= 0; i--) {
			ans = (ans + w[i] * nums[i]) % mod;
		}

		return (int) ans;
	}
}
