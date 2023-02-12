package org.leetcode.contests.biweekly.bw0076;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	public int maximumScore(int[] scores, int[][] edges) {
		int n = scores.length;
		int m = edges.length;
		int ans = Integer.MIN_VALUE;

		int[] from = new int[m];
		int[] to = new int[m];
		for (int i = 0; i < m; i++) {
			from[i] = edges[i][0];
			to[i] = edges[i][1];
		}
		int[][] maxes = new int[n][3];
		for (int[] row : maxes) {
			Arrays.fill(row, -1);
		}
		for (int[] e : edges) {
			update(e[0], e[1], scores, maxes);
			update(e[1], e[0], scores, maxes);
		}
		for (int[] e : edges) {
			List<Integer> maxes1 = new ArrayList<>(), maxes2 = new ArrayList<>();
			for (int v : maxes[e[0]]) {
				if (v == e[1])
					continue;
				maxes1.add(v);
			}
			if (maxes1.isEmpty())
				continue;
			for (int v : maxes[e[1]]) {
				if (v == e[0])
					continue;
				maxes2.add(v);
			}
			if (maxes2.isEmpty())
				continue;
			int cand = Integer.MIN_VALUE;
			if (!maxes1.get(0).equals(maxes2.get(0))) {
				cand = scores[e[0]] + scores[e[1]] + scores[maxes1.get(0)] + scores[maxes2.get(0)];
			} else {
				if (maxes2.size() > 1) {
					cand = Math.max(cand, scores[e[0]] + scores[e[1]] + scores[maxes1.get(0)]
							+ scores[maxes2.get(1)]);
				}
				if (maxes1.size() > 1) {
					cand = Math.max(cand, scores[e[0]] + scores[e[1]] + scores[maxes1.get(1)]
							+ scores[maxes2.get(0)]);
				}
			}
			ans = Math.max(ans, cand);
		}
		return ans == Integer.MIN_VALUE ? -1 : ans;

	}

	static void update(int v, int w, int[] scores, int[][] maxes) {
		if (maxes[v][0] == -1 || scores[w] > scores[maxes[v][0]]) {
			maxes[v][2] = maxes[v][1];
			maxes[v][1] = maxes[v][0];
			maxes[v][0] = w;
		} else if (maxes[v][1] == -1 || scores[w] > scores[maxes[v][1]]) {
			maxes[v][2] = maxes[v][1];
			maxes[v][1] = w;
		} else if (maxes[v][2] == -1 || scores[w] > scores[maxes[v][2]]) {
			maxes[v][2] = w;
		}
	}

}
