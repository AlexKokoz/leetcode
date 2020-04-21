package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000000_PerformStringShifts {
	public String stringShift(String s, int[][] shift) {
		int n = s.length();
		int totalShift = 0;
		for (int i = 0; i < shift.length; i++) {
			if (shift[i][0] == 0) // left - subtract from total shift
				totalShift -= shift[i][1];
			else // if (shift[i][0] == 1) // right - add to total shift
				totalShift += shift[i][1];
		}
		totalShift %= n; // clear whole cycles
		if (totalShift == 0)
			return s; // no shift
		char[] chars = new char[n];
		int start = totalShift > 0 ? n - totalShift : -totalShift;
		for (int i = 0; i < n; i++) {
			chars[i] = s.charAt(start);
			start = (start + 1) % n;
		}
		return String.valueOf(chars);
	}
}
