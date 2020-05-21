package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000860_LemonadeChange {
	public boolean lemonadeChange(int[] bills) {
		final int cost = 5;
		int[] availChange = new int[3]; // 5, 10
		for (int bill : bills) {
			int change = bill - cost;
			if (change == 0) {
				availChange[0]++;
			} else if (change == 5) {
				availChange[1]++;
				if (availChange[0] == 0)
					return false;
				availChange[0]--;
			} else if (change == 15) {
				if (availChange[0] > 0 && availChange[1] > 0) {
					availChange[0]--;
					availChange[1]--;
				} else if (availChange[0] >= 3) {
					availChange[0] -= 3;
				} else {
					return false;
				}
			}
		}
		return true;
	}
}
