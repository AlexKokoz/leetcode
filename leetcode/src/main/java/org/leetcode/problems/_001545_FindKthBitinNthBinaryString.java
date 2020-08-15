package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001545_FindKthBitinNthBinaryString {
	public char findKthBit(int n, int k) {
		if (n == 1)
			return '0';
		int mid = (1 << n) >> 1;
		if (k == mid)
			return '1';
		else if (k < mid)
			return findKthBit(n - 1, k);
		else {
			char ans = findKthBit(n - 1, (1 << n) - k);
			return (char) (((ans - '0') ^ 1) + '0');
		}
	}
}
