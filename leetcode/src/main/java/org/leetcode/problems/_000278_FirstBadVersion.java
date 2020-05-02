package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */

public class _000278_FirstBadVersion {
	boolean isBadVersion(int version) {
		return true;
	}

	public int firstBadVersion(int n) {
		int bad = n;
		int lo = 1;
		int hi = n;
		while (lo <= hi) {
			int mi = lo + (hi - lo >>> 1);
			if (isBadVersion(mi)) {
				hi = mi - 1;
				bad = Math.min(bad, mi);
			} else {
				lo = mi + 1;
			}
		}
		return bad;
	}
}
