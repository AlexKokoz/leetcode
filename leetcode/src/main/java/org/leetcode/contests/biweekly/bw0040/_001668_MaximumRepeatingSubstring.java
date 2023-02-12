package org.leetcode.contests.biweekly.bw0040;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001668_MaximumRepeatingSubstring {
	public int maxRepeating(String sequence, String word) {
		int ns = sequence.length();
		int nw = word.length();
		int ans = 0;
		if (nw > ns)
			return ans;
		for (int i = 0; i <= ns - nw; i++) {
			int cand = 0;
			int j = i;
			while (j + nw <= ns && eq(sequence, j, word)) {
				System.out.println("!");
				cand++;
				j += nw;
			}
			if (j > i)
				i = j - 1;
			System.out.println(i + " " + cand);
			ans = Math.max(ans, cand);
		}
		return ans;
	}

	boolean eq(String src, int i, String pat) {
		for (int start = i; start < i + pat.length(); start++) {
			if (src.charAt(start) != pat.charAt(start - i))
				return false;
		}
		return true;
	}
}
