package org.leetcode.contests.biweekly.bw0084;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long minimumReplacement(int[] nums) {
		int n = nums.length;
		long ans = 0;
		
		int prev = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (nums[i] <= prev) {
				prev = nums[i];
			} else if (prev % nums[i] == 0) {
				ans += prev / nums[i] - 1;
			}else {
				long times = (int) Math.ceil((double)nums[i] / prev);
				ans += times - 1;
				prev = nums[i] / (int)times;
			}
		}
		return ans;
	}
}
