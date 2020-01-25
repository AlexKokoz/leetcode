package org.leetcode.contests.biweekly.bw0018;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001328_BreakAPalindrome {
	public String breakPalindrome(String s) {
		int n = s.length();
		String ans = "";
		if (n == 1)
			return ans;
		char[] chars = s.toCharArray();
		for (int i = 0; i < n; i++) {

			// changing the middle char in an odd palindrome results again to a palindrome
			if ((n & 1) == 1 && i == n / 2)
				continue;

			char cache = chars[i];
			chars[i] = cache == 'a' ? 'b' : 'a';
			String cur = String.valueOf(chars);
			chars[i] = cache;

			if (ans.equals("") || cur.compareTo(ans) == -1)
				ans = cur;

		}
		return ans;
	}
}
