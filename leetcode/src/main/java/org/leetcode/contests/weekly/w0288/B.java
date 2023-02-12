package org.leetcode.contests.weekly.w0288;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public String minimizeResult(String e) {
		StringBuilder sb = new StringBuilder();
		int n = e.length();
		int i = -1;
		int j = -1;
		int min = Integer.MAX_VALUE;
		int plus = e.indexOf("+");
		for (int l = 0; e.charAt(l) != '+'; l++) {
			for (int r = n - 1; e.charAt(r) != '+'; r--) {
				int a = l == 0 ? 1 : Integer.parseInt(e.substring(0, l));
				int b = Integer.parseInt(e.substring(l, plus));
				int c = Integer.parseInt(e.substring(plus + 1, r + 1));
				int d = r == n - 1 ? 1 : Integer.parseInt(e.substring(r + 1));
				int cand = a * (b + c) * d;
				if (cand < min) {
					min = cand;
					i = l;
					j = r;
				}
			}
		}
		sb.append(e.substring(0, i)).append("(").append(e.substring(i, j + 1)).append(")")
				.append(e.substring(j + 1));
		return sb.toString();
	}
}
