package org.leetcode.contests.weekly.w0215;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001657_DetermineIfTwoStringsAreClose {
	public boolean closeStrings(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		if (n1 != n2)
			return false;
		int[] f1 = new int[26];
		int[] f2 = new int[26];
		for (int i = 0; i < n1; i++)
			f1[s1.charAt(i) - 'a']++;
		for (int i = 0; i < n2; i++)
			f2[s2.charAt(i) - 'a']++;
		for (int i = 0; i < f1.length; i++)
			if ((f1[i] == 0 && f2[i] != 0) || (f1[i] != 0 && f2[i] == 0))
				return false;
		Arrays.sort(f1);
		Arrays.sort(f2);
		for (int i = 0; i < f1.length; i++)
			if (f1[i] != f2[i])
				return false;
		return true;
	}
}
