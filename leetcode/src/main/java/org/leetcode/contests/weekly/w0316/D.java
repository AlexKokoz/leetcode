package org.leetcode.contests.weekly.w0316;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long makeSimilar(int[] nums, int[] target) {
		int n = nums.length;
		long ans = 0;
		int[] numsEvens = new int[n];
		{
			int p = 0;
			for (int num : nums) {
				if (num % 2 == 0) {
					numsEvens[p++] = num;
				}
			}
			numsEvens = Arrays.copyOf(numsEvens, p);
		}
		Arrays.sort(numsEvens);

		int[] targetEvens = new int[n];
		{
			int p = 0;
			for (int num : target) {
				if (num % 2 == 0) {
					targetEvens[p++] = num;
				}
			}
			targetEvens = Arrays.copyOf(targetEvens, p);
		}
		Arrays.sort(targetEvens);
		for (int i = 0; i < numsEvens.length; i++) {
			ans += Math.abs(numsEvens[i] - targetEvens[i]) / 2;
		}

		int[] numsOdds = new int[n];
		{
			int p = 0;
			for (int num : nums) {
				if (num % 2 == 1) {
					numsOdds[p++] = num;
				}
			}
			numsOdds = Arrays.copyOf(numsOdds, p);
		}
		Arrays.sort(numsOdds);

		int[] targetOdds = new int[n];
		{
			int p = 0;
			for (int num : target) {
				if (num % 2 == 1) {
					targetOdds[p++] = num;
				}
			}
			targetOdds = Arrays.copyOf(targetOdds, p);
		}
		Arrays.sort(targetOdds);
		for (int i = 0; i < numsOdds.length; i++) {
			ans += Math.abs(numsOdds[i] - targetOdds[i]) / 2;
		}

		return ans / 2;

	}
}
