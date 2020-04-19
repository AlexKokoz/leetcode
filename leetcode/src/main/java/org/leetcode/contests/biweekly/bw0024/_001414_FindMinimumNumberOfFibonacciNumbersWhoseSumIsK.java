package org.leetcode.contests.biweekly.bw0024;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001414_FindMinimumNumberOfFibonacciNumbersWhoseSumIsK {
	public int findMinFibonacciNumbers(int k) {
		List<Integer> fib = new LinkedList<>();
		fib.add(1);
		fib.add(1);
		while (fib.get(fib.size() - 1) < k) {
			int n = fib.size();
			fib.add(fib.get(n - 2) + fib.get(n - 1));
		}

		int count = 0;
		int index = fib.size() - 1;
		while (k > 0) {
			while (fib.get(index) > k)
				index--;
			count++;
			k -= fib.get(index);
		}
		return count;
	}

}
