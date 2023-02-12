package org.leetcode.contests.weekly.w0301;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public boolean canChange(String start, String target) {
		int n = start.length();
		int is = 0, it = 0;
		while (is < n && it < n) {
			while (is < n && start.charAt(is) == '_')
				is++;
			while (it < n && target.charAt(it) == '_')
				it++;
			if (is == n && it == n)
				break;
			if (is == n || it == n)
				return false;
			if (is < n && start.charAt(is) != target.charAt(it))
				return false;
			if (start.charAt(is) == 'L') {
				if (is < it)
					return false;
			} else {
				if (is > it)
					return false;
			}
			is++;
			it++;
		}
		return true;
	}
}
