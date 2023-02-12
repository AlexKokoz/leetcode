package org.leetcode.contests.biweekly.bw0079;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public boolean digitCount(String num) {
		int[] count = new int[10];
		int n = num.length();
		for (int i = 0; i < n; i++) {
			count[num.charAt(i) - '0']++;
		}
		for (int i = 0; i < n; i++) {
			if (count[i] != num.charAt(i) - '0')
				return false;
		}
		return true;
	}
}
