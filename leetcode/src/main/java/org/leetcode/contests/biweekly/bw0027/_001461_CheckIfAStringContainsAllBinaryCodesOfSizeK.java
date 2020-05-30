package org.leetcode.contests.biweekly.bw0027;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001461_CheckIfAStringContainsAllBinaryCodesOfSizeK {
	public boolean hasAllCodes(String s, int k) {
		Set<String> set = new HashSet<>();
		for (int i = 0; i <= s.length() - k; i++) {
			String sub = s.substring(i, i + k);
			set.add(sub);
		}
		return set.size() == (1 << k);
	}
}
