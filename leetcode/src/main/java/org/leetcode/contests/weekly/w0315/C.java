package org.leetcode.contests.weekly.w0315;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public boolean sumOfNumberAndReverse(int num) {
		for (int i = 0; i <= num; i++) {
			int j = rev(i);
			if (i + j == num)
				return true;
		}
		return false;
	}

	int rev(int num) {
		int rev = Integer.parseInt(new StringBuilder().append(num).reverse().toString());
		return rev;
	}
}
