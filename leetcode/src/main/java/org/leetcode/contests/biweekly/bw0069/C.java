package org.leetcode.contests.biweekly.bw0069;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int longestPalindrome(String[] words) {
		int ans = 0;
		int[][] cs = new int[26][26];
		for (String w : words) {
			cs[w.charAt(0) - 'a'][w.charAt(1) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			for (int j = i; j < 26; j++) {
				if (i == j) {
					int add = cs[i][i];
					if (add % 2 == 1)
						add--;
					ans += 2 * add;
				} else {
					int add = Math.min(cs[i][j], cs[j][i]);
					ans += 4 * add;
				}
			}
		}
		for (int i = 0; i < 26; i++) {
			if (cs[i][i] % 2 == 1) {
				ans += 2;
				break;
			}
		}
		return ans;
	}

}
