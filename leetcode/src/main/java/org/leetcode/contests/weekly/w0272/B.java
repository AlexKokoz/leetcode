package org.leetcode.contests.weekly.w0272;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public String addSpaces(String s, int[] spaces) {
		StringBuilder sb = new StringBuilder();
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < spaces.length; i++) {
			set.add(spaces[i]);
		}
		int si = 0;
		while (si < s.length()) {
			if (!set.contains(si)) {
				sb.append(s.charAt(si));
				si++;
			} else {
				sb.append(" ");
				sb.append(s.charAt(si));
				si++;
			}
		}
		return sb.toString();
	}
}
