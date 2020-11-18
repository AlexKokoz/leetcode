package org.leetcode.contests.biweekly.bw0036;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001606_FindServersThatHandledMostNumberOfRequests {
	public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
		int nq = arrival.length;
		List<Integer> ans = new ArrayList<>();
		int[] counts = new int[k];
		TreeSet<Integer> free = new TreeSet<>();
		PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int server = 0; server < k; server++)
			free.add(server);

		for (int request = 0; request < nq; request++) {
			int server = request % k;
			int t = arrival[request];
			int l = load[request];
			while (!busy.isEmpty() && busy.peek()[0] <= t) {
				int[] cur = busy.poll();
				free.add(cur[1]);
			}
			if (free.isEmpty())
				continue;
			Integer chosen = free.ceiling(server); // find first available between [server..k - 1]..
			if (chosen == null)
				chosen = free.first(); // ..if none available, choose first between [0..server - 1]
			free.remove(chosen);
			busy.add(new int[] { t + l, chosen });
			counts[chosen]++;
		}
		System.out.println(Arrays.toString(counts));

		int max = Arrays.stream(counts).parallel().max().getAsInt();
		for (int i = 0; i < k; i++)
			if (counts[i] == max)
				ans.add(i);
		return ans;
	}
}
