package org.leetcode.contests.biweekly.bw0094;

import java.util.ArrayList;
import java.util.Arrays;
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
public class B {
	public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
			int[] student_id, int k) {
		Set<String> pos = new HashSet<>();
		for (String s : positive_feedback) {
			pos.add(s);
		}
		Set<String> neg = new HashSet<>();
		for (String s : negative_feedback) {
			neg.add(s);
		}
		Map<Integer, Integer> map = new HashMap<>();
		int n = report.length;
		for (int i = 0; i < n; i++) {
			for (String w : report[i].split(" ")) {
				int add = pos.contains(w) ? 3 : neg.contains(w) ? -1 : 0;
				map.put(student_id[i], map.getOrDefault(student_id[i], 0) + add);
			}
		}
		int[][] ai = new int[map.size()][];
		int p = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ai[p++] = new int[] { entry.getValue(), entry.getKey() };
		}
		Arrays.sort(ai, (a, b) -> {
			if (a[0] != b[0]) {
				return Integer.compare(b[0], a[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		ai = Arrays.copyOf(ai, Math.min(k, ai.length));
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < ai.length; i++) {
			ans.add(ai[i][1]);
		}
		return ans;
	}
}
