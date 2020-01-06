package org.leetcode.contests.weekly.w0167;

import java.util.LinkedList;
import java.util.List;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001291_SequentialDigits {

	public List<Integer> sequentialDigits(int low, int high) {
		final List<Integer> ans = new LinkedList<>();
		final String lowString = Integer.toString(low);
		final int lowDigits = lowString.length();
		final String highString = Integer.toString(high);
		final int highDigits = highString.length();
		for (int l = lowDigits; l <= highDigits; l++) {
			int start = Character.getNumericValue(lowString.charAt(0));
//			int end = Character.getNumericValue(highString.charAt(0)) + 1;

			int curr = 0;
			int factor = start;
			while (true) {
				for (int i = 0; i < l; i++) {
					curr = curr * 10 + factor;
					factor++;
				}
				if (curr > high)
					break;
				if (curr >= low)
					ans.add(curr);
			}
		}
		return ans;
	}

}
