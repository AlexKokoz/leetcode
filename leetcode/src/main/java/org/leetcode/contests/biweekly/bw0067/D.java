package org.leetcode.contests.biweekly.bw0067;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

}

class SORTracker {

	TreeMap<Integer, PriorityQueue<String>> minpq;
	TreeMap<Integer, PriorityQueue<String>> maxpq;
	int minCount, maxCount;

	public SORTracker() {
		minpq = new TreeMap<>();
		maxpq = new TreeMap<>();
	}

	public void add(String name, int score) {
		Map.Entry<Integer, PriorityQueue<String>> entry = minpq.firstEntry();
		if (entry != null && score > entry.getKey()) {
			minpq.computeIfAbsent(score, pq -> new PriorityQueue<>((a, b) -> b.compareTo(a))).add(name);
			maxpq.computeIfAbsent(entry.getKey(), pq -> new PriorityQueue<>()).add(entry.getValue().peek());
			entry.getValue().poll();
			if (entry.getValue().size() == 0)
				minpq.remove(entry.getKey());
		} else if (entry != null && score == entry.getKey() && name.compareTo(entry.getValue().peek()) < 0) {
			entry.getValue().add(name);
			maxpq.computeIfAbsent(score, pq -> new PriorityQueue<>()).add(entry.getValue().poll());
		} else {
			maxpq.computeIfAbsent(score, pq -> new PriorityQueue<>()).add(name);
		}

	}

	public String get() {
		Map.Entry<Integer, PriorityQueue<String>> entry = maxpq.lastEntry();
		int score = entry.getKey();
		String ans = entry.getValue().poll();
		minpq.computeIfAbsent(score, pq -> new PriorityQueue<>((a, b) -> b.compareTo(a))).add(ans);
		if (entry.getValue().isEmpty())
			maxpq.remove(score);
		return ans;
	}

}
