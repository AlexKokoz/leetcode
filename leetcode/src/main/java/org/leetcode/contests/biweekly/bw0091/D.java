package org.leetcode.contests.biweekly.bw0091;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public String[] splitMessage(String message, int limit) {
		int n = message.length();

		int lo = 1;
		int hi = n;
		int nParts = 0;

		while (lo <= hi) {
			int mi = lo + (hi - lo) / 2;
			if (ok(message, limit, mi)) {
				nParts = mi;
				hi = mi - 1;
			} else {
				lo = mi + 1;
			}
		}

		String[] ans = split(message, limit, nParts);
		return ans;
	}

	boolean ok(String s, int limit, int cand) {
		int n = s.length();
		int have = cand * limit;
		int need = cand * 3 + Integer.toString(cand).length() * cand;
		for (int p10 = 1; p10 <= cand; p10 *= 10) {
			need += Integer.toString(p10).length() * (Math.min(p10 * 10, cand + 1) - p10);
		}
		int rem = have - need;
		return n <= rem;
	}

	String[] split(String msg, int limit, int nParts) {
		int n = msg.length();
		String[] ret = new String[nParts];
		for (int i = 0, p = 1; p <= nParts; p++) {
			String suff = "<" + p + "/" + nParts + ">";
			int len = Math.min(limit - suff.length(), n - i);
			ret[p - 1] = msg.substring(i, i + len) + suff;
			i += len;
		}
		return ret;
	}
}
