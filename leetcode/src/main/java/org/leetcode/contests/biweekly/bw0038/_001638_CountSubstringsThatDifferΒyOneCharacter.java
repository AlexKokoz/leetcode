package org.leetcode.contests.biweekly.bw0038;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001638_CountSubstringsThatDifferΒyOneCharacter {

	public int countSubstrings(String s, String t) {
		int ns = s.length();
		int nt = t.length();
		int ans = 0;
		for (int is = 0; is < ns; is++) {
			for (int it = 0; it < nt; it++) {
				int diff = 0;
				for (int j = 0; diff < 2 && is + j < ns && it + j < nt; j++) {
					if (s.charAt(is + j) != t.charAt(it + j))
						diff++;
					if (diff == 1)
						ans++;
				}
			}
		}
		return ans;
	}

}
