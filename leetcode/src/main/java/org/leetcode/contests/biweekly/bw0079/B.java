package org.leetcode.contests.biweekly.bw0079;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public String largestWordCount(String[] ms, String[] ss) {
		int n = ms.length;
		String ans = null;
		int max = 0;
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int add = ms[i].split(" ").length;
			map.put(ss[i], map.getOrDefault(ss[i], 0) + add);
		}
		for (String name : map.keySet()) {
			if (map.get(name) > max || (map.get(name) == max && name.compareTo(ans) > 0)) {
				ans = name;
				max = map.get(name);
			}
		}
		return ans;
	}
}
