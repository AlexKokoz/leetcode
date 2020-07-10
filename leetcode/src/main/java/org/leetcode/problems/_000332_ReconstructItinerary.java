package org.leetcode.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000332_ReconstructItinerary {

	public List<String> findItinerary(List<List<String>> tickets) {
		List<String> ans = new LinkedList<>();
		Map<String, List<String>> map = new HashMap<>();
		int n = tickets.size();

		for (List<String> ticket : tickets) {
			map.computeIfAbsent(ticket.get(0), k -> new LinkedList<>()).add(ticket.get(1));
		}
		ans.add("JFK");
		String cur = "JFK";
		while (ans.size() <= n) {
			cur = getNext(cur, map);
			ans.add(cur);
		}
		return ans;
	}

	String getNext(String from, Map<String, List<String>> map) {
		List<String> dests = map.get(from);
		if (dests.size() == 1)
			return dests.remove(0);
		List<String> candidates = new LinkedList<>();

		for (String dest : dests) {
			Map<String, List<String>> map2 = copy(map);
			if (cycles(from, dest, map2))
				candidates.add(dest);
		}
		Collections.sort(candidates);
		String next = candidates.get(0);
		dests.remove(next);
		return next;
	}

	boolean cycles(String target, String cur, Map<String, List<String>> map) {
		if (cur == null)
			return false;
		if (cur.equals(target))
			return true;
		List<String> dests = map.get(cur);
		if (dests == null)
			return false;
		boolean found = false;
		for (int i = 0; i < dests.size(); i++) {
			if (dests.get(i) == null)
				continue;
			cur = dests.get(i);
			dests.set(i, null);
			found |= cycles(target, cur, map);
			if (found)
				return true;
		}
		return false;
	}

	Map<String, List<String>> copy(Map<String, List<String>> map) {
		Map<String, List<String>> copy = new HashMap<>();
		for (String key : map.keySet()) {
			copy.computeIfAbsent(key, k -> new LinkedList<>(map.get(key)));
		}
		return copy;
	}
}
