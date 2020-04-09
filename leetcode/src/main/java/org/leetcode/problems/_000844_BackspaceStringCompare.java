package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000844_BackspaceStringCompare {
	
	// start iterating from the end of the strings and compare each character that
	// will be displayed, not considering those that will be deleted by backspace
	public boolean backspaceCompare(String S, String T) {
		
		int sindex = S.length() - 1; // current index in s
		int tindex = T.length() - 1; // current index in t
		int scount = 0; // current backspace count in s
		int tcount = 0; // current backspace count in t

		while (true) {

			// find next character that will be displayed from S
			while (sindex >= 0 && (scount > 0 || S.charAt(sindex) == '#')) {
				if (S.charAt(sindex) == '#')
					scount++;
				else
					scount--;
				sindex--;
			}

			// find next character that will be displayed from T
			while (tindex >= 0 && (tcount > 0 || T.charAt(tindex) == '#')) {
				if (T.charAt(tindex) == '#')
					tcount++;
				else
					tcount--;
				tindex--;
			}
			
			// both strings are 'backspace equal'
			if (sindex < 0 && tindex < 0)             break; 

			// one of S, T has at least one more character to be displayed than the other
			if (sindex < 0 ^ tindex < 0)              return false; 

			// different characters
			if (S.charAt(sindex) != T.charAt(tindex)) return false; 

			// prepare the indices to search for the next characters to be displayed in both
			// S, T
			sindex--;
			tindex--;
		}

		return true;
	}
}
