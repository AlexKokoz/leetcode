package org.leetcode.contests.weekly.w0220;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001694_ReformatPhoneNumber {
	public String reformatNumber(String number) {
		StringBuilder sb = new StringBuilder();
		for (char c : number.toCharArray())
			if (Character.isDigit(c))
				sb.append(c);

		StringBuilder ans = new StringBuilder();
		int i = 0;
		while (sb.length() - i > 4) {
			ans.append(sb.charAt(i)).append(sb.charAt(i + 1)).append(sb.charAt(i + 2)).append("-");
			i += 3;
		}
		if (sb.length() - i + 1 < 4) {
			for (int j = i; j < sb.length(); j++)
				ans.append(sb.charAt(j));
		} else {
			ans.append(sb.charAt(i));
			ans.append(sb.charAt(i + 1));
			ans.append("-");
			ans.append(sb.charAt(i + 2));
			ans.append(sb.charAt(i + 3));
		}
		return ans.toString();
	}
}
