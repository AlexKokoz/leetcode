package org.leetcode.contests.weekly.w0321;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int appendCharacters(String s, String t) {
		int ns = s.length(), nt = t.length();
		int it = 0;
		for (int is = 0; is < ns && it < nt; is++) {
			if (s.charAt(is) == t.charAt(it)) {
				it++;
			}
		}
		return nt - it;
	}
}
