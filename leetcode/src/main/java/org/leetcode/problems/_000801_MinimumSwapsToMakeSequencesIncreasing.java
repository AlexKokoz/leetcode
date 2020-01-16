package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000801_MinimumSwapsToMakeSequencesIncreasing {
	public int minSwap(int[] A, int[] B) {

		int n = A.length;

		/*
		 * Cost of creating increasing sequence [0..i-1] by NOT swapping the elements in
		 * i - 1 position. Initialized for 0 position.
		 */
		int prevNotSwappedCost = 0;

		/*
		 * Cost of creating increasing sequence [0..i-1] by swapping the elements in i -
		 * 1 position. Initialized for 0 position.
		 */
		int prevSwappedCost = 1;

		for (int i = 1; i < n; i++) {

			int curSwappedCost = 0; // like prevSwappedCost but for range[0..i]
			int curNotSwappedCost = 0; // like prevNotSwappedCost but for range[0..i]

			// Both, swapping or not, would work.
			if (Math.min(A[i], B[i]) > Math.max(A[i - 1], B[i - 1])) { 
				curNotSwappedCost = Math.min(prevSwappedCost, prevNotSwappedCost);
				curSwappedCost = curNotSwappedCost + 1;
			} 
			// At least one current element is <= than one of the previous ones.
			else if (A[i] > A[i - 1] && B[i] > B[i - 1]) { 
				curNotSwappedCost = prevNotSwappedCost;
				curSwappedCost = prevSwappedCost + 1;
			} 
			// At least one current element is <= that its corresponding previous one.
			else { 
				curNotSwappedCost = prevSwappedCost;
				curSwappedCost = prevNotSwappedCost + 1;
			}
			
			prevNotSwappedCost = curNotSwappedCost;
			prevSwappedCost = curSwappedCost;
		}
		return Math.min(prevSwappedCost, prevNotSwappedCost);
	}
}
