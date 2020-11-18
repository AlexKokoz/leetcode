package org.leetcode.contests.weekly.w0211;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001624_LargestSubstringBetweenTwoEqualCharacters {
	public int maxLengthBetweenEqualCharacters(String s) {
		int[] last = new int[26];
		Arrays.fill(last, -1);
		int max = -1;
		for(int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - 'a';
			if (last[c] < 0) last[c] = i;
			else max = Math.max(max, i - last[c] - 1);
		}
		return max;
	}
}
