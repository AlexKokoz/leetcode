package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001408_StringMatchingInAnArray {
	public List<String> stringMatching(String[] words) {
		int n = words.length;
		List<String> ans = new LinkedList<>();
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String a, String b) {
				return a.length() - b.length();
			}
		});
		outer: for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (words[j].indexOf(words[i]) != -1) {
					ans.add(words[i]);
					continue outer;
				}
		return ans;
	}	
}
