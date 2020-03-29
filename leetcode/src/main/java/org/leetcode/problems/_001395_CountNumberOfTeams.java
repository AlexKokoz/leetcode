package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001395_CountNumberOfTeams {
	public int numTeams(int[] rating) {
		int count = 0;
		int n = rating.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int z = j + 1; z < n; z++) {
					if ((rating[i] < rating[j] && rating[j] < rating[z])
							|| (rating[i] > rating[j] && rating[j] > rating[z]))
						count++;
				}
			}
		}
		return count;
	}
}
