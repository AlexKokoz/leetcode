package org.leetcode.contests.weekly.w0212;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001630_ArithmeticSubarrays {
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> ans = new ArrayList<>();
		outer: for (int i = 0; i < l.length; i++) {
			int[] sub = Arrays.copyOfRange(nums, l[i], r[i] + 1);
			Arrays.sort(sub);
			for (int j = 1; j < sub.length; j++) {
				if (sub[j] - sub[j - 1] != sub[1] - sub[0]) {
					ans.add(false);
					continue outer;
				}
			}
			ans.add(true);
		}
		return ans;
	}
}
