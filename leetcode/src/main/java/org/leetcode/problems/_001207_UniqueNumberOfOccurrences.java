package org.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001207_UniqueNumberOfOccurrences {
	public boolean uniqueOccurrences(int[] arr) {
		int[] occurrencies = new int[2001];
		for (int num : arr)
			occurrencies[num + 1000]++;
		Set<Integer> uniqueOccurrencies = new HashSet<>();
		for (int occurrence : occurrencies) {
			if (occurrence == 0)
				continue;
			if (uniqueOccurrencies.contains(occurrence))
				return false;
			else
				uniqueOccurrencies.add(occurrence);
		}
		return true;
	}
}
