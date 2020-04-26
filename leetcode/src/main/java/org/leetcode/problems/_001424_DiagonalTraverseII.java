package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001424_DiagonalTraverseII {
	public int[] findDiagonalOrder(List<List<Integer>> lists) {
		int n = lists.size();
		int ansLen = 0;
		for (List<Integer> list : lists)
			ansLen += list.size();
		int index = 0;
		int[][] aux = new int[ansLen][3]; // val, row + col, col
		for (int row = 0; row < n; row++) {
			List<Integer> list = lists.get(row);
			for (int col = 0; col < list.size(); col++) {
				aux[index++] = new int[] {list.get(col), row + col, col};
			}
		}
		Arrays.sort(aux, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[1] != b[1]) return a[1] - b[1];
				return a[2] = b[2];
			}
		});
		
		int[] ans = new int[ansLen];
		for (int i = 0; i < aux.length; i++)
			ans[i] = aux[i][0];
		return ans;
	}
}
