package org.leetcode.contests.weekly.w0293;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public List<String> removeAnagrams(String[] words) {
		List<String> ans = new ArrayList<>();
		int n = words.length;
		for (int l = 0; l < n;) {
			int r = l + 1;
			while (r < n && same(words[l], words[r])) {
				r++;
			}
			ans.add(words[l]);
			l = r;
		}
		return ans;
	}

	boolean same(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);

		return Arrays.equals(c1, c2);
	}
}
