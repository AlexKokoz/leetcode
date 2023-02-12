package org.leetcode.contests.weekly.w0227;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001754_LargestMergeOfTwoStrings {
	public String largestMerge(String word1, String word2) {
		int n1 = word1.length();
		int n2 = word2.length();
		StringBuilder sb = new StringBuilder();
		int i, j;
		for (i = 0, j = 0; i < n1 && j < n2;) {
			int k, l;
			for (k = i, l = j; k < n1 && l < n2 && word1.charAt(l) == word2.charAt(k); k++, l++)
				;
			if (k == n1)
				sb.append(word2.charAt(j++));
			else if (l == n2)
				sb.append(word1.charAt(i++));
			else if (word1.charAt(k) > word2.charAt(l))
				sb.append(word1.charAt(i++));
			else
				sb.append(word2.charAt(j++));
		}

		while (i < n1) {
			sb.append(word1.charAt(i++));
		}
		while (j < n2) {
			sb.append(word2.charAt(j++));
		}

		return sb.toString();
	}
}
