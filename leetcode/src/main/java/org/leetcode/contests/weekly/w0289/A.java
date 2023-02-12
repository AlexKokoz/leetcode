package org.leetcode.contests.weekly.w0289;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String digitSum(String s, int k) {
		StringBuilder sb = new StringBuilder(s);
		while (sb.length() > k) {
			StringBuilder nsb = new StringBuilder();
			for (int i = 0; i < sb.length(); i += k) {
				int sum = 0;
				for (int j = i; j < Math.min(i + k, sb.length()); j++) {
					sum += sb.charAt(j) - '0';
				}
				nsb.append(sum);
			}
			sb = nsb;
		}
		return sb.toString();
	}
}
