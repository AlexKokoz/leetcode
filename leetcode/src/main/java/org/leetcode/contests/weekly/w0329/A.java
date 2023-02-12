package org.leetcode.contests.weekly.w0329;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int alternateDigitSum(int n) {
		n = Integer.parseInt(new StringBuilder().append(n).reverse().toString());
		int ans = 0;
		for (int i = 0; n > 0; i++) {
			ans += (i % 2 == 0 ? 1 : -1) * (n % 10);
			n /= 10;
		}
		return ans;
	}
}
