package org.leetcode.contests.biweekly.bw0066;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int minCost(int[] s, int[] e, int[] rcost, int[] ccost) {
		int n = rcost.length;
		int m = ccost.length;
		int[] rcum = new int[n + 1];
		int[] ccum = new int[m + 1];
		for (int i = 0; i < n; i++)
			rcum[i + 1] = rcum[i] + rcost[i];
		for (int i = 0; i < m; i++)
			ccum[i + 1] = ccum[i] + ccost[i];
		if (s[0] == e[0] && s[1] == e[1])
			return 0;
		if (s[0] == e[0])
			return (e[1] > s[1]) ? ccum[e[1] + 1] - ccum[s[1] + 1] : ccum[s[1]] - ccum[e[1]];
		if (s[1] == e[1])
			return (e[0] > s[0]) ? rcum[e[0] + 1] - rcum[s[0] + 1] : rcum[s[0]] - rcum[e[0]];
		int cand1 = calc(rcum, ccum, new int[] { s[0], s[1] }, new int[] { e[0], s[1] })
				+ calc(rcum, ccum, new int[] { e[0], s[1] }, new int[] { e[0], e[1] });
		int cand2 = calc(rcum, ccum, new int[] { s[0], s[1] }, new int[] { s[0], e[1] })
				+ calc(rcum, ccum, new int[] { s[0], e[1] }, new int[] { e[0], e[1] });
		return Math.min(cand1, cand2);
	}

	int calc(int[] rcum, int[] ccum, int[] s, int[] e) {
		if (s[0] == e[0])
			return (e[1] > s[1]) ? ccum[e[1] + 1] - ccum[s[1] + 1] : ccum[s[1]] - ccum[e[1]];
		if (s[1] == e[1])
			return (e[0] > s[0]) ? rcum[e[0] + 1] - rcum[s[0] + 1] : rcum[s[0]] - rcum[e[0]];
		return 0;
	}
}
