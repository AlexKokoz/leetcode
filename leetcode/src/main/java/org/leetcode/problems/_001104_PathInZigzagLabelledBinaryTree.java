package org.leetcode.problems;

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
public class _001104_PathInZigzagLabelledBinaryTree {
	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> ans = new LinkedList<>();
		int level = Integer.highestOneBit(label);
		ans.add(label);
		while (level > 1) {
			int start = level >> 1;
			int end = level - 1;
			int par = label / 2;
			int npar = start + end - par;
			ans.add(npar);
			label = npar;
			level >>= 1;
		}
		Collections.reverse(ans);
		return ans;
	}
}
