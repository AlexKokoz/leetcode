package org.leetcode.contests.weekly.w0208;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001598_CrawlerLogFolder {
	public int minOperations(String[] logs) {
		int pos = 0;
		for (String log : logs) {
			switch (log) {
			case "../":
				if (pos > 0)
					pos--;
				break;
			case "./":
				break;
			default:
				pos++;

			}
		}
		return pos;
	}
}
