package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000415_AddStrings {
	public String addStrings(String num1, String num2) {
		int n1 = num1.length();
		int n2 = num2.length();
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		for (int i = n1 - 1, j = n2 - 1; i >= 0 || j >= 0; i--, j--) {
			int d1 = (i >= 0 ? num1.charAt(i) - '0' : 0);
			int d2 = (j >= 0 ? num2.charAt(j) - '0' : 0);
			int sum = d1 + d2 + carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}
		if (carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
