package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000012_IntegerToRoman {
	public String intToRoman(int num) {
		int[] vals = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String[] chars = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		StringBuilder sb = new StringBuilder();
		outer: while (num > 0) {
			for (int i = 0; i < vals.length; i++) {
				if (num >= vals[i]) {
					sb.append(chars[i]);
					num -= vals[i];
					continue outer;
				}
			}
		}
		return sb.toString();
	}
}
