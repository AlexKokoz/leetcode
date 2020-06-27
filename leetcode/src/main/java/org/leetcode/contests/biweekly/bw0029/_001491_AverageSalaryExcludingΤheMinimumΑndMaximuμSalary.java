package org.leetcode.contests.biweekly.bw0029;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001491_AverageSalaryExcludingΤheMinimumΑndMaximuμSalary {
	public double average(int[] salary) {
		double sum = 0;
		double max = Double.MIN_VALUE;
		double min = 0;
		for (double x : salary) {
			sum += x;
			max = Math.max(max, x);
			min = Math.min(min, x);
		}
		sum -= max + min;
		return sum / (salary.length - 2);
	}
}
