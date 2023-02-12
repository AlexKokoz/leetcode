package org.leetcode.contests.biweekly.bw0080;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public boolean strongPasswordCheckerII(String pw) {
		int n = pw.length();
		if (n < 8)
			return false;
		char[] cs = pw.toCharArray();
		String special = "!@#$%^&*()-+";
		boolean hasLower = false, hasUpper = false, hasSpecial = false, hasDigit = false;
		for (int i = 0; i < n; i++) {
			if (Character.isDigit(cs[i]))
				hasDigit = true;
			if (Character.isLowerCase(cs[i]))
				hasLower = true;
			if (Character.isUpperCase(cs[i]))
				hasUpper = true;
			if (special.indexOf(cs[i]) >= 0)
				hasSpecial = true;
			if (i > 0 && cs[i] == cs[i - 1])
				return false;
		}
		return hasLower && hasUpper && hasSpecial && hasDigit;
	}
}
