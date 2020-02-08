package org.leetcode.contests.biweekly.bw0019;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001344_AngleBetweenHandsOfAClock {
	public double angleClock(int hour, int minutes) {
		/*
		 * Explanation:
		 * 
		 * double minuteRatio = (double) minutes / 60;
		 * 
		 * double minutePos = (double) minRatio * 360;
		 * 
		 * double hourStartingPos = 360 * (double) hour / 12; // --- 30 * hour ---
		 * 
		 * double hourInterval = 360 / 12; // --- 30 ---
		 * 
		 * double minuteDev= minuteRatio * hourInterval; // --- 0.5 * minutes ---
		 * 
		 * double hourPos = hourStartingPos + minDev; // --- 30 * hour + 0.5 * minutes
		 * 
		 */
		double hourPos = (30 * hour + 0.5 * minutes);

		// double minutePos = (double) minRatio * 360;
		double minutePos = 6 * minutes;
		
		double diff = Math.abs(hourPos - minutePos);
		
		// return interior angle
		return Math.min(diff, 360 - diff);
	}
}
