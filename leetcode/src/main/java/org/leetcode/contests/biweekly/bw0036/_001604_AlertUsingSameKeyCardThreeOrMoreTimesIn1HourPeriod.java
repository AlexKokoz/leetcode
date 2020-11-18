package org.leetcode.contests.biweekly.bw0036;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001604_AlertUsingSameKeyCardThreeOrMoreTimesIn1HourPeriod {
	public List<String> alertNames(String[] keyName, String[] keyTime) {
		int n = keyName.length;
		String[][] ai = new String[n][2];
		for (int i = 0; i < n; i++)
			ai[i] = new String[] { keyName[i], keyTime[i] };
		Arrays.sort(ai, (a, b) -> a[1].compareTo(b[1]));

		Set<String> uniq = new HashSet<>();
		Map<String, TreeSet<Integer>> map = new HashMap<>();
		outer: for(String[] rec : ai) {
			String name = rec[0];
			String stime = rec[1];
			int time = Integer.parseInt(stime.substring(0,2) + stime.substring(3));
			TreeSet<Integer> set = map.getOrDefault(rec[0], new TreeSet<>());
			set.add(time);
			int threshold = time - 100;
			map.put(name, set);
			Integer floor = time - 1;
			for(int i = 0; i < 2 ; i++) {
				floor = set.floor(floor);
				if (floor == null || floor < threshold) continue outer;
				floor--;
			}
			uniq.add(name);
		}
		
		List<String> ans = new ArrayList<>(uniq);
		Collections.sort(ans);
		return ans;
	}
}
