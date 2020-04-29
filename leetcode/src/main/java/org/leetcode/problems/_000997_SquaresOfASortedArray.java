package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000997_SquaresOfASortedArray {
	public int[] sortedSquares(int[] nums) {
		int[] count = new int[10001];
		for (int num : nums)
			count[Math.abs(num)]++;
		int[] ans = new int[nums.length];
		for (int i = 0, j = 0; i < count.length; i++) {
			if (count[i] == 0)
				continue;
			int square = i * i;
			for (int step = 1; step <= count[i]; step++)
				ans[j++] = square;
		}
		return ans;
	}
}
