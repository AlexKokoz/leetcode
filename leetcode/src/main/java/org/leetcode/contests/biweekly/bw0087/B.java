package org.leetcode.contests.biweekly.bw0087;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int matchPlayersAndTrainers(int[] players, int[] trainers) {
		int np = players.length;
		int nt = trainers.length;
		int ans = 0;
		Arrays.sort(players);
		Arrays.sort(trainers);
		for (int i = nt - 1, j = np - 1; i >= 0; i--) {
			while (j >= 0 && trainers[i] < players[j])
				j--;
			if (j < 0)
				break;
			ans++;
			j--;
		}
		return ans;

	}
}
