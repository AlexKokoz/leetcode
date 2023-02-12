package org.leetcode.contests.weekly.w0304;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int maximumGroups(int[] grades) {
		int ans = 0;
		Arrays.sort(grades);
		long prevSum = 0;
		long prevCount = 0;
		long curSum = 0;
		long curCount = 0;
		for (int grade : grades) {
			curSum += grade;
			curCount++;
			if (curSum > prevSum && curCount > prevCount) {
				ans++;
				prevCount = curCount;
				prevSum = curSum;
				curCount = curSum = 0;
			}
		}
		return ans;
	}
}
