package org.leetcode.contests.weekly.w0217;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001673_FindTheMostCompetitiveSubsequence {
	public int[] mostCompetitive(int[] nums, int k) {
		int[] ans = new int[k];
		int n = nums.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0])
				return Integer.compare(a[0], b[0]);
			return Integer.compare(a[1], b[1]);
		});
		for (int i = 0; i <= n - k; i++) {
			pq.add(new int[] { nums[i], i });
		}
		for (int i = 0, p = 0, next = n - k + 1; i < k; i++, next++) {
			int[] cur = pq.poll();
			int num = cur[0];
			int pos = cur[1];
			ans[p++] = num;
			while (!pq.isEmpty() && pq.peek()[1] < pos)
				pq.poll();
			if (next >= n)
				break;
			pq.add(new int[] { nums[next], next });
		}
		return ans;
	}

}
