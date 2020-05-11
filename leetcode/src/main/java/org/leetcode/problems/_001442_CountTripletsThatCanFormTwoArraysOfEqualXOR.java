package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001442_CountTripletsThatCanFormTwoArraysOfEqualXOR {
	public int countTriplets(int[] arr) {
		int n = arr.length;
		int count = 0;
		int[] cum = new int[n];
		cum[0] = arr[0];
		for (int i = 1; i < n; i++) {
			cum[i] = arr[i] ^ cum[i - 1];
		}
		for (int l = 0; l < n - 1; l++) {
			for (int r = l + 1; r < n; r++) {
				if (cum(l, r, cum) == 0) {
					for (int mid = l + 1; mid <= r; mid++) {
						if (cum(l, mid - 1, cum) == cum(mid, r, cum)) {
							count++;
						}
					}
					// System.out.println(l + " " + r);
				}
			}
		}
		return count;
	}

	int cum(int l, int r, int[] cum) {
		if (l == 0) {
			return cum[r];
		} else {
			return cum[r] ^ cum[l - 1];
		}
	}
}
