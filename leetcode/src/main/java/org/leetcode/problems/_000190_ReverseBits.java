package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000190_ReverseBits {
	public int reverseBits(int n) {
		int ans = 0;
		for (int i = 0; i < 32; i++) {
			if (n << ~i < 0) {
				ans |= (1 << (31 - i));
			}
		}
		return ans;
	}
}
