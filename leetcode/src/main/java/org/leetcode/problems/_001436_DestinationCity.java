package org.leetcode.problems;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001436_DestinationCity {
	public String destCity(List<List<String>> paths) {
		Set<String> set = new HashSet<>();
		for (List<String> path : paths)
			set.add(path.get(1));
		for (List<String> path : paths)
			set.remove(path.get(0));
		String ans = "";
		for (String city : set)
			ans = city;
		return ans;
	}
}
