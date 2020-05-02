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
	public boolean checkIfExist(int[] nums) {
		Set<Integer> seen = new HashSet<>();
		for (int num : nums) {
			if (seen.contains(num))
				return true;
			seen.add(2 * num);
			if ((num & 1) == 0) // even
				seen.add(num / 2);
		}
		return false;
	}
}
