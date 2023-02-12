package org.leetcode.contests.weekly.w0307;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
		int ans = 0;
		int n = energy.length;
		for (int i = 0; i < n; i++) {
			ans += Math.max(0, energy[i] - initialEnergy + 1)
					+ Math.max(0, experience[i] - initialExperience + 1);
			initialEnergy = Math.max(initialEnergy, energy[i] + 1);
			initialExperience = Math.max(initialExperience, experience[i] + 1);
			initialExperience += experience[i];
			initialEnergy -= energy[i];
		}
		return ans;
	}
}
