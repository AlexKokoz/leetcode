package org.leetcode.contests.weekly.w0208;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001600_ThroneInheritance {
	class ThroneInheritance {
		Map<String, Deque<String>> map;
		Set<String> dead;
		final String king;

		public ThroneInheritance(String kingName) {
			king = kingName;
			map = new HashMap<>();
			dead = new HashSet<>();
		}

		public void birth(String parentName, String childName) {
			map.computeIfAbsent(parentName, k -> new ArrayDeque<>()).addFirst(childName);
		}

		public void death(String name) {
			dead.add(name);
		}

		public List<String> getInheritanceOrder() {
			List<String> ans = new ArrayList<>();
			Deque<String> dfs = new ArrayDeque<>();
			dfs.add(king);
			while (!dfs.isEmpty()) {
				String cur = dfs.pollFirst();
				if (!dead.contains(cur))
					ans.add(cur);
				if (!map.containsKey(cur))
					continue;
				for (String child : map.get(cur))
					dfs.addFirst(child);
			}
			return ans;
		}
	}
}
