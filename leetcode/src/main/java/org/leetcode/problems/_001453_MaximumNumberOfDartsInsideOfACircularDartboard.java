package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001453_MaximumNumberOfDartsInsideOfACircularDartboard {
	public int numPoints(int[][] points, int r) {
		int n = points.length; // #points
		int d = 2 * r; // diameter
		double[][] dist = new double[n][n]; // dist[i][j] = distance between points[i] and points[j]

		// calculate distances between each pair of points
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				dist[i][j] = dist[j][i] = dist(points[i][0], points[i][1], points[j][0], points[j][1]);

		// initial answer will be 1 if there is at least one point in input; 0 otherwise
		int ans = n > 0 ? 1 : 0;

		// perform angular sweep for each point at a time
		for (int i = 0; i < n; i++) {
			int count = angularSweepFromPoint(i, d, n, points, dist);
			ans = Math.max(ans, count);
		}
		return ans;
	}

	// Euclidean distance
	double dist(int x1, int y1, int x2, int y2) {
		int dx = (x1 - x2) * (x1 - x2);
		int dy = (y1 - y2) * (y1 - y2);
		return Math.sqrt(dx + dy);
	}

	// Angular sweep from point points[i]
	int angularSweepFromPoint(int i, int d, int n, int[][] points, double[][] dist) {
		int max = 1; // local max
		int count = 1; // sweep's running count
		int pop = 0; // population
		double[][] angles = new double[2 * n][2];
		for (int j = 0; j < n; j++) {
			if (dist[i][j] > d || i == j)
				continue;
			int[] p = points[i];
			int[] q = points[j];
			double A = Math.atan2(q[1] - p[1], q[0] - p[0]); // angle between PQ and x-axis
			double B = Math.acos(dist[i][j] / d); // angle between PQ and PC, C = center
			double a = A - B; // entry angle
			double b = A + B; // exit angle
			angles[pop++] = new double[] { a, 1 };
			angles[pop++] = new double[] { b, -1 };
		}
		angles = Arrays.copyOf(angles, pop);
		Arrays.sort(angles, new Comparator<double[]>() {
			public int compare(double[] a, double[] b) {
				return a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : a[1] < b[1] ? 1 : a[1] > b[1] ? -1 : 0;
			}
		});
		for (double[] angle : angles) {
			count += (int) angle[1];
			max = Math.max(max, count);
		}
		return max;
	}
}
