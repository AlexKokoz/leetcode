package org.leetcode.contests.weekly.w0309;

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
	public int numberOfWays(int start, int end, int k) {
		if (start > end) {
			int swap = start;
			start = end;
			end = swap;
		}
		if (end - start > k)
			return 0;
		int offset = 1001;
		start += offset;
		end += offset;
		Map<Long, Long> memo = new HashMap<>();
		return (int) dp(start, k, end, memo);
	}

	long dp(int now, int have, int end, Map<Long, Long> memo) {
		long mod = 1000000007;
		if (Math.abs(end - now) > have)
			return 0;
		if (have == 0) {
			if (now == end) {
				return 1;
			}
			return 0;
		}
		long key = (long) now << 32 | have;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		long val = (dp(now - 1, have - 1, end, memo) + dp(now + 1, have - 1, end, memo)) % mod;
		memo.put(key, val);
		return val;
	}
}
