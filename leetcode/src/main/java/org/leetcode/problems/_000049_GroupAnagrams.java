package org.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000049_GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			String sSorted = countSort(s);
			List<String> list = map.getOrDefault(sSorted, new LinkedList<>());
			list.add(s);
			map.put(sSorted, list);
		}
		List<List<String>> ans = new LinkedList<>(map.values());
		return ans;
	}

	// only lowercase considered
	String countSort(String s) {
		final int RADIX = 26;
		StringBuilder sb = new StringBuilder();
		int[] freq = new int[RADIX];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < RADIX; i++)
			for (int count = 0; count < freq[i]; count++)
				sb.append((char) ('a' + i));
		return sb.toString();
	}
}
