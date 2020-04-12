package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001411_NumberOfWaysToPaintN3Grid {
	public int numOfWays(int n) {
		long mod = 1000000007;
		long[] ways = new long[1 << 10];
		for (int l = 6; l <= 8; l++)
			for (int m = 3; m <= 5; m++)
				for (int r = 0; r <= 2; r++) {
					if (l % 3 == m % 3 || m % 3 == r % 3)
						continue;
					int state = 0;
					state |= (1 << l);
					state |= (1 << m);
					state |= (1 << r);
					ways[state]++;
				}
		for (int row = 2; row <= n; row++) {
			long[] nways = new long[ways.length];
			for (int l = 6; l <= 8; l++)
				for (int m = 3; m <= 5; m++)
					for (int r = 0; r <= 2; r++)
						for (int nl = 6; nl <= 8; nl++)
							for (int nm = 3; nm <= 5; nm++)
								for (int nr = 0; nr <= 2; nr++) {
									if (nl % 3 == nm % 3 || nm % 3 == nr % 3 || l % 3 == nl % 3 || m % 3 == nm % 3
											|| r % 3 == nr % 3)
										continue;
									int prevState = 0;
									prevState |= (1 << l);
									prevState |= (1 << m);
									prevState |= (1 << r);
									int newState = 0;
									newState |= (1 << nl);
									newState |= (1 << nm);
									newState |= (1 << nr);
									nways[newState] = (nways[newState] + ways[prevState]) % mod;
								}
			ways = nways;
		}
		long totalWays = 0;
		for (long way : ways)
			totalWays = (totalWays + way) % mod;
		return (int) totalWays;
	}
}
