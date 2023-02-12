package org.leetcode.contests.weekly.w0285;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
		int[] min = new int[12];
		for (int i = 0; i < 12; i++) {
			if (aliceArrows[i] + 1 <= numArrows) {
				min[i] = aliceArrows[i] + 1;
			}
		}
		int bestScore = 0;
		int bestScoreWeight = 0;
		int[] ans = new int[12];
		for (int mask = 1; mask < 1 << 12; mask++) {
			int score = 0;
			int weight = 0;
			for (int b = 0; b < 12; b++) {
				if (mask << ~b < 0) {
					weight += min[b];
					score += b;
				}
			}
			if (weight <= numArrows && score > bestScore) {
				bestScore = score;
				bestScoreWeight = weight;
				ans = new int[12];
				for (int b = 0; b < 12; b++) {
					if (mask << ~b < 0) {
						ans[b] = min[b];
					}
				}
			}
		}
		ans[0] += numArrows - bestScoreWeight;
		return ans;
	}
}
