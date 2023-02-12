package org.leetcode.contests.weekly.w0281;

import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public String repeatLimitedString(String s, int repeatLimit) {
		StringBuilder sb = new StringBuilder();
		int[] count = new int[26];
		PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
			if (count[c - 'a'] == 1)
				pq.add(c);
		}
		while (!pq.isEmpty()) {
			char cur = pq.poll();
			if (count[cur - 'a'] <= repeatLimit) {
				for (int i = 0; i < count[cur - 'a']; i++) {
					sb.append(cur);
				}
				count[cur - 'a'] = 0;
				continue;
			} else {
				for (int i = 0; i < repeatLimit; i++) {
					sb.append(cur);
				}
				count[cur - 'a'] -= repeatLimit;
				if (!pq.isEmpty()) {
					char next = pq.poll();
					sb.append(next);
					count[next - 'a']--;
					if (count[next - 'a'] > 0) {
						pq.add(next);
					}
				} else {
					break;
				}
				pq.add(cur);
			}
		}
		return sb.toString();
	}
}
