package org.leetcode.contests.biweekly.bw0097;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {

	public int maximizeWin(int[] poss, int k) {
		int ans = 0;
		int n = poss.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int pos : poss) {
			map.put(pos, map.getOrDefault(pos, 0) + 1);
		}
		if (k == 0) {
			if (n == 1)
				return 1;
			List<Integer> values = map.values().stream().collect(Collectors.toList());
			Collections.sort(values);
			return values.get(values.size() - 1) + values.get(values.size() - 1);
		}
		int[] dp = new int[n + 1];
		for (int r = 0; r < n; r++) {
			int l = r;
			int lo = 0;
			int hi = r - 1;
			while (lo <= hi) {
				int mi = lo + (hi - lo) / 2;
				if (poss[r] - poss[mi] <= k) {
					hi = mi - 1;
					l = mi;
				} else {
					lo = mi + 1;
				}
			}
			int prizes = r - l + 1;
			dp[r + 1] = Math.max(dp[r], prizes);
			int cand = prizes + dp[l];
			ans = Math.max(ans, cand);
		}
		return ans;
	}

}
