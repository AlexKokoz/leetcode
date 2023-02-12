package org.leetcode.contests.weekly.w0310;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int mostFrequentEven(int[] nums) {
		int[] count = new int[100001];
		int ans = -1;
		for (int num : nums)
			count[num]++;
		for (int i = 0; i < count.length; i += 2) {
			if (count[i] > 0 && (ans == -1 || count[i] > count[ans]))
				ans = i;
		}
		return ans;
	}
}
