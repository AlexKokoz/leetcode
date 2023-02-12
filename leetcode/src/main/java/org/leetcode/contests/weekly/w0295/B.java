package org.leetcode.contests.weekly.w0295;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public String discountPrices(String s, int discount) {
		String regex = "\\$\\d+";
		Pattern p = Pattern.compile(regex);
		StringBuilder sb = new StringBuilder();
		String[] tokens = s.split(" ");
		String sep = "";
		for (String token : tokens) {
			Matcher m = p.matcher(token);
			if (m.matches()) {
				double price = Double.parseDouble(token.substring(1));
				double discounted = price * (100 - discount) / 100;
				sb.append(sep).append("$").append(String.format("%.2f", discounted));
			} else {
				sb.append(sep).append(token);
			}
			sep = " ";
		}
		return sb.toString();
	}
}
