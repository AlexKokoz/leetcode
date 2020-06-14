package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000406_QueueReconstructionByHeight {
	public int[][] reconstructQueue(int[][] people) {
		int n = people.length;
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0])
					return a[0] - b[0];
				return b[1] - a[1];
			}
		});

		int[][] ans = new int[n][];
		for (int[] person : people) {
			int i = findIthEmptyPosition(ans, person[1]);
			ans[i] = person;
		}
		return ans;
	}

	static int findIthEmptyPosition(int[][] arr, int pos) {
		int i;
		for (i = 0; i < arr.length; i++) {
			if (arr[i] == null)
				pos--;
			if (pos < 0)
				break;
		}
		return i;
	}
}
