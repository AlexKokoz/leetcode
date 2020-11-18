package org.leetcode.problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000139_WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<Integer> deadend = new HashSet<>();
		boolean[] inDict = new boolean[26];
		for (String word : wordDict)
			for (int i = 0; i < word.length(); i++)
				inDict[word.charAt(i) - 'a'] = true;
		boolean[] inS = new boolean[26];
		for (int i = 0; i < s.length(); i++)
			inS[s.charAt(i) - 'a'] = true;
		for (int i = 0; i < 26; i++)
			if (inS[i] && !inDict[i])
				return false;
		Collections.sort(wordDict, (a, b) -> b.length() - a.length());
		boolean[] found = new boolean[1];
		dfs(0, s, wordDict, found, deadend);
		return found[0];
	}

	void dfs(int i, String s, List<String> dict, boolean[] found, Set<Integer> deadend) {
		if (found[0] || deadend.contains(i))
			return;
		if (i == s.length()) {
			found[0] = true;
			return;
		}
		for (String word : dict) {
			if (equal(word, s, i)) {
				dfs(i + word.length(), s, dict, found, deadend);
			}
		}
		deadend.add(i);
	}

	boolean equal(String word, String s, int from) {
		if (from + word.length() > s.length())
			return false;
		for (int i = 0; i < word.length(); i++)
			if (s.charAt(from + i) != word.charAt(i))
				return false;
		return true;
	}
}
