package org.leetcode.contests.weekly.w0169;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001307_VerbalArithmeticPuzzle {
	public boolean isSolvable(String[] words, String result) {
		final int[] acc = new int[26];
		final boolean[] st = new boolean[26];
		final int[] tens = new int[8];
		final Set<Character> set = new HashSet<>();
		final List<Character> uniq = new ArrayList<>();
		final boolean[] ans = new boolean[1];

		tens[0] = 1;
		for (int i = 1; i < tens.length; i++)
			tens[i] = tens[i - 1] * 10;

		final String[] nwords = new String[words.length + 1];
		for (int i = 0; i < words.length; i++)
			nwords[i] = words[i];
		nwords[nwords.length - 1] = result;

		for (int w = 0; w < nwords.length; w++) {
			for (int i = 0; i < nwords[w].length(); i++) {
				final char c = nwords[w].charAt(i);
				acc[c - 'A'] += (w == nwords.length - 1 ? -1 : 1) * tens[nwords[w].length() - 1 - i];
				set.add(c);
			}
			if (nwords[w].length() > 1)
				st[nwords[w].charAt(0) - 'A'] = true;
		}
		for (char c : set)
			uniq.add(c);
		Collections.sort(uniq);

		dfs(0, 0, 0, ans, acc, st, uniq);
		return ans[0];
	}

	static void dfs(int i, int used, int sum, boolean[] ans, int[] acc, boolean[] st, List<Character> uniq) {
		if (i == uniq.size()) {
			ans[0] |= sum == 0;
			return;
		} else {
			for (int j = 0; j < 10; j++) {
				if (((used >> j) & 1) > 0)
					continue;
				if (j == 0 && st[uniq.get(i) - 'A'])
					continue;
				dfs(i + 1, used | (1 << j), sum + j * acc[uniq.get(i) - 'A'], ans, acc, st, uniq);
			}
		}
	}

}
