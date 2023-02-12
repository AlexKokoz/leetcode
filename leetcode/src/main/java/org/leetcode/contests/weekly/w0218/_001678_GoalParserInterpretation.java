package org.leetcode.contests.weekly.w0218;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001678_GoalParserInterpretation {
	public String interpret(String command) {
		int n = command.length();
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < n) {
			if (command.charAt(i) == 'G') {
				sb.append('G');
				i++;
			}
			else if (command.charAt(i + 1) == ')') {
				sb.append('o');
				i += 2;
			} else {
				sb.append("al");
				i += 4;
			}
		}
		
		return sb.toString();
	}
}
