package org.leetcode.contests.weekly.w0273;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public boolean isSameAfterReversals(int num) {
		if (num == 0)
			return true;
		char[] s = Integer.toString(num).toCharArray();
		if (s[s.length - 1] == '0')
			return false;
		return true;
	}
}
