package org.leetcode.contests.weekly.w0208;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001599_MaximumProfitOfOperatingACentennialWheel {
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
		int n = customers.length;
		int[] gondolas = new int[4];
		int waiting = 0;
		int maxValue = 0;
		int maxMoves = -1;
		int time = 0;
		int currentProfit = 0;
		int currentMoves = 0;
		int gondolaPos = 0;
		while (time < n || waiting > 0) {
			if (time < n)
				waiting += customers[time++];
			gondolas[gondolaPos] = 0;
			gondolas[gondolaPos] = Math.min(4, waiting);
			waiting -= gondolas[gondolaPos];
			currentProfit += gondolas[gondolaPos] * boardingCost;
			currentProfit -= runningCost;
			currentMoves++;
			gondolaPos++;
			if (gondolaPos == 4)
				gondolaPos = 0;
			if (currentProfit > maxValue) {
				maxValue = currentProfit;
				maxMoves = currentMoves;
			}
		}
		return maxMoves;
	}
}
