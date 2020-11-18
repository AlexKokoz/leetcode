package org.leetcode.contests.biweekly.bw0037;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001620_CoordinateWithMaximumNetworkQuality {
	public int[] bestCoordinate(int[][] towers, int radius) {
		int n = towers.length;
		int[][] cands = new int[n][];
		double[][] dist = new double[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int xi = towers[i][0];
				int yi = towers[i][1];
				int xj = towers[j][0];
				int yj = towers[j][1];
				int dx = xi - xj;
				int dy = yi - yj;
				dist[i][j] = Math.sqrt(dx * dx + dy * dy);
			}
		}

		for (int i = 0; i < n; i++) {
			int qsum = 0;
			int x = towers[i][0];
			int y = towers[i][1];
			for (int j = 0; j < n; j++) {
				if (dist[i][j] > radius)
					continue;
				int q = towers[j][2];
				qsum += (int) (q / (1 + dist[i][j]));
			}
			cands[i] = new int[] { x, y, qsum };
		}

		Arrays.sort(cands, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if (a[2] == b[2]) {
					if (a[0] == b[0])
						return a[1] - b[1];
					return a[0] - b[0];
				}
				return b[2] - a[2];
			}
		});
		return new int[] { cands[0][0], cands[0][1] };
	}
}
