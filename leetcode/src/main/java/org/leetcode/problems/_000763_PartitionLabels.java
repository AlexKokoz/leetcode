package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000763_PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		int n = s.length();
		List<Integer> ans = new ArrayList<>();
		int[][] se = new int[26][2];
		for (int[] row : se) {
			row[0] = n;
			row[1] = -1;
		}
		for (int i = 0; i < n; i++) {
			int c = s.charAt(i) - 'a';
			se[c][0] = Math.min(se[c][0], i);
			se[c][1] = Math.max(se[c][1], i);
		}
		int open = 0;
		int from = -1;
		for (int i = 0; i < n; i++) {
			int c = s.charAt(i) - 'a';
			if (i == se[c][0])
				open++;
			if (i == se[c][1])
				open--;
			if (open == 0) {
				ans.add(i - from);
				from = i;
			}
		}
		return ans;
	}
}
