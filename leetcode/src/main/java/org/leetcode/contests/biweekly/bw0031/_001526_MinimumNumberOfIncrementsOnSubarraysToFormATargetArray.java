package org.leetcode.contests.biweekly.bw0031;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001526_MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {
	// sum of (peak - prevBottom)
	public int minNumberOperations(int[] target) {
		int n = target.length;
		int ans = 0;
		int bottom = 0;
		int pre = 0;
		int i = 0;
		while(i < n) {
			while(i < n && target[i] >= target[pre]) {
				i++;
				pre = i - 1;
			}
			ans += target[i - 1] - bottom;
			while(i < n && target[i] <= target[pre]) {
				i++;
				pre = i - 1;
			}
			bottom = target[i - 1];
		}
		
		return ans;
	}
}
