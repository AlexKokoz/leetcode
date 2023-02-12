package org.leetcode.contests.weekly.w0273;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int[] executeInstructions(int n, int[] startPos, String s) {
		int m = s.length();
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			int j = i;
			int r = startPos[0], c = startPos[1];
			while (j < m) {
				char ch = s.charAt(j);
				switch (ch) {
				case 'L':
					c--;
					break;
				case 'R':
					c++;
					break;
				case 'U':
					r--;
					break;
				case 'D':
					r++;
					break;
				}
				if (r < 0 || c < 0 || r == n || c == n)
					break;
				j++;
			}
			ans[i] = j - i;
		}
		return ans;
	}
}
