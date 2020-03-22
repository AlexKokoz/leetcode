package org.leetcode.contests.biweekly.bw0022;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001385_FindTheDistanceValueBetweenTwoArrays {
	public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
		int ans = 0;
		outer: for (int x : arr1) {
			for (int y : arr2) {
				if (Math.abs(x - y) <= d)
					continue outer;
			}
			ans++;
		}
		return ans;
	}
}
