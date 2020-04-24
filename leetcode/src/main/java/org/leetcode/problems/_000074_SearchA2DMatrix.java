package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000074_SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int n = matrix.length;
		if (n == 0)
			return false;
		int m = matrix[0].length;
		if (m == 0)
			return false;

		// binary search between first column's elements
		int rlo = 0;
		int rhi = n - 1;
		int candidateRow = 0;
		while (rlo <= rhi) {
			int rmi = rlo + ((rhi - rlo) >>> 1);
			if (target >= matrix[rmi][0]) {
				if (rmi == n - 1 || target < matrix[rmi + 1][0]) {
					candidateRow = rmi;
					break;
				}
				rlo = rmi + 1;
			} else
				rhi = rmi - 1;
		}

		// binary search in candidate row
		int lo = 0;
		int hi = m - 1;
		while (lo <= hi) {
			int mi = lo + ((hi - lo) >>> 1);
			if (target < matrix[candidateRow][mi])
				hi = mi - 1;
			else if (target > matrix[candidateRow][mi])
				lo = mi + 1;
			else
				return true;
		}
		return false;
	}
}
