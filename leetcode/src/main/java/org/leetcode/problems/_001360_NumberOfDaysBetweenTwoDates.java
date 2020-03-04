package org.leetcode.problems;

import java.time.Duration;
import java.time.LocalDate;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001360_NumberOfDaysBetweenTwoDates {
	public int daysBetweenDates(String s1, String s2) {
		int y1 = Integer.parseInt(s1.substring(0, 4));
		int m1 = Integer.parseInt(s1.substring(5, 7));
		int d1 = Integer.parseInt(s1.substring(8, 10));
		int y2 = Integer.parseInt(s2.substring(0, 4));
		int m2 = Integer.parseInt(s2.substring(5, 7));
		int d2 = Integer.parseInt(s2.substring(8, 10));
		return daysBetween(y1, m1, d1, y2, m2, d2);
	}

	int daysBetween(int y1, int m1, int d1, int y2, int m2, int d2) {
		final LocalDate date1 = LocalDate.of(y1, m1, d1);
		final LocalDate date2 = LocalDate.of(y2, m2, d2);
		return (int) Math.abs(Duration.between(date1.atStartOfDay(), date2.atStartOfDay()).toDays());
	}
}
