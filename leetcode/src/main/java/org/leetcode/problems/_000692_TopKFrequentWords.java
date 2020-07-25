package org.leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000692_TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
			public int compare(String a, String b) {
				int fa = map.get(a);
				int fb = map.get(b);

				if (fa != fb)
					return fa - fb;
				return b.compareTo(a);
			}
		});

		for (String word : map.keySet()) {
			pq.add(word);
			if (pq.size() > k)
				pq.poll();
		}
		List<String> ans = new ArrayList<>(k);
		for (int i = 0; i < k; i++) {
			ans.add(i, pq.poll());
		}
		Collections.reverse(ans);
		return ans;
	}

}
