package org.leetcode.contests.weekly.w0279;

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
	public int[] sortEvenOdd(int[] nums) {
		int n = nums.length;
		List<Integer> odds = new ArrayList<>(), evens = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0)
				evens.add(nums[i]);
			else
				odds.add(nums[i]);
		}
		Collections.sort(evens);
		Collections.sort(odds);
		int ie = 0, io = odds.size() - 1;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				nums[i] = evens.get(ie++);
			} else {
				nums[i] = odds.get(io--);
			}
		}
		return nums;
	}
}
