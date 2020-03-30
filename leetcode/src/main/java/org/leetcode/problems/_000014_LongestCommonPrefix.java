package org.leetcode.problems;

/**
 * EASY
 * 
 * @author akokozidis
 *
 */
public class _000014_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int minLength = Integer.MAX_VALUE;
		for (String s : strs)
			minLength = Math.min(minLength, s.length());
		int l = 0;
		outer: for (; l < minLength; l++) {
			for (int i = 0; i < strs.length; i++) {
				if (i > 0) {
					if (strs[i].charAt(l) != strs[i - 1].charAt(l)) {
						break outer;
					}
				}
			}
		}
		return strs.length == 0 ? "" : strs[0].substring(0, l);
	}
}
