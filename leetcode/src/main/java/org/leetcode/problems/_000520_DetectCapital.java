package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000520_DetectCapital {
	public boolean detectCapitalUse(String word) {
		int capitals = 0;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (Character.isUpperCase(c))
				capitals++;
			if (capitals > 1 && capitals != i + 1)
				return false;
		}
		if (capitals == 1 && !Character.isUpperCase(word.charAt(0)))
			return false;
		return true;
	}

}
