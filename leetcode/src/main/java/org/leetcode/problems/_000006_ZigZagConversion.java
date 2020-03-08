package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000006_ZigZagConversion {
	@SuppressWarnings("unchecked")
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		Queue<Character>[] rows = new Queue[numRows];
		for (int i = 0; i < numRows; i++)
			rows[i] = new LinkedList<>();

		int currentRow = 0;
		int step = -1;
		for (int i = 0; i < s.length(); i++) {
			if (currentRow == 0 || currentRow == numRows - 1)
				step *= -1;
			char c = s.charAt(i);
			rows[currentRow].add(c);
			currentRow += step;
		}

		StringBuilder ans = new StringBuilder();
		for (Queue<Character> row : rows) {
			while (!row.isEmpty())
				ans.append(row.poll());
		}
		return ans.toString();
	}
}
