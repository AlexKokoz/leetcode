package org.leetcode.contests.weekly.w0326;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int minimumPartition(String s, int k) {
		int ans = 0;
		int n = s.length();
		for (int i = 0; i < n;) {
			int j = i;
			long num = 0;
			while (j < n && num * 10 + (s.charAt(j) - '0') <= k) {
				num = num * 10 + (s.charAt(j) - '0');
				j++;
			}
			if (i == j)
				return -1;
			ans++;
			i = j;
		}
		return ans;
	}
}
