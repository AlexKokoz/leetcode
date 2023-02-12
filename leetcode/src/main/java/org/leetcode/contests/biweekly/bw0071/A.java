package org.leetcode.contests.biweekly.bw0071;

import java.util.Arrays;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int minimumSum(int num) {
		int ans = Integer.MAX_VALUE;
		char[] target = String.valueOf(num).toCharArray();
		Arrays.sort(target);
		for (int cur = 1000; cur <= 9999; cur++) {
			String s = String.valueOf(cur);
			char[] compare = s.toCharArray();
			Arrays.sort(compare);
			if (Arrays.equals(target, compare)) {
				for (int i = 1; i < 4; i++) {
					ans = Math.min(ans, Integer.parseInt(s.substring(0, i))
							+ Integer.parseInt(s.substring(i)));
				}
			}
		}
		return ans;
	}
}
