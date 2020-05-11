package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000304_RangeSumQuery2DImmutable {
	class NumMatrix {
		    
		    private final int[][] cum;

		    public NumMatrix(int[][] matrix) {
		        int n = matrix.length;
		        int m = (n == 0) ? 0 : matrix[0].length;
		        cum = new int[n + 1][m + 1];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < m; j++) {
		                cum[i + 1][j + 1] = matrix[i][j] + cum[i + 1][j] + cum[i][j + 1] - cum[i][j];
		            }
		        }
		    }
		    
		    public int sumRegion(int r1, int c1, int r2, int c2) {
		        return cum[r2 + 1][c2 + 1] - cum[r2 + 1][c1] - cum[r1][c2 + 1] + cum[r1][c1];
		    }
		}
}
