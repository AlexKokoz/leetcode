package org.leetcode.contests.biweekly.bw0083;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String bestHand(int[] ranks, char[] suits) {
		{
			int[] count = new int[26];
			for (char c : suits) {
				count[c - 'a']++;
				if (count[c - 'a'] == 5)
					return "Flush";
			}
		}

		{
			int[] count = new int[14];
			for (int c : ranks) {
				count[c]++;
				if (count[c] == 3)
					return "Three of a Kind";
			}
			for (int c : count) {
				if (c == 2)
					return "Pair";
			}
		}

		return "High Card";
	}
}
