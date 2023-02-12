package org.leetcode.contests.weekly.w0216;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001662_CheckIfTwoStringArraysAreEquivalent {
	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (String word : word1)
			sb1.append(word);
		for (String word : word2)
			sb2.append(word);
		return sb1.toString().equals(sb2.toString());
	}
}
