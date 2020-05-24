package org.leetcode.contests.weekly.w0190;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001455_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
	public int isPrefixOfWord(String sentence, String searchWord) {
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			if (words[i].indexOf(searchWord) == 0) {
				return i + 1;
			}
		}
		return -1;
	}
}
