package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000498_DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		int n = matrix.length;
		if (n == 0)
			return new int[0];
		int m = matrix[0].length;
		if (m == 0)
			return new int[0];
		int[] ans = new int[n * m];
		int index = 0;
		int leftStartRow = 0;
		int leftStartCol = 0;
		int rightStartRow = m == 1 ? 1 : 0;
		int rightStartCol = m == 1 ? 0 : 1;
		boolean left = true;

		while (index < ans.length) {
			if (left) {
				int row = leftStartRow;
				int col = leftStartCol;
				while (row >= 0 && col < m) {
					ans[index++] = matrix[row][col];
					row--;
					col++;
				}
				if (leftStartRow == n - 1)
					leftStartCol += 2;
				else if (leftStartRow == n - 2)
					leftStartCol = 1;
				leftStartRow = Math.min(n - 1, leftStartRow + 2);
			} else {
				int row = rightStartRow;
				int col = rightStartCol;
				while (row < n && col >= 0) {
					ans[index++] = matrix[row][col];
					row++;
					col--;
				}
				if (rightStartCol == m - 1)
					rightStartRow += 2;
				else if (rightStartCol == m - 2)
					rightStartRow = 1;
				rightStartCol = Math.min(m - 1, rightStartCol + 2);
			}
			left = !left;
		}
		return ans;
	}
}
