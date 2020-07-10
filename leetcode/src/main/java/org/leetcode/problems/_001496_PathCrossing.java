package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001496_PathCrossing {
	public boolean isPathCrossing(String path) {
		int x = 0;
		int y = 0;
		Set<Point> set = new HashSet<>();
		set.add(new Point(x, y));
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			switch (c) {
			case 'N':
				y++;
				break;
			case 'S':
				y--;
				break;
			case 'E':
				x++;
				break;
			case 'W':
				x--;
				break;
			default:
				throw new IllegalArgumentException();
			}
			Point point = new Point(x, y);
			if (set.contains(point)) return true;
			set.add(point);
		}
		return false;
	}
	
	class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int hashCode () {
			return x * 10000 + y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Point)) return false;
			Point that = (Point) o;
			return this.x == that.x && this.y == that.y;
		}
	}
}
