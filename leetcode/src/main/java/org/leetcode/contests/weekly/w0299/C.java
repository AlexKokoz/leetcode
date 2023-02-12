package org.leetcode.contests.weekly.w0299;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int maximumsSplicedArray(int[] nums1, int[] nums2) {
		long sum1 = sum(nums1);
		long sum2 = sum(nums2);
		long ans = Math.max(sum1, sum2);
		ans = Math.max(ans, sum1 + go(nums1, nums2));
		ans = Math.max(ans, sum2 + go(nums2, nums1));
		return (int)ans;
	}
	
	static long sum(int...a) {long sum = 0; for (int x : a) sum += x; return sum; }
	
	static long go(int[] a, int[] b) {
		int n = a.length;
		long[] diff = new long[n];
		for (int i = 0; i < n; i++) {
			diff[i] = b[i] - a[i];
		}
		long globalMax = Long.MIN_VALUE;
		long localMax = 0;
		for (int i = 0; i < n; i++) {
			localMax = Math.max(localMax + diff[i], diff[i]);
			globalMax = Math.max(globalMax, localMax);
		}
		return Math.max(0, globalMax);
	}
}
