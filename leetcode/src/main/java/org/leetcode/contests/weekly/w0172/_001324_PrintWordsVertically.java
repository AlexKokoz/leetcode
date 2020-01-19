package org.leetcode.contests.weekly.w0172;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001324_PrintWordsVertically {
	public List<String> printVertically(String s) {
		List<String> ans = new LinkedList<>();
		String[] words = s.split(" ");

		/*
		 * The number of rows will be the max word length.
		 */
		int max = 0;
		for (String word : words)
			max = Math.max(max, word.length());

		/*
		 * Calculate whitespace paddings for each word.
		 */
		int[] padding = new int[s.length()];
		for (int i = 0; i < words.length; i++) {
			padding[i] = max - words[i].length();
		}

		StringBuilder[] sb = new StringBuilder[max];
		for (int i = 0; i < sb.length; i++)
			sb[i] = new StringBuilder();

		/*
		 * Add each letter of the current word to its corresponding row. Resume by
		 * padding with whitespace
		 */
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int j;
			for (j = 0; j < word.length(); j++) {
				sb[j].append(word.charAt(j));
			}
			for (int k = 0; k < padding[i]; k++) {
				sb[j + k].append(' ');
			}
		}

		/*
		 * Delete trailing whitespace.
		 */
		for (StringBuilder nsb : sb) {
			while (nsb.charAt(nsb.length() - 1) == ' ')
				nsb.deleteCharAt(nsb.length() - 1);
			ans.add(nsb.toString());
		}

		return ans;
	}
}
