package org.leetcode.contests.weekly.w0209;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001610_MaximumNumberOfVisiblePoints {
	public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
		List<Double> angles = new ArrayList<>();

		int base = 0;
		for (List<Integer> point : points) {
			if (point.get(0) == location.get(0) && point.get(1) == location.get(1)) {
				base++;
				continue;
			}
			double thetaRad = Math.atan2(point.get(1) - location.get(1), point.get(0) - location.get(0));
			double thetaDeg = Math.toDegrees(thetaRad);
			if (thetaDeg < 0)
				thetaDeg = 360 + thetaDeg;
			angles.add(thetaDeg);
		}
		Collections.sort(angles);
		for (int i = 0, len = angles.size(); i < len; i++)
			angles.add(angles.get(i) + 360);
		int max = 0;
		for (int i = 0; i < angles.size(); i++) {
			double threshold = angles.get(i) + angle;
			int pos = binarySearch(angles, threshold);
			if (pos < 0) {
				pos = -pos - 1;
				max = Math.max(max, base + pos - i);
			} else {
				max = Math.max(max, base + pos - i + 1);
			}
		}
		return max;

	}

	int binarySearch(List<Double> list, double key) {
		int lo = 0;
		int hi = list.size() - 1;
		int ans = list.size();
		boolean found = false;
		while (lo <= hi) {
			int mid = lo + (hi - lo >> 1);
			if (list.get(mid) < key) {
				lo = mid + 1;
			} else if (list.get(mid) > key) {
				hi = mid - 1;
			} else {
				found = true;
				ans = mid;
				lo = mid + 1;
			}
		}
		return found ? ans : -(lo + 1);
	}
}
