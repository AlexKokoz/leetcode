package org.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001348_TweetCountsPerFrequency {
	class TweetCounts {

		private final Map<String, TreeSet<Integer>> tweet2time;

		public TweetCounts() {
			tweet2time = new HashMap<>();
		}

		public void recordTweet(String tweetName, int time) {
			TreeSet<Integer> set = tweet2time.get(tweetName);
			if (set == null)
				set = new TreeSet<>();
			set.add(time);
			tweet2time.put(tweetName, set);
		}

		public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {

			List<Integer> counts = new LinkedList<>();
			TreeSet<Integer> set = tweet2time.get(tweetName);
			if (set == null)
				return counts;
			startTime--;
			int delta = 0;
			if (freq.equals("minute"))
				delta = 60;
			else if (freq.equals("hour"))
				delta = 3600;
			else // freq.equals("day")
				delta = 86400;
			int start = startTime;
			int end = Math.min(endTime, start + delta - 1);
			while (start <= endTime) { // doubt about =
				int count = set.subSet(start, true, end, true).size();
				counts.add(count);
				start = end + 1;
				end = Math.min(endTime, start + delta - 1);
			}
			return counts;
		}
	}

}
