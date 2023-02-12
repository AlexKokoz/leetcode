package org.leetcode.contests.weekly.w0292;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String largestGoodInteger(String num) {
		int max = -1;
		String cand = "";
		int n = num.length();
		for (int i = 0; i + 3 <= n; i++) {
			if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)
					&& Integer.parseInt(num.substring(i, i + 3)) > max) {
				max = Integer.parseInt(num.substring(i, i + 3));
				cand = num.substring(i, i + 3);
			}
		}
		return cand;
	}
}
