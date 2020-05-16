package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000888_FairCandySwap {
	public int[] fairCandySwap(int[] A, int[] B) {
		int diff = 0;
		Set<Integer> setB = new HashSet<>();
		for (int x : A) {
			diff += x;
		}
		for (int x : B) {
			diff -= x;
			setB.add(x);
		}
		diff >>= 1;
		for (int x : A) {
			if (setB.contains(x - diff)) {
				return new int[] { x, x - diff };

			}
		}
		return null;
	}
}
