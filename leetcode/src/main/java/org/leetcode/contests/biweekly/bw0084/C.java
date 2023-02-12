package org.leetcode.contests.biweekly.bw0084;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long taskSchedulerII(int[] tasks, int space) {
		int n = tasks.length;
		long ans = 0;
		Map<Integer, Long> last = new HashMap<>();
		for (int i = 0; i < n; i++) {
			if (!last.containsKey(tasks[i])) {
				ans++;
			} else {
				long padding = Math.max(0, space - (ans - last.get(tasks[i])));
				ans += 1 + padding;
			}
			last.put(tasks[i], ans);
		}
		return ans;

	}
}
