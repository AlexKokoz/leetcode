package org.leetcode.contests.biweekly.bw0021;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001371_FindTheLongestSubstringContainingVowelsInEvenCounts {
	public int findTheLongestSubstring(String s) {
		String vowels = "aeiou";
		int n = s.length();
		int[] masks = new int[n + 1];
		int[] first = new int[(1 << vowels.length())]; // 32
		int[] last = new int[(1 << vowels.length())]; // 32
		int max = 0;

		for (int i = 0; i < n; i++) {
			int pos = vowels.indexOf(s.charAt(i));
			if (pos == -1)
				masks[i + 1] = masks[i];
			else
				masks[i + 1] = masks[i] ^ (1 << pos);
		}
		Arrays.fill(first, n);
		for (int i = 0; i < masks.length; i++) {
			first[masks[i]] = Math.min(first[masks[i]], i);
			last[masks[i]] = i;
		}		
		for (int i = 0; i < first.length; i++)
			max = Math.max(max, last[i] - first[i]);
		return max;
	}

}
