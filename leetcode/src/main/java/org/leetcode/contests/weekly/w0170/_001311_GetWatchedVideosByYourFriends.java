package org.leetcode.contests.weekly.w0170;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001311_GetWatchedVideosByYourFriends {

	public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {

		/*
		 * Find k level friends for source id using BFS.
		 */
		int population = friends.length;
		Queue<Integer> q = new LinkedList<>();
		q.add(id);
		boolean[] marked = new boolean[population];
		marked[id] = true;
		for (int i = 0; i < level; i++) {
			for (int j = 0, len = q.size(); j < len; j++) {
				int cur = q.poll();
				for (int f : friends[cur]) {
					if (!marked[f]) {
						marked[f] = true;
						q.add(f);
					}
				}
			}
		}

		/*
		 * Find frequencies of k-level videos
		 */
		final Map<String, Integer> freq = new HashMap<>();
		for (int f : q) {
			for (String vid : watchedVideos.get(f)) {
				if (freq.containsKey(vid)) {
					freq.put(vid, freq.get(vid) + 1);
				} else {
					freq.put(vid, 1);
				}
			}
		}

		/*
		 * Collect videos
		 */
		List<String> ans = new LinkedList<>();
		for (String vid : freq.keySet())
			ans.add(vid);

		/*
		 * Sort them by frequency and lexicographically
		 */
		Collections.sort(ans, new Comparator<String>() {
			public int compare(String a, String b) {
				int f1 = freq.get(a);
				int f2 = freq.get(b);
				if (f1 < f2)
					return -1;
				if (f1 > f2)
					return 1;
				return a.compareTo(b);
			}
		});

		return ans;
	}
}
