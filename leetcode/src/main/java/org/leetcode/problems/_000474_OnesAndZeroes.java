package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000474_OnesAndZeroes {

	public int findMaxForm(String[] strs, int z, int o) {
		int[][] dp = new int[z + 1][o + 1];

		for (String s : strs) {
			int[] req = countZeroesAndOnes(s);
			for (int iz = z; iz >= req[0]; iz--) {
				for (int io = o; io >= req[1]; io--) {
					if (req[0] <= iz && req[1] <= io) {
						dp[iz][io] = Math.max(dp[iz][io], dp[iz - req[0]][io - req[1]] + 1);
					}
				}
			}
		}

		return dp[z][o];
	}

	static int[] countZeroesAndOnes(String s) {
		int[] zo = new int[2]; // zo[0] -> #zeroes, zo[1] -> #ones
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '0')
				zo[0]++;
			else
				zo[1]++;
		}
		return zo;
	}

}
