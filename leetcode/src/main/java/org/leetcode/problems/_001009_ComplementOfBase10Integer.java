package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001009_ComplementOfBase10Integer {
	public int bitwiseComplement(int N) {
		char[] bits = Integer.toBinaryString(N).toCharArray();
		for (int i = 0; i < bits.length; i++) {
			bits[i] = bits[i] == '1' ? '0' : '1';
		}
		return Integer.parseInt(String.valueOf(bits), 2);
	}
}
