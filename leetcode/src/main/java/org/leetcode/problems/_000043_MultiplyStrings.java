package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000043_MultiplyStrings {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0"))
			return "0";
		if (num2.length() > num1.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		int n1 = num1.length();
		int n2 = num2.length();
		StringBuilder[] sbs = new StringBuilder[n2];
		for (int i2 = n2 - 1; i2 >= 0; i2--) {
			sbs[i2] = new StringBuilder();
			int d2 = num2.charAt(i2) - '0';
			if (d2 == 0)
				continue;
			for (int j = 0; j < n2 - i2 - 1; j++)
				sbs[i2].append('0');
			int carry = 0;
			for (int i1 = n1 - 1; i1 >= 0; i1--) {
				int d1 = num1.charAt(i1) - '0';
				int prod = d1 * d2 + carry;
				sbs[i2].append(prod % 10);
				carry = prod / 10;
			}
			if (carry > 0)
				sbs[i2].append(carry);
		}
		StringBuilder prod = new StringBuilder();
		int max = 0;
		for (StringBuilder sb : sbs)
			max = Math.max(max, sb.length());
		int carry = 0;
		for (int i = 0; i < max; i++) {
			int dsum = carry;
			for (StringBuilder sb : sbs) {
				if (i >= sb.length())
					continue;
				int d = sb.charAt(i) - '0';
				dsum += d;
			}
			prod.append(dsum % 10);
			carry = dsum / 10;
		}
		prod = new StringBuilder((carry != 0 ? carry : "") + prod.reverse().toString());

		return prod.toString();
	}
}
