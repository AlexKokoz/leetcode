package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001552_MagneticForceBetweenTwoBalls {
	public int maxDistance(int[] position, int m) {
		Arrays.sort(position);
		int n = position.length;
		int lo = 0; 
		int hi = position[n - 1];
		while(lo + 1 < hi ) {
			int mi = lo + (hi - lo >> 1);
			if (check(position, m, mi)) {
				lo = mi;
			} else {
				hi = mi;
			}
		}
		return lo;
	}
	
	boolean check(int[] a, int rem, int d) {
		int prev = 0;
		int placed = 1;
		for(int i = 1; i < a.length; i++) {
			if (a[i] - a[prev] >= d) {
				prev = i;
				placed++;
			}
		}
		return placed >= rem;
	}
}
