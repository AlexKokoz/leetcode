package org.leetcode.contests.weekly.w0306;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	String ans;

	public String smallestNumber(String pattern) {
		boolean[] used = new boolean[10];
		char[] chars = new char[pattern.length() + 1];
		for (int i = 1; i <= 9; i++) {
			chars[0] = (char) (i + '0');
			used[i] = true;
			dfs(1, pattern, chars, used);
			used[i] = false;
		}
		return ans;
	}

	void dfs(int d, String pattern, char[] chars, boolean[] used) {
		if (d == chars.length) {
			String cand = String.valueOf(chars);
			if (ans == null || cand.compareTo(ans) < 0) {
				ans = cand;
			}
			return;
		}
		if (pattern.charAt(d - 1) == 'I') {
			for (int i = chars[d - 1] - '0' + 1; i <= 9; i++) {
				if (used[i])
					continue;
				chars[d] = (char) (i + '0');
				used[i] = true;
				dfs(d + 1, pattern, chars, used);
				used[i] = false;
			}
		} else {
			for (int i = chars[d - 1] - '0' - 1; i >= 1; i--) {
				if (used[i])
					continue;
				chars[d] = (char) (i + '0');
				used[i] = true;
				dfs(d + 1, pattern, chars, used);
				used[i] = false;
			}

		}
	}

}
