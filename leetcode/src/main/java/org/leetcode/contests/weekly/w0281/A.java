package org.leetcode.contests.weekly.w0281;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int countEven(int num) {
		int ans = 0;
		for (int x = 1; x <= num; x++) {
			int sum = 0;
			int xx = x;
			while (xx != 0) {
				sum += xx % 10;
				xx /= 10;
			}
			if (sum % 2 == 0)
				ans++;
		}
		return ans;
	}
}
