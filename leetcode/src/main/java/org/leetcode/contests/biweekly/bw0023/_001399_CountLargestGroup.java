package org.leetcode.contests.biweekly.bw0023;

import java.util.*;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001399_CountLargestGroup {
	public int countLargestGroup(int n) {
		Map<Integer, Integer> sizes = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			int size = size(i);
			int freq = sizes.getOrDefault(size, 0);
			sizes.put(size, freq + 1);
		}

		int max = 0;
		int count = 0;
		for (int size : sizes.values()) {
			if (size > max) {
				max = size;
				count = 1;
			} else if (size == max) {
				count++;
			}
		}
		return count;
	}

	int size(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		n = sum;
		return n;
	}
}
