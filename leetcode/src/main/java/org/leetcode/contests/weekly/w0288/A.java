package org.leetcode.contests.weekly.w0288;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int largestInteger(int num) {
		char[] cs = Integer.toString(num).toCharArray();
		List<Integer> odds = new ArrayList<>();
		List<Integer> evens = new ArrayList<>();
		for (char c : cs) {
			int x = c - '0';
			if (x % 2 == 0)
				evens.add(x);
			else
				odds.add(x);
		}
		Collections.sort(evens);
		Collections.sort(odds);
		for (int i = 0, e = evens.size() - 1, o = odds.size() - 1; i < cs.length; i++) {
			int x = cs[i] - '0';
			if (x % 2 == 0) {
				cs[i] = (char) (evens.get(e--) + '0');
			} else {
				cs[i] = (char) (odds.get(o--) + '0');
			}
		}
		return Integer.parseInt(String.valueOf(cs));
	}
}
