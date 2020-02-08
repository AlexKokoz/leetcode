package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000003_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int[] count = new int[128];
		int start = 0;
		int end = 0;
		int max = 0;
		while (end < n) {
			char c = s.charAt(end);
			count[c]++;

			while (count[c] > 1) {
				char del = s.charAt(start);
				count[del]--;
				start++;
			}

			int cur = end - start + 1;
			max = Math.max(max, cur);

			end++;
		}
		return max;
	}

}
