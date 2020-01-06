package org.leetcode.contests.biweekly.bw0016;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001299_ReplaceElementsWithGreatestElementOnRightSide {
	public int[] replaceElements(int[] arr) {
		final int n = arr.length;
        if (n == 0) return new int[0];
		final int[] max = new int[n];
		max[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			max[i] = Math.max(max[i + 1], arr[i]);
		for (int i = 0; i < n - 1; i++) {
			arr[i] = max[i + 1];
		}
		arr[n - 1] = -1;
		return arr;
	}
}
