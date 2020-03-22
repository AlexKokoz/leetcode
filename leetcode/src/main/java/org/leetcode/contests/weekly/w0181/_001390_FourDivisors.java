package org.leetcode.contests.weekly.w0181;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001390_FourDivisors {
	public int sumFourDivisors(int[] nums) {
		int max = 0;
		for (int num : nums)
			max = Math.max(max, num);
		int[] memo = new int[max + 1];
		int sum = 0;
		for (int num : nums) {
			if (memo[num] < 0)
				continue;
			else if (memo[num] > 0)
				sum += memo[num];
			else {
				int cnt = 0;
				int sqrt = (int) Math.sqrt(num);
				for (int i = 1; i <= sqrt; i++) {
					if (num % i == 0) {
						cnt += 2;
						memo[num] += i + num / i;
					}
				}
				if (sqrt * sqrt == num) {
					memo[num] -= sqrt; 
					cnt--;
				}
				if (cnt != 4) memo[num] = -1;
				else sum += memo[num];
			}
		}
		return sum;
	}
}
