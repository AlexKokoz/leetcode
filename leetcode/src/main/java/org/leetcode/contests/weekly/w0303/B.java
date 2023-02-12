package org.leetcode.contests.weekly.w0303;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int equalPairs(int[][] grid) {
		int ans = 0;
		int n = grid.length;
		Map<String, Integer> map = new HashMap<>();
		for (int[] row : grid) {
			StringBuilder sb = new StringBuilder();
			for (int num : row)
				sb.append(num).append(",");
			String key = sb.toString();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		for (int c = 0; c < n; c++) {
			StringBuilder sb = new StringBuilder();
			for (int r = 0; r < n; r++) {
				sb.append(grid[r][c]).append(",");
			}
			String key = sb.toString();
			ans += map.getOrDefault(key, 0);
		}
		return ans;
	}
}
