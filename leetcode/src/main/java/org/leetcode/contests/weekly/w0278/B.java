package org.leetcode.contests.weekly.w0278;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public List<Integer> maxScoreIndices(int[] nums) {
		List<Integer> ans = new ArrayList<>();
		int n = nums.length;
		int[] onesrl = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			onesrl[i] = onesrl[i + 1] + nums[i];
		}
		int max = 0;
		for (int i = 0, zeros = 0; i <= n; i++) {
			max = Math.max(max, zeros + onesrl[i]);
			if (i < n && nums[i] == 0)
				zeros++;
		}
		for (int i = 0, zeros = 0; i <= n; i++) {
			int score = zeros + onesrl[i];
			if (score == max)
				ans.add(i);
			if (i < n && nums[i] == 0)
				zeros++;
		}
		return ans;
	}
}
