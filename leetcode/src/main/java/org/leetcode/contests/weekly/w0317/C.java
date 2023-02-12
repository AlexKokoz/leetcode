package org.leetcode.contests.weekly.w0317;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long makeIntegerBeautiful(long n, int target) {
		int total = 0;
		char[] cs = Long.toString(n).toCharArray();
		int[] nums = new int[cs.length + 1];
		nums[0] = 0;
		for (int i = 0; i < cs.length; i++) {
			nums[i + 1] = cs[i] - '0';
			total += nums[i + 1];
		}
		int len = nums.length;
		for (int i = len - 1; i >= 0 && total > target; i--) {
			if (nums[i] == 0)
				continue;
			total -= nums[i];
			nums[i] = 0;
			int carry = 1;
			int j = i - 1;
			while (carry > 0) {
				total -= nums[j];
				int sum = nums[j] + carry;
				nums[j] = sum % 10;
				total += nums[j];
				carry = sum / 10;
				j--;
			}
		}
		long nn = 0;
		for (int num : nums) {
			nn = nn * 10 + num;
		}
		return nn - n;
	}
}
