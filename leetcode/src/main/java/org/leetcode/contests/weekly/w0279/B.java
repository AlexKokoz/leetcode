package org.leetcode.contests.weekly.w0279;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public long smallestNumber(long num) {
		if (num == 0)
			return 0;

		boolean minus = num < 0;
		num = Math.abs(num);
		long ans = minus ? -max(num) : min(num);
		return ans;

	}

	long min(long num) {
		List<Long> ds = new ArrayList<>();
		int zeros = 0;
		while (num > 0) {
			long d = num % 10;
			if (d == 0)
				zeros++;
			else
				ds.add(d);
			num /= 10;
		}
		Collections.sort(ds);
		long ans = ds.get(0);
		for (int i = 0; i < zeros; i++) {
			ans *= 10;
		}
		for (int i = 1; i < ds.size(); i++) {
			ans = 10 * ans + ds.get(i);
		}
		return ans;
	}

	long max(long num) {
		List<Long> ds = new ArrayList<>();
		int zeros = 0;
		while (num > 0) {
			long d = num % 10;
			if (d == 0)
				zeros++;
			else
				ds.add(d);
			num /= 10;
		}
		Collections.sort(ds);
		long ans = 0;
		for (int i = ds.size() - 1; i >= 0; i--) {
			ans = 10 * ans + ds.get(i);
		}
		for (int i = 0; i < zeros; i++) {
			ans *= 10;
		}
		return ans;
	}
}
