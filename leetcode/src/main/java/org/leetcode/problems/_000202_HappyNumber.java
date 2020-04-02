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
public class _000202_HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		set.add(n);
		while (n != 1) {
			int sum = 0;
			while (n > 0) {
				int d = n % 10;
				sum += d * d;
				n /= 10;
			}
			n = sum;
			if (set.contains(n))
				return false;
			else
				set.add(n);
		}
		return true;
	}
}
