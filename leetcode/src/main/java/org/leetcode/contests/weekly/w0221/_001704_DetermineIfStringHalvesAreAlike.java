package org.leetcode.contests.weekly.w0221;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001704_DetermineIfStringHalvesAreAlike {
	public boolean halvesAreAlike(String s) {
		int n = s.length();
		s = s.toLowerCase();
		String vowels = "aeiou";
		int count = 0;
		for (int i = 0; i < n; i++) {

			if (vowels.indexOf(s.charAt(i)) >= 0) {
				if (i < n / 2)
					count++;
				else
					count--;
			}
		}
		return count == 0;
	}
}
