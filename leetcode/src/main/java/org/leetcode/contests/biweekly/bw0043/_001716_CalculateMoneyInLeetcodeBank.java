package org.leetcode.contests.biweekly.bw0043;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001716_CalculateMoneyInLeetcodeBank {
	public int totalMoney(int n) {
		int sum = 0;
		int monday = 0;
		int cur = 0;
		for (int i = 0; i < n; i++) {
			if (i % 7 == 0) {
				monday++;
				cur = monday;
			} else {
				cur++;
			}
			sum += cur;
		}
		return sum;
	}
}
