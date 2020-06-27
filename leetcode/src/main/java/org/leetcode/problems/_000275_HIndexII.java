package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000275_HIndexII {
	public int hIndex(int[] citations) {
		int n = citations.length;
		int lo = 0;
		int hi = n - 1;
		int ans = 0;
		while (lo <= hi) {
			int mi = lo + (hi - lo >> 1);
			int ct = n - mi;
			if (citations[mi] < ct)
				lo = mi + 1;
			else if (citations[mi] > ct) {
				hi = mi - 1;
				ans = Math.max(ans, ct);
			} else {
				return citations[mi];
			}
		}
		return ans;
	}
}
