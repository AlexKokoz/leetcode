package org.leetcode.contests.weekly.w0212;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001629_SlowestKey {
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		int n = releaseTimes.length;
		char[] chars = keysPressed.toCharArray();
		char maxChar = '\0';
		int maxVal = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int duration = i == 0 ? releaseTimes[0] : releaseTimes[i] - releaseTimes[i - 1];
			if (duration > maxVal) {
				maxVal = duration;
				maxChar = chars[i];
			} else if (duration == maxVal && chars[i] > maxChar) {
				maxChar = chars[i];
			}
		}
		return maxChar;
	}
}
