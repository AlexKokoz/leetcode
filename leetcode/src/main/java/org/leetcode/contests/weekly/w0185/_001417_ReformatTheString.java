package org.leetcode.contests.weekly.w0185;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001417_ReformatTheString {
	public String reformat(String s) {
		Queue<Character> letters = new LinkedList<>();
		Queue<Character> digits = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z')
				letters.add(c);
			else
				digits.add(c);
		}
		StringBuilder sb = new StringBuilder();
		if (Math.abs(letters.size() - digits.size()) > 1)
			return "";
		Queue<Character> driver = letters.size() >= digits.size() ? letters : digits;
		Queue<Character> passenger = letters.size() >= digits.size() ? digits : letters;
		for (int i = 0, len = driver.size(); i < len; i++) {
			sb.append(driver.poll());
			if (!passenger.isEmpty())
				sb.append(passenger.poll());
		}
		return sb.toString();
	}
}
