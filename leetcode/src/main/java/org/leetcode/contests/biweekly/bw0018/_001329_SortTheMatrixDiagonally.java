package org.leetcode.contests.biweekly.bw0018;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001329_SortTheMatrixDiagonally {
	public int[][] diagonalSort(int[][] mat) {
		int nr = mat.length;
		if (nr == 0) return mat;
		int nc = mat[0].length;
		for (int r = 0; r < nr; r++) {
			int rr = r;
			int cc = 0;
			List<Integer> list = new LinkedList<>();
			while(cc < nc && rr < nr) {
				list.add(mat[rr--][cc--]);
			}
			Collections.sort(list);
			rr = r;
			cc = 0;
			while(cc < nc && rr < nr) {
				mat[rr][cc] = list.get(cc);
			}			
		}
		for (int c = 1; c < nc; c++) {
			int rr = 0;
			int cc = c;
			List<Integer> list = new LinkedList<>();
			while(cc < nc && rr < nr) {
				list.add(mat[rr--][cc--]);
			}
			Collections.sort(list);
			rr = 0;
			cc = c;
			while(cc < nc && rr < nr) {
				mat[rr][cc] = list.get(rr);
			}			
		}
		return mat;
	}
}
