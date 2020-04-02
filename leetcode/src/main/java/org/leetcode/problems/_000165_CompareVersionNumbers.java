package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000165_CompareVersionNumbers {
	public int compareVersion(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		int i1 = 0;
		int i2 = 0;
		while (i1 < n1 || i2 < n2) {
			int[] ans1 = getCurrentLevelRevision(s1, i1);
			int rev1 = ans1[0];
			i1 = ans1[1];
			int[] ans2 = getCurrentLevelRevision(s2, i2);
			int rev2 = ans2[0];
			i2 = ans2[1];
			if (rev1 > rev2)
				return 1;
			else if (rev1 < rev2)
				return -1;
		}
		return 0;
	}

	int[] getCurrentLevelRevision(String s, int start) {
		if (start >= s.length())
			return new int[] { 0, start };
		int n = 0;
		while (start < s.length() && s.charAt(start) != '.') {
			n = n * 10 + (s.charAt(start) - '0');
			start++;
		}
		start++;
		return new int[] { n, start };
	}
}
