package org.leetcode.contests.weekly.w0316;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public boolean haveConflict(String[] event1, String[] event2) {
		int[] s1 = time(event1[0]);
		int[] e1 = time(event1[1]);
		int[] s2 = time(event2[0]);
		int[] e2 = time(event2[1]);
		return (s1[0] < e2[0] || (s1[0] == e2[0] && s1[1] <= e2[1]))
				&& (s2[0] < e1[0] || (s2[0] == e1[0] && s2[1] <= e1[1]));
	}

	int[] time(String s) {
		int[] ret = new int[2];
		ret[0] = Integer.parseInt(s.substring(0, 2));
		ret[1] = Integer.parseInt(s.substring(3));
		return ret;
	}
}
