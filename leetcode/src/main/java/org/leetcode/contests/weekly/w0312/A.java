package org.leetcode.contests.weekly.w0312;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String[] sortPeople(String[] names, int[] heights) {
		int n = heights.length;
		int max = 0;
		for (int h : heights)
			max = Math.max(max, h);
		String[] h2n = new String[max + 1];
		for (int i = 0; i < n; i++) {
			h2n[heights[i]] = names[i];
		}
		for (int i = max, p = 0; i >= 0; i--) {
			if (h2n[i] != null) {
				names[p++] = h2n[i];
			}
		}
		return names;
	}
}
