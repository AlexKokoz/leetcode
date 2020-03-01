package org.leetcode.problems;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001366_RankTeamsByVotes {
	public String rankTeams(String[] votes) {
		int npos = votes[0].length();
		Map<Character, int[]> map = new TreeMap<>();
		for (String vote : votes) {
			for (int i = 0; i < npos; i++) {
				char c = vote.charAt(i);
				int[] pos = map.get(c);
				if (pos == null)
					pos = new int[npos];
				pos[i]++;
				map.put(c, pos);
			}
		}

		Map<Character, int[]> sorted = map.entrySet().stream().sorted((o1, o2) -> {
			char key1 = o1.getKey();
			int[] val1 = o1.getValue();
			char key2 = o2.getKey();
			int[] val2 = o2.getValue();
			for (int i = 0; i < val1.length; i++) {
				if (val1[i] > val2[i])
					return -1;
				if (val1[i] < val2[i])
					return 1;
			}
			return Character.compare(key1, key2);
		}).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		StringBuilder sb = new StringBuilder();
		for (Character c : sorted.keySet())
			sb.append(c);
		return sb.toString();
	}
}
