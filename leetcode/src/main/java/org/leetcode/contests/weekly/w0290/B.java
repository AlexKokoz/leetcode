package org.leetcode.contests.weekly.w0290;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public int countLatticePoints(int[][] circles) {
		int ans = 0;
		for (int x = -101; x <= 201; x++) {
			for (int y = -101; y <= 201; y++) {
				for (int[] circle : circles) {
					if (distSq(x, y, circle[0], circle[1]) <= circle[2] * circle[2]) {
						ans++;
						break;
					}
				}
			}
		}
		return ans;
	}
	int distSq(int x1, int y1, int x2, int y2) {
		int dx = x1 - x2;
		int dy = y1 - y2;
		return dx * dx + dy * dy;
	}
}
