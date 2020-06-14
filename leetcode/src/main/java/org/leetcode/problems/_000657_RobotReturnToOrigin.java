package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000657_RobotReturnToOrigin {
	public boolean judgeCircle(String moves) {
		int x = 0;
		int y = 0;
		for (int i = 0; i < moves.length(); i++) {
			char c = moves.charAt(i);
			switch (c) {
			case 'U':
				y++;
				break;
			case 'D':
				y--;
				break;
			case 'R':
				x++;
				break;
			case 'L':
				x--;
				break;
			}
		}
		return x == 0 && y == 0;
	}
}
