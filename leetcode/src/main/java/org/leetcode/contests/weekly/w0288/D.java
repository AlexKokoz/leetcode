package org.leetcode.contests.weekly.w0288;

import java.util.Arrays;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
		int n = flowers.length;
		Arrays.sort(flowers);
		int addedHeight = 0;
		int lastAddPos = -1;
		for (int i = 0; i < n && flowers[i] < target - 1; i++) {
			if (i == n - 1 || flowers[i] != flowers[i + 1]) {
				while (newFlowers >= i + 1) {
					if (flowers[0] + addedHeight == target - 1
							|| (i < n - 1 && flowers[0] + addedHeight == flowers[i + 1]))
						break;
					newFlowers -= i + 1;
					addedHeight++;
					lastAddPos = i;
				}
			}
		}
		int i = n - 1;
		while (i >= 0 && flowers[i] >= target) {
			i--;
		}
		long ans = (long) full * (n - i - 1) + (long) partial * (i == -1 ? 0 : (flowers[0] + addedHeight));
		while (i >= 0) {
			if (lastAddPos >= i)
				lastAddPos = i - 1;
			long need = target - Math.max(flowers[i], flowers[0] + addedHeight);
			long take = Math.min(newFlowers, need);
			need -= take;
			newFlowers -= take;
			while (need > 0 && lastAddPos >= 0) {
				long layer = lastAddPos + 1;
				take = Math.min(layer, need);
				need -= take;
				newFlowers += layer - take;
				addedHeight--;
				while (lastAddPos >= 0 && flowers[0] + addedHeight == flowers[lastAddPos]) {
					lastAddPos--;
				}
			}
			if (need > 0)
				break;
			long height = (i == 0 ? 0 : (flowers[0] + addedHeight));
			if (i > 0 && flowers[0] + addedHeight < target - 1)
				height += newFlowers / i;
			long cand = (long) full * (n - i) + (long) partial * height;
			ans = Math.max(ans, cand);
			i--;
		}
		return ans;

	}
}
