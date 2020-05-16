package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000402_RemoveKDigits {
	public String removeKdigits(String num, int k) {
		int n = num.length();
		if (n == k)
			return "0";
		StringBuilder sb = new StringBuilder(num);
		for (int i = 0; i < k; i++) {
			int j = 0;
			while (j < sb.length() - 1 && sb.charAt(j) <= sb.charAt(j + 1)) {
				j++;
			}
			sb.deleteCharAt(j);
		}
		for (int i = 0; i < sb.length() && sb.charAt(i) == '0';) {
			sb.deleteCharAt(i);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}
}
