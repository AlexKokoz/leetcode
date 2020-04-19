package org.leetcode.contests.weekly.w0185;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001419_MinimumNumberOfFrogsCroaking {
	public int minNumberOfFrogs(String croakOfFrogs) {
		int n = croakOfFrogs.length();
		int[] f = new int[257];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			char c = croakOfFrogs.charAt(i);
			f[c]++;
			if (f['c'] < f['r'] || f['r'] < f['o'] || f['o'] < f['a'] || f['a'] < f['k'])
				return -1;
			ans = Math.max(ans, f['c']);
			ans = Math.max(ans, f['r']);
			ans = Math.max(ans, f['o']);
			ans = Math.max(ans, f['a']);
			ans = Math.max(ans, f['k']);
			if (c == 'k') {
				f['c']--;
				f['r']--;
				f['o']--;
				f['a']--;
				f['k']--;
			}
		}
		if (f['c'] != 0 || f['r'] != 0 || f['o'] != 0 || f['a'] != 0 || f['k'] != 0)
			return -1;
		return ans;
	}
}
