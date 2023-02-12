package org.leetcode.contests.weekly.w0287;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int convertTime(String current, String correct) {
		String[] tokens1 = current.split(":");
		String[] tokens2 = correct.split(":");
		int start = Integer.parseInt(tokens1[0]) * 60 + Integer.parseInt(tokens1[1]);
		int end = Integer.parseInt(tokens2[0]) * 60 + Integer.parseInt(tokens2[1]);
		int diff = end - start;
		int ans = 0;
		for (int duration : new int[] { 60, 15, 5, 1 }) {
			while (diff >= duration) {
				ans++;
				diff -= duration;
			}
		}
		return ans;
	}
}
