package org.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001434_NumberOfWaysToWearDifferentHatsToEachOther {
	public int numberWays(List<List<Integer>> hats) {
		int n = hats.size();
		long mod = 1000000007;
		
		// for each hat store the people that prefer it
		@SuppressWarnings("unchecked")
		Set<Integer>[] usedBy = new Set[41];
		for (int i = 0; i < usedBy.length; i++)
			usedBy[i] = new HashSet<>();
		for (int i = 0; i < n; i++)  // for each person
			for (int hat : hats.get(i)) 
				usedBy[hat].add(i);

		// for each hat
		// for each person that prefers that hat and hasn't selected a hat
		// add its ways to the target set
		long[] dp = new long[(1 << n)];
		dp[0] = 1; // 1 way to have no one wear a hat
		for (int hat = 1; hat <= 40; hat++) {
			long ndp[] = Arrays.copyOf(dp, dp.length);
			int peopleWithHat = 0;
			for (; peopleWithHat < (1 << n); peopleWithHat++) {
				for (int person : usedBy[hat]) {
					if (peopleWithHat << ~person < 0)
						continue;
					int target = peopleWithHat | (1 << person);
					ndp[target] += dp[peopleWithHat];
					if (ndp[target] >= mod)
						ndp[target] -= mod;
				}
			}
			dp = ndp;
		}
		return (int) dp[(1 << n) - 1];
	}
}
