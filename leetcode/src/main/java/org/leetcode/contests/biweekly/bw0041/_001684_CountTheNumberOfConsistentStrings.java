package org.leetcode.contests.biweekly.bw0041;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001684_CountTheNumberOfConsistentStrings {
	public int countConsistentStrings(String allowed, String[] words) {
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < allowed.length(); i++)
			set.add(allowed.charAt(i));
		int ans = 0;
		outer: for (String word : words) {
			for (int i = 0; i < word.length(); i++)
				if (!set.contains(word.charAt(i)))
					continue outer;
			ans++;
		}
		return ans;
	}
}
