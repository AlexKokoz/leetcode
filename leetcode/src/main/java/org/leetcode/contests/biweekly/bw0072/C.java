package org.leetcode.contests.biweekly.bw0072;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public List<Long> maximumEvenSplit(long sum) {
		List<Long> ans = new ArrayList<>();
		if (sum % 2 == 1)
			return ans;
		for (long num = 2; num <= sum; num += 2) {
			ans.add(num);
			sum -= num;
		}
		for (int i = ans.size() - 1; i >= 0 && sum > 0; i--) {
			ans.set(i, ans.get(i) + 2);
			sum -= 2;
		}
		return ans;
	}
}
