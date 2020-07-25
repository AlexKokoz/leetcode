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
public class _000089_GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> ans = new ArrayList<>();
		ans.add(0);
		for (int i = 1; i <= n; i++) {
			int val = 1 << (i - 1);
			for (int j = ans.size() - 1; j >= 0; j--) {
				ans.add(val | ans.get(j));
			}
		}
		return ans;
	}
}
