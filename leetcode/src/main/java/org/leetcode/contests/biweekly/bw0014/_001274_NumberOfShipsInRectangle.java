package org.leetcode.contests.biweekly.bw0014;

/**
 * HARD
 * 
 * @author AccelSprinter
 *
 */
public class _001274_NumberOfShipsInRectangle {
	static class Sea {
		public boolean hasShips(int[] tr, int[] bl) {
			return true;
		}
	}

	public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
		return solve(sea, topRight, bottomLeft);
	}

	static int solve(Sea sea, int[] tr, int[] bl) {
		if (!sea.hasShips(tr, bl))
			return 0;
		if (tr[0] == bl[0] && tr[1] == bl[1])
			return 1;
		final int[] tr2 = new int[2];
		final int[] bl2 = new int[2];
		if (tr[1] - bl[1] < tr[0] - bl[0]) { // split vertically
			final int xmiddle = (tr[0] + bl[0]) / 2;
			tr2[0] = xmiddle;
			tr2[1] = tr[1];
			bl2[0] = xmiddle + 1;
			bl2[1] = bl[1];
			int ans = solve(sea, tr2, bl);
			if (ans < 10)
				ans += solve(sea, tr, bl2);
			return ans;
		} else { // split horizontally
			final int ymiddle = (tr[1] + bl[1]) / 2;
			tr2[0] = tr[0];
			tr2[1] = ymiddle;
			bl2[0] = bl[0];
			bl2[1] = ymiddle + 1;
			int ans = solve(sea, tr2, bl);
			if (ans < 10)
				ans += solve(sea, tr, bl2);
			return ans;
		}

	}

}
