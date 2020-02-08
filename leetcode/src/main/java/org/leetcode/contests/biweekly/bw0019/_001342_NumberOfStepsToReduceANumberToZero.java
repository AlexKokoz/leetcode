package org.leetcode.contests.biweekly.bw0019;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001342_NumberOfStepsToReduceANumberToZero {
	public int numberOfSteps(int num) {
		int steps = 0;
		while (num > 0) {
			if ((num & 1) == 0)
				num >>= 1;
			else
				num--;
			steps++;
		}
		return steps;

	}
}
