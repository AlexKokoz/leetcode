package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000067_AddBinary {
	public String addBinary(String a, String b) {
		int na = a.length();
		int nb = b.length();
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = na - 1, j = nb - 1; i >= 0 || j >= 0; i--, j--) {
			int d1 = (i >= 0 ? a.charAt(i) - '0' : 0);
			int d2 = (j >= 0 ? b.charAt(j) - '0' : 0);
			int sum = d1 + d2 + carry;
			sb.append(sum % 2);
			carry = sum > 1 ? 1 : 0;
		}
		if (carry > 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
