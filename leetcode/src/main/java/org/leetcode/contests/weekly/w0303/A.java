package org.leetcode.contests.weekly.w0303;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	/*
	// Time: O(n) Space: O(n)
	public char repeatedCharacter(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (set.contains(c))
				return c;
			set.add(c);
		}
		return '\0';
	}
	*/
	
	// Time: O(n) Space: O(1)
	public char repeatedCharacter(String s) {
		int mask = 0;
		int n = s.length();
		for (int i = 0; i < n; i++) {
			int b = s.charAt(i) - 'a';
			if (mask << ~b < 0)
				return s.charAt(i);
			mask |= 1 << b;
		}
		return '\0';
	}
}
