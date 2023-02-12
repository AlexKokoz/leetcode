package org.leetcode.contests.biweekly.bw0090;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String oddString(String[] words) {
		Map<String, Integer> count = new HashMap<>();
		Map<String, String> word = new HashMap<>();
		int n = words.length;
		int m = words[0].length();
		for (int i = 0; i < n; i++) {
			int[] diff = new int[m - 1];
			for (int j = 1; j < m; j++) {
				diff[j - 1] = words[i].charAt(j) - words[i].charAt(j - 1);
			}
			String key = Arrays.toString(diff);
			count.put(key, count.getOrDefault(key, 0) + 1);
			word.put(key, words[i]);
		}
		for (String key : count.keySet()) {
			if (count.get(key) == 1) {
				return word.get(key);
			}
		}
		return null;
	}
}
