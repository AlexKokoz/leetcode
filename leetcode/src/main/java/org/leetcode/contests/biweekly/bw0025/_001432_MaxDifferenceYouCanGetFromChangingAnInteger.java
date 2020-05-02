package org.leetcode.contests.biweekly.bw0025;

import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001432_MaxDifferenceYouCanGetFromChangingAnInteger {
	public int maxDiff(int num) {
		char[] ds = Integer.toString(num).toCharArray();
		TreeSet<Integer> set = new TreeSet<>();
		for (char d : ds)
			set.add(d - '0');
		int max, min;

		// find max
		if (set.size() == 1) {
			max = replace(set.first(), 9, num);
		} else if (ds[0] != '9') {
			max = replace(ds[0] - '0', 9, num);
		} else {
			int i;
			for (i = 0; i < ds.length && ds[i] == '9'; i++)
				;
			max = replace(ds[i] - '0', 9, num);
		}

		// find min
		if (set.size() == 1)
			min = replace(ds[0] - '0', 1, num);
		else if (ds[0] != '1')
			min = replace(ds[0] - '0', 1, num);
		else {
			int i;
			for (i = 1; i < ds.length && (ds[i] == '1' || ds[i] == '0'); i++)
				;
			if (i == ds.length) {
				min = num;
			} else {
				min = replace(ds[i] - '0', 0, num);
			}
		}

		return max - min;
	}

	int replace(int d, int nd, int num) {
		int ans = 0;
		int p = 1;
		while (num > 0) {
			int cur = num % 10;
			num /= 10;
			if (cur == d)
				ans = ans + p * nd;
			else
				ans = ans + p * cur;
			p *= 10;
		}
		return ans;
	}

}
