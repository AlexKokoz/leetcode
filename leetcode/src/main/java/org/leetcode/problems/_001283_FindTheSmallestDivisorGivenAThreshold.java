package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001283_FindTheSmallestDivisorGivenAThreshold {
	public int smallestDivisor(int[] nums, int threshold) {
		int mindiv = Integer.MAX_VALUE;
		int lo = 1;
		int hi = 0;
		for (int num : nums)
			hi = Math.max(hi, num);
		while (lo <= hi) {
			int mi = lo + (hi - lo) / 2;
			int val = calc(nums, mi);
			if (val > threshold)
				lo = mi + 1;
			else {
				mindiv = Math.min(mindiv, mi);
				hi = mi - 1;
			}
		}
		return mindiv;
	}

	int calc(int[] nums, int div) {
		int sum = 0;
		for (int num : nums)
			sum += (int) Math.floor(num / div);
		return sum;
	}
}
