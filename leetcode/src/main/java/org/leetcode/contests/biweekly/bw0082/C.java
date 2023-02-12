package org.leetcode.contests.biweekly.bw0082;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
		int n = nums1.length;
		int[][] nums = new int[n][2];
		for (int i = 0; i < n; i++) {
			nums[i] = new int[] { nums1[i], nums2[i], Math.abs(nums1[i] - nums2[i]) };
		}
		// desc diff
		Arrays.sort(nums, (a, b) -> {
			return Integer.compare(b[2], a[2]);
		});
		int moves = k1 + k2;
		int[][] steps = new int[n][2];
		int p = 0;
		for (int i = 0; i < n; i++) {
			if (i == 0 || nums[i][2] != nums[i - 1][2]) {
				steps[p++] = new int[] { nums[i][2], i };
			}
		}
		steps = Arrays.copyOf(steps, p);
		int ns = steps.length;

		int i = 1;
		while (i < ns) {
			long diff = steps[i - 1][0] - steps[i][0];
			if (moves < steps[i][1] * diff) {
				break;
			}
			moves -= steps[i][1] * diff;
			i++;
		}

		if (i == ns) {
			int each = steps[ns - 1][0] - moves / n;
			int rem = moves % n;
			for (int j = 0; j < n; j++) {
				nums[j][2] = each;
				if (j < rem)
					nums[j][2]--;
				nums[j][2] = Math.max(nums[j][2], 0);
			}
		} else {

			for (int j = 0; j < steps[i][1]; j++) {
				nums[j][2] = steps[i - 1][0];
			}
			int each = steps[i - 1][0] - moves / steps[i][1];
			int rem = moves % steps[i][1];
			for (int j = 0; j < steps[i][1]; j++) {
				nums[j][2] = each;
				if (j < rem)
					nums[j][2]--;
				nums[j][2] = Math.max(nums[j][2], 0);
			}
		}

		long ans = 0;
		for (int j = 0; j < n; j++) {
			ans += (long) nums[j][2] * nums[j][2];
		}
		return ans;

	}
}
