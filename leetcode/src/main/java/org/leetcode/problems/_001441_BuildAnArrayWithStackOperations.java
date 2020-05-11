package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001441_BuildAnArrayWithStackOperations {
	public List<String> buildArray(int[] target, int n) {
		List<String> ans = new LinkedList<>();
		int targetIndex = 0;
		int elem = 1;
		while (targetIndex < target.length) {
			if (target[targetIndex] == elem) {
				ans.add("Push");
				targetIndex++;
				elem++;
			} else {
				ans.add("Push");
				ans.add("Pop");
				elem++;
			}
		}
		return ans;
	}
}
