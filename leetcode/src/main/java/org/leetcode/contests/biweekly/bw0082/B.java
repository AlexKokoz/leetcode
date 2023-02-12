package org.leetcode.contests.biweekly.bw0082;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
		Arrays.sort(buses);
		Arrays.sort(passengers);
		int np = passengers.length;
		int nb = buses.length;
		int ip = 0;
		int ans = 1;
		for (int ib = 0; ib < nb; ib++) {
			int rem = capacity;
			while (ip < np && rem > 0 && passengers[ip] <= buses[ib]) {
				if (ip == 0 || passengers[ip - 1] != passengers[ip] - 1) {
					ans = passengers[ip] - 1;
				}
				rem--;
				ip++;
			}
			if (ip == 0 || (ip > 0 && rem > 0 && passengers[ip - 1] != buses[ib])) {
				ans = buses[ib];
			}
		}
		return ans;
	}
}
