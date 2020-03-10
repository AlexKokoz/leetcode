package org.leetcode.problems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000010_RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		Pattern pattern = Pattern.compile(p);
		Matcher matcher = pattern.matcher(s);
		return matcher.matches();
	}
}
