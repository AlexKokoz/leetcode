package org.leetcode.contests.biweekly.bw0034;

import java.util.TreeMap;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001574_ShortestSubarrayToBeRemovedToMakeArraySorted {
	public int findLengthOfShortestSubarray(int[] arr) {
		int n = arr.length;
		int ans = n;

		// consider sorted prefix
		int i = 1;
		while (i < n && arr[i] >= arr[i - 1])
			i++;
		ans = Math.min(ans, n - i);
		if (ans == 0)
			return 0;

		// consider sorted suffix
		i = n - 2;
		while (i >= 0 && arr[i] <= arr[i + 1])
			i--;
		ans = Math.min(ans, i + 1);

		// consider sub-array to remove in the middle
		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(arr[0], 1);
		for (int j = 1; j < n && arr[j] >= arr[j - 1]; j++)
			map.put(arr[j], j + 1);

		for (int j = n - 1; j == n - 1 || (j >= 0 && arr[j] <= arr[j + 1]); j--) {
			Integer floor = map.floorKey(arr[j]);
			if (floor == null)
				break;
			int pref = map.get(floor);
			int cand = n - (pref + n - j);
			ans = Math.min(ans, cand);
		}

		return ans;
	}
}
