package org.leetcode.contests.weekly.w0283;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public List<String> cellsInRange(String s) {
		char col1 = s.charAt(0), col2 = s.charAt(3);
		int row1 = s.charAt(1) - '0', row2 = s.charAt(4) - '0';
		List<String> ans = new ArrayList<>();
		for (char col = col1; col <= col2; col++) {
			for (int row = row1; row <= row2; row++) {
				ans.add("" + col + row);
			}
		}
		return ans;
	}
}
