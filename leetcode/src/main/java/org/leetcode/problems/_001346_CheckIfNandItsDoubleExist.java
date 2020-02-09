package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001346_CheckIfNandItsDoubleExist {
	public boolean checkIfExist(int[] arr) {
		Set<Double> set = new HashSet<>();
		for (int x : arr) {
			if (set.contains((double)x)) return true;
			set.add(x * 2.0);
			set.add(x / 2.0);
		}
		return false;
	}
}
