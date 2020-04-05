package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001404_NumberOfStepsToReduceNumberInBinaryRepresentationToOne {
	public int numSteps(String s) {
		StringBuilder sb = new StringBuilder();
		int steps = 0;
		while (sb.length() > 1) {
			if (sb.charAt(sb.length() - 1) == '0')
				sb.deleteCharAt(sb.length() - 1);
			else {
				boolean carry = true;
				for (int i = sb.length() - 1; i >= 0 && carry; i--) {
					if (sb.charAt(i) == '1')
						sb.setCharAt(i, '0');
					else {
						sb.setCharAt(i, '1');
						carry = false;
					}
				}
				if (carry)
					sb.insert(0, '1');
			}
			steps++;
		}
		return steps;

	}
}
