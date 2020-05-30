package org.leetcode.contests.biweekly.bw0027;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001460_MakeTwoArraysEqualByReversingSubarrays {
	public boolean canBeEqual(int[] target, int[] arr) {
		int[] ct = new int[1001];
		for (int x  :target) {
			ct[x]++;
		}
		for (int x : arr) {
			ct[x]--;
			if (ct[x] < 0) return false;
		}
		return true;
	}
}
