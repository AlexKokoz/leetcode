package org.leetcode.contests.weekly.w0329;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public boolean makeStringsEqual(String s, String target) {
		int n = s.length();
		int op10 = 0;
		int op01 = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == '1' && target.charAt(i) == '0') {
				op10++;
			} else if (s.charAt(i) == '0' && target.charAt(i) == '1') {
				op01++;
			} else if (s.charAt(i) == '1' && target.charAt(i) == '1') {
				return true;
			}
		}
		return (op10 == 0 && op01 == 0) || (op10 > 0 && op01 > 0);
	}
}
