package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000119_PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		return pascal(rowIndex);
	}

	List<Integer> pascal(int index) {
		List<Integer> pascal = new LinkedList<>();
		if (index == 0) {
			pascal.add(1);
			return pascal;
		}
		List<Integer> prevPascal = pascal(index - 1);
		pascal.add(1);
		for (int i = 1; i < prevPascal.size(); i++)
			pascal.add(prevPascal.get(i - 1) + prevPascal.get(i));
		pascal.add(1);
		return pascal;
	}
}
