package org.leetcode.contests.biweekly.bw0031;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001523_CountOddNumbersInAnIntervalRange {
	public int countOdds(int low, int high) {
		if (low % 2 == 0 && high % 2 == 0) return (high - low) / 2; // both even
		return (high - low) / 2 + 1;                                // all other cases
	}
}
