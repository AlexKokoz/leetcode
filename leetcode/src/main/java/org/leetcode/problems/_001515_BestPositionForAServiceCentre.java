package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001515_BestPositionForAServiceCentre {
	public double getMinDistSum(int[][] positions) {
		int n = positions.length;
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };

		// Find centroid(average) point
		double candX = 0, candY = 0;
		for (int[] position : positions) {
			candX += position[0];
			candY += position[1];
		}
		candX /= n;
		candY /= n;

		// Evaluate total points' distance from average point
		double ans = totalDist(candX, candY, positions);

		// From the candidate point, check if one of the north, south, west and east
		// boundaries of distance {@code zoom} provides a shorter total distance than
		// the candidate.
		// If yes, set the boundary point as candidate and continue with same boundary
		// size.
		// If no, then a possible better point is within the boundary, so halve the zoom
		// length.
		double zoomLimit = 0.000001; // precision of 10^(-5)
		double zoom = 10; // should be chosen wrt. the input coordinate limits

		while (zoom > zoomLimit) {
			boolean found = false;
			for (int i = 0; i < dr.length; i++) {
				double newCandX = candX + zoom * dr[i];
				double newCandY = candY + zoom * dc[i];

				double newDist = totalDist(newCandX, newCandY, positions);

				if (newDist < ans) {
					ans = newDist;
					candX = newCandX;
					candY = newCandY;
					found = true;
					break;
				}
			}

			if (!found)
				zoom /= 2;
		}

		return ans;

	}

	static double totalDist(double x, double y, int[][] points) {
		double sum = 0;
		for (int[] point : points) {
			sum += dist(x, y, point[0], point[1]);
		}
		return sum;
	}

	static double dist(double x1, double y1, double x2, double y2) {
		double dx = Math.abs(x1 - x2);
		double dy = Math.abs(y1 - y2);
		return Math.sqrt(dx * dx + dy * dy);
	}
}
