package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001451_RearrangeWordsInASentence {
	public String arrangeWords(String text) {
		text = text.toLowerCase();
		String[] words = text.split(" ");
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});
		StringBuilder sb = new StringBuilder();
		String sep = "";
		for (String word : words) {
			sb.append(sep + word);
			sep = " ";
		}
		String ans = sb.toString();
		ans = ans.substring(0, 1).toUpperCase() + ans.substring(1);
		return ans;
	}
}
