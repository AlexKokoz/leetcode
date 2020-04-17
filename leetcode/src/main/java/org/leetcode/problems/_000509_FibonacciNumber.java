package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000509_FibonacciNumber {
	public int fib(int N) {
		if (N == 0)
			return 0;
		int[] memo = new int[N + 1];
		memo[1] = 1;
		return fib(N, memo);
	}

	int fib(int n, int[] memo) {
		if (n <= 1 || memo[n] != 0)
			return memo[n];
		memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
		return memo[n];
	}
}
