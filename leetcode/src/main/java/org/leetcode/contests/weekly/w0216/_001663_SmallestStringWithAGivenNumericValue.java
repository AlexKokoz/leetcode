package org.leetcode.contests.weekly.w0216;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001663_SmallestStringWithAGivenNumericValue {
	public String getSmallestString(int n, int k) {
		char[] ans = new char[n];
		Arrays.fill(ans, 'a');
		k -= n;
		for(int i = n - 1; i >= 0 && k > 0; i--) {
			int take = Math.min(25, k);
			k -= take;
			ans[i] = (char) (ans[i] + take);
		}
		return String.valueOf(ans);
	}
}
