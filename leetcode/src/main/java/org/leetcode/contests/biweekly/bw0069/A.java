package org.leetcode.contests.biweekly.bw0069;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public String capitalizeTitle(String title) {
		String[] ws = title.split(" ");
		StringBuilder ans = new StringBuilder();
		String sep = "";
		for (String w : ws) {
			ans.append(sep);
			if (w.length() <= 2) {
				ans.append(w.toLowerCase());
			} else {
				ans.append(w.substring(0, 1).toUpperCase()).append(w.substring(1).toLowerCase());
			}
			sep = " ";
		}
		return ans.toString();
	}
}
