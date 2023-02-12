package org.leetcode.contests.biweekly.bw0066;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int minimumBuckets(String street) {
		int n = street.length();
		int ans = 0;
		int i = 0;
		while (i < n) {
			if (street.charAt(i) == '.') {
				i++;
				continue;
			}
			if ((i == 0 || street.charAt(i - 1) != '.') && (i == n - 1 || street.charAt(i + 1) != '.'))
				return -1;
			if (i + 1 < n && street.charAt(i + 1) == '.') {
				ans++;
				i += 2;
				if (i < n && street.charAt(i) == 'H') {
					i++;
				}
			} else {
				i++;
				ans++;
			}
		}
		return ans;
	}
}
