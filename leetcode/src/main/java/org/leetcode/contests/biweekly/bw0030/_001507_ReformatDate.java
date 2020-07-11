package org.leetcode.contests.biweekly.bw0030;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001507_ReformatDate {
	public String reformatDate(String date) {
		String[] months = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };
		String[] tokens = date.split(" ");

		String dd = (tokens[0].length() == 4 ? "" : "0")
				+ (tokens[0].length() == 4 ? tokens[0].substring(0, 2) : tokens[0].charAt(0));
		
		int month = 0;
		for (int i = 0; i < months.length; i++) {
			if (months[i].equals(tokens[1])) {
				month = i + 1;
				break;
			}
		}

		String mm = Integer.toString(month);
		mm = mm.length() == 1 ? "0" : "" + mm;
		String yy = tokens[2];
		return yy + "-" + mm + "-" + dd;
	}
}
