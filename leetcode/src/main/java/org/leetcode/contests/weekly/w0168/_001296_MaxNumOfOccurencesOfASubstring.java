package org.leetcode.contests.weekly.w0168;

import java.util.HashMap;
import java.util.Map;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001296_MaxNumOfOccurencesOfASubstring {
	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		final int n = s.length();
		final int[][] pre = new int[26][n + 1];
		for (int i = 0; i < n; i++) {
			final char c = s.charAt(i);
			pre[c - 'a'][i + 1]++;
			for (int j = 0; j < 26; j++) {
				pre[j][i + 1] += pre[j][i];
			}
		}

		Map<Integer, Integer> map = new HashMap<>();
		for (int start = 0; start <= n - minSize; start++) {
			int unique = 0;
			final int end = start + minSize - 1;
			for (int k = 0; k < 26; k++) {
				if (pre[k][end + 1] - pre[k][start] > 0)
					unique++;
			}
			if (unique <= maxLetters) {
				int hash = hash(s.substring(start, end+1));
				if (map.containsKey(hash))
					map.put(hash, map.get(hash) + 1);
				else
					map.put(hash, 1);
			}
			
		}
		int max = 1;
		for (int key : map.keySet()) {
			if (map.get(key) > max)
				max = map.get(key);
		}
		return max;
	}

	int hash(String s) {
		int p = 31;
		int m = 1000000009;
		int hash_value = 0;
		int p_pow = 1;
		for (int i = 0; i < s.length(); i++) {
			final char c = s.charAt(i);
			hash_value = (hash_value + (c - 'a' + 1) * p_pow) % m;
			p_pow = (p_pow * p) % m;
		}
		return hash_value;
	}
}
