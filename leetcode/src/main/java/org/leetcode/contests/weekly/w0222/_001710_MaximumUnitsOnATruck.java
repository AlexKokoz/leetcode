package org.leetcode.contests.weekly.w0222;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001710_MaximumUnitsOnATruck {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
		int ans = 0;

		for (int i = 0; i < boxTypes.length && 0 < truckSize;) {
			int take = Math.min(boxTypes[i][0], truckSize);
			ans += take * boxTypes[i][1];
			truckSize -= take;
			boxTypes[i][0] -= take;
			if (boxTypes[i][0] == 0)
				i++;
		}
		return ans;
	}
}
