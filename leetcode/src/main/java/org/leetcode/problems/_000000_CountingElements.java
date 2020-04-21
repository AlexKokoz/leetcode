package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000000_CountingElements {
	public int countElements(int[] nums) {
		int[] freq = new int[1001];
		int count = 0;
		for (int num : nums)
			freq[num]++;
		for (int i = 1; i < freq.length; i++)
			if (freq[i] > 0)
				count += freq[i - 1];
		return count;
	}
}
