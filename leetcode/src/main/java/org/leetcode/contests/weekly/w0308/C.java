package org.leetcode.contests.weekly.w0308;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int garbageCollection(String[] garbage, int[] travel) {
		return solve(garbage, travel, 'M') + solve(garbage, travel, 'P') + solve(garbage, travel, 'G');
	}

	int solve(String[] garbage, int[] travel, char type) {
		int n = garbage.length;
		int[] count = new int[n];
		List<Integer> poss = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < garbage[i].length(); j++) {
				char cur = garbage[i].charAt(j);
				if (cur == type) {
					count[i]++;
					if (count[i] == 1) {
						poss.add(i);
					}
				}
			}
		}
		int ret = 0;
		int now = 0;
		for (int pos : poss) {
			ret += count[pos];
			while (now < pos) {
				ret += travel[now];
				now++;
			}
		}
		return ret;
	}
}
