package org.leetcode.contests.biweekly.bw0042;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001702_MaximumBinaryStringAfterChange {
	public String maximumBinaryString(String binary) {
		int n = binary.length();
		char[] ans = new char[n];
		int zero = binary.indexOf('0');
		if (zero < 0)
			return binary;
		int ones = 0;
		for (int i = zero; i < n; i++)
			if (binary.charAt(i) == '1')
				ones++;
		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1 - ones)
				ans[i] = '0';
			else
				ans[i] = '1';
		}
		return String.valueOf(ans);
	}
}
