package org.leetcode.contests.weekly.w0295;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int rearrangeCharacters(String s, String target) {
		int ans = 0;
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		boolean ok = true;
		outer: while (ok) {
			ok = false;
			for (int i = 0; i < target.length(); i++) {
				if (count[target.charAt(i) - 'a'] == 0)
					continue outer;
				count[target.charAt(i) - 'a']--;
			}
			ans++;
			ok = true;
		}
		return ans;
	}
}
