package org.leetcode.contests.weekly.w0206;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001585_CheckIfStringIsTransformableWithSubstringSortOperations {
	public boolean isTransformable(String s, String t) {
		int n = s.length();
		int[] f = new int[10];
		for (int i = 0; i < n; i++)
			f[s.charAt(i) - '0']++;
		for (int i = 0; i < n; i++) {
			int c = t.charAt(i) - '0';
			f[c]--;
			if (f[c] < 0)
				return false;
		}

		int[] count = new int[10];
		int[] greaterInLeftS = new int[n];
		for (int i = 0; i < n; i++) {
			int d = s.charAt(i) - '0';
			greaterInLeftS[i] = count[d];
			for (int dd = 0; dd < d; dd++)
				count[dd]++;
		}
		count = new int[10];
		int[] greaterInLeftT = new int[n];
		for (int i = 0; i < n; i++) {
			int d = t.charAt(i) - '0';
			greaterInLeftT[i] = count[d];
			if (greaterInLeftT[i] > greaterInLeftS[i]) 
				return false;
			for (int dd = 0; dd < d; dd++)
				count[dd]++;
		}

		return true;
	}
}
