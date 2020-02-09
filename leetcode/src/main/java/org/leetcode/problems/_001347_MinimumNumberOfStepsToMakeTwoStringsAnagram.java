package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001347_MinimumNumberOfStepsToMakeTwoStringsAnagram {
	public int minSteps(String s, String t) {
		int[] f = new int[256];
		for (int i = 0; i < s.length(); i++) {
			f[s.charAt(i)]++;
		}
		
		for (int i = 0; i < t.length(); i++)
			f[t.charAt(i)]--;
		int ans = 0;
		for(int x : f) {
			ans += Math.abs(x);
		}
		return ans / 2;
	}
}
