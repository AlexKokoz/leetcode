package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000514_FreedomTrail {
	public int findRotateSteps(String ring, String key) {
		int nr = ring.length();
		int nk = key.length();
		@SuppressWarnings("unchecked")
		Queue<Integer>[] bucket = new Queue[26];

		for (int i = 0; i < bucket.length; i++) {
			bucket[i] = new LinkedList<>();
		}

		for (int i = 0; i < nr; i++) {
			bucket[ring.charAt(i) - 'a'].add(i);
		}

		int[] dp = new int[nr];

		for (int ik = nk - 1; ik >= 0; ik--) {
			int[] ndp = new int[dp.length];
			Arrays.fill(ndp, Integer.MAX_VALUE);
			for (int ir = 0; ir < nr; ir++) {
				for (int cur : bucket[key.charAt(ik) - 'a']) {
					int dist = Math.abs(ir - cur);
					int step = Math.min(dist, nr - dist);
					ndp[ir] = Math.min(ndp[ir], dp[cur] + step);
				}
			}
			dp = ndp;
		}

		return dp[0] + nk;
	}
}
