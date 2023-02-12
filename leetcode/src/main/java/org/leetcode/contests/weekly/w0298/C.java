package org.leetcode.contests.weekly.w0298;

import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int longestSubsequence(String s, int k) {
		int ns = s.length();
		String bin = Integer.toBinaryString(k);
		int nb = bin.length();
		if (ns < nb) {
			return ns;
		}
		@SuppressWarnings("unchecked")
		TreeSet<Integer>[] poss = new TreeSet[2];
		for (int i = 0; i < poss.length; i++)
			poss[i] = new TreeSet<>();
		for (int i = 0; i < ns; i++) {
			poss[s.charAt(i) - '0'].add(i);
		}
		int ans = 0;
		for (int i = 0; i < ns; i++) {
			if (s.charAt(i) == '0')
				ans++;
		}
		outer: for (int len = nb, z = ns - 1; len > 0; len--) {
			if (len < nb && bin.charAt(len) == '0')
				continue;
			while (len != nb && z >= 0) {
				if (s.charAt(z) == '0' && ns - z >= nb - len)
					break;
				z--;
			}
			if (z < 0)
				break;
			Integer pos = len == nb ? ns : z;
			for (int b = len - 1; b >= 0; b--) {
				pos = poss[bin.charAt(b) - '0'].lower(pos);
				if (pos == null) {
					continue outer;
				}
			}
			int zeros = 0;
			for (int i = pos - 1; i >= 0; i--) {
				if (s.charAt(i) == '0')
					zeros++;
			}
			ans = Math.max(ans, nb + zeros);
		}
		int zeros = 0;
		for (int i = ns - nb; i >= 0; i--) {
			if (s.charAt(i) == '0')
				zeros++;
		}
		ans = Math.max(ans, nb - 1 + zeros);
		return ans;
	}
}
