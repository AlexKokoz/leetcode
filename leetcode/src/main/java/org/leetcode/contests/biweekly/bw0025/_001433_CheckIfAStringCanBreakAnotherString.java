package org.leetcode.contests.biweekly.bw0025;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001433_CheckIfAStringCanBreakAnotherString {
	public boolean checkIfCanBreak(String s1, String s2) {
		int n = s1.length();
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		int score1 = 0;
		int score2 = 0;
		for (int i = 0; i < n; i++) {
			if (c1[i] > c2[i])
				score1++;
			else if (c2[i] > c1[i])
				score2++;
		}
		if (score1 == 0 || score2 == 0)
			return true;
		else
			return false;
	}
}
