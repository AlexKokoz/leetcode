package org.leetcode.contests.biweekly.bw0014;

/**
 * EASY
 * 
 * @author AccelSprinter
 *
 */
class Solution {

	public String toHexspeak(String num) {
		final long n = Long.parseLong(num);
		final String hex = Long.toHexString(n).toUpperCase();
		final char[] chars = hex.toCharArray();
		final String invalid = "23456789";
		for (int i = 0; i < hex.length(); i++) {
			if (invalid.indexOf(hex.charAt(i)) > -1) {
				return "ERROR";
			}
			if (chars[i] == '1')
				chars[i] = 'I';
			else if (chars[i] == '0')
				chars[i] = 'O';
		}
		return String.valueOf(chars);
	}

}
