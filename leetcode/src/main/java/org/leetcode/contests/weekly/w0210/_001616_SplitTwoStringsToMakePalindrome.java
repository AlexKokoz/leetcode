package org.leetcode.contests.weekly.w0210;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001616_SplitTwoStringsToMakePalindrome {
	public boolean checkPalindromeFormation(String a, String b) {
		String ar = new StringBuilder(a).reverse().toString();
		String br = new StringBuilder(b).reverse().toString();
		return check(a, a) || check(b, b) || check(a, b) || check(b, a) || check(br, ar) || check(ar, br);
	}

	boolean check(String a, String b) {
		int n = a.length();
		boolean switched = false;
		for (int i = 0, j = n - 1; i < j;) {
			int ca = switched ? b.charAt(i) : a.charAt(i);
			int cb = b.charAt(j);
			if (ca == cb) {
				i++;
				j--;
			} else if (!switched) {
				switched = true;
			} else {
				return false;
			}
		}
		return true;
	}

}
