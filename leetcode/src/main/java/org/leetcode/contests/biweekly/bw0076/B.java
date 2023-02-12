package org.leetcode.contests.biweekly.bw0076;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public long waysToBuyPensPencils(int total, int cost1, int cost2) {
		Map<Integer, Long> map1 = new HashMap<>();
		Map<Integer, Long> map2 = new HashMap<>();
		map1.put(0, 1L);
		map2.put(0, 1L);
		long ans = 0;
		int count1 = 0;
		while (total >= cost1) {
			count1++;
			total -= cost1;
		}
		int count2 = 0;
		while (total >= cost2) {
			count2++;
			total -= cost2;
		}
		while (count1 >= 0) {
			ans += count2 + 1;
			count1--;
			total += cost1;
			while (total >= cost2) {
				count2++;
				total -= cost2;
			}
		}
		return ans;

	}
}
