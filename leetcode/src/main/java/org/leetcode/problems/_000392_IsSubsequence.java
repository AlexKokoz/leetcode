package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000392_IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int nt = t.length();
		int ns = s.length();
		int it = 0;
		int is = 0;
		while (it < nt && is < ns) {
			char ct = t.charAt(it);
			char cs = s.charAt(is);
			if (ct == cs)
				is++;
			it++;
		}
		return is == ns;
	}
}
