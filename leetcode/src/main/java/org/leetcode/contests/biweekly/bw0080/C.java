package org.leetcode.contests.biweekly.bw0080;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {

	public boolean matchReplacement(String s, String sub, char[][] mappings) {
		int ns = s.length();
		int nsub = sub.length();
		Map<Character, Set<Character>> map = new HashMap<>();
		for (char[] mapping : mappings) {
			map.computeIfAbsent(mapping[0], x -> new HashSet<>()).add(mapping[1]);
		}
		outer: for (int i = 0; i + nsub <= ns; i++) {
			for (int j = 0; j < nsub; j++) {
				char target = s.charAt(i + j);
				char have = sub.charAt(j);
				if (have != target) {
					if (map.containsKey(have)) {
						if (!map.get(have).contains(target)) {
							continue outer;
						}
					} else {
						continue outer;
					}
				}
			}
			return true;
		}
		return false;
	}
}
