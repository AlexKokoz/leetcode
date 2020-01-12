package org.leetcode.contests.weekly.w0171;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001317_ConvertIntegerToTheSumOfTwoNoZeroIntegers {
	public int[] getNoZeroIntegers(int n) {
		int a = 1;
		int b = n -a;
		while(true) {
			if (isValid(a) && isValid(b)) break;
			a++;
			b--;
		}		
		return new int[] {a, b};
	}
	
	static boolean isValid(int a) {
		while(a > 0) {
			if (a % 10 == 0) return false;
			a /= 10;
		}
		return true;
	}
}
