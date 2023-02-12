package org.leetcode.contests.weekly.w0285;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public int[] longestRepeating(String s, String qs, int[] qis) {
		int n = s.length();
		char[] cs = s.toCharArray();
		int k = qs.length();
		int[] ans = new int[k];
		TreeMap<Integer, Integer> lengths = new TreeMap<>(); // lengths -> frequencies; we are interested in the
									// lastKey() value after each query

		// add current repeating substring lengths
		for (int r = 0; r < n;) {
			int l = r;
			while (r < n && cs[r] == cs[l])
				r++;
			add(r - l, lengths);
		}

		// positions for each character
		@SuppressWarnings("unchecked")
		TreeSet<Integer>[] poss = new TreeSet[26];
		for (int i = 0; i < 26; i++) {
			poss[i] = new TreeSet<>();
		}
		for (int i = 0; i < n; i++) {
			poss[cs[i] - 'a'].add(i);
		}

		for (int q = 0; q < k; q++) {

			int pos = qis[q];
			char newChar = qs.charAt(q);
			char oldChar = cs[pos];

			if (newChar != oldChar) {
				// first left position of a different character than cs[pos]
				int left = left(pos, cs, poss);
				// first right position of a different character than cs[pos]
				int right = right(pos, cs, poss);

				// remove this length
				remove(right - left - 1, lengths);

				// in case the old character extends to the left, add part's length
				if (left < pos - 1 && cs[pos - 1] == oldChar) {
					add(pos - left - 1, lengths);
				}
				// in case the old character extends to the right, add part's length
				if (pos + 1 < right && cs[pos + 1] == oldChar) {
					add(right - pos - 1, lengths);
				}

				// update string, remove position of old char, add position of new char
				cs[pos] = newChar;
				poss[oldChar - 'a'].remove(pos);
				poss[newChar - 'a'].add(pos);

				// first left position of a different character than newly updated cs[pos]
				left = left(pos, cs, poss);
				// first right position of a different character than newly updated cs[pos]
				right = right(pos, cs, poss);

				// in case the new character extends a repeating substring in its left, remove
				// the old length
				if (left < pos - 1) {
					remove(pos - left - 1, lengths);
				}

				// in case the new character extends a repeating substring in its right, remove
				// the old length
				if (pos + 1 < right) {
					remove(right - pos - 1, lengths);
				}

				// add length created by updated char
				add(right - left - 1, lengths);

			}
			ans[q] = lengths.lastKey();
		}

		return ans;

	}

	// find position of first different character on the left of pos; -1 if none
	static int left(int pos, char[] cs, TreeSet<Integer>[] poss) {
		if (pos == 0 || cs[pos - 1] != cs[pos])
			return pos - 1;
		int ans = -1;
		for (char c = 'a'; c <= 'z'; c++) {
			if (c == cs[pos])
				continue;
			Integer cand = poss[c - 'a'].lower(pos);
			if (cand != null)
				ans = Math.max(ans, cand);
		}
		return ans;
	}

	// find position of first different character on the right of pos; n if none
	static int right(int pos, char[] cs, TreeSet<Integer>[] poss) {
		int n = cs.length;
		if (pos == n - 1 || cs[pos + 1] != cs[pos])
			return pos + 1;
		int ans = n;
		for (char c = 'a'; c <= 'z'; c++) {
			if (c == cs[pos])
				continue;
			Integer cand = poss[c - 'a'].higher(pos);
			if (cand != null)
				ans = Math.min(ans, cand);
		}
		return ans;
	}

	// remove one length occurence
	static void remove(int length, TreeMap<Integer, Integer> lengths) {
		int count = lengths.get(length);
		count--;
		if (count == 0) {
			lengths.remove(length);
		} else {
			lengths.put(length, count);
		}
	}

	// add one length occurence
	static void add(int length, TreeMap<Integer, Integer> lengths) {
		lengths.put(length, lengths.getOrDefault(length, 0) + 1);
	}
}
