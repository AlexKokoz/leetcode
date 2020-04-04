package org.leetcode.contests.biweekly.bw0023;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001401_CircleAndRectangleOverlapping {
	public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
		double rectx = (double)(x1 + x2) / 2;
		double recty = (double)(y1 + y2) / 2;
		double circleDistanceX = Math.abs(x_center - rectx);
	    double circleDistanceY = Math.abs(y_center - recty);

	    double rectw = x2 - x1;
	    double recth = y2 - y1;
	    if (circleDistanceX > (rectw/2 + radius)) { return false; }
	    if (circleDistanceY > (recth/2 + radius)) { return false; }

	    if (circleDistanceX <= (rectw/2)) { return true; } 
	    if (circleDistanceY <= (recth/2)) { return true; }

	    double cornerDistance_sq = (circleDistanceX - rectw/2) * (circleDistanceX - rectw/2) +
	                         (circleDistanceY - recth/2) * (circleDistanceY - recth/2);

	    return (cornerDistance_sq <= (radius * radius));
	}
}
