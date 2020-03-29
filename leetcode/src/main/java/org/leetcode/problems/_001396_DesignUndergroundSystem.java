package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001396_DesignUndergroundSystem {
	class UndergroundSystem {
		Map<String, Map<String, Double>> sums;
		Map<String, Map<String, Integer>> counts;
		Map<Integer, Pair> checkedIn;

		public UndergroundSystem() {
			sums = new HashMap<>();
			counts = new HashMap<>();
			checkedIn = new HashMap<>();
		}

		public void checkIn(int id, String stationName, int t) {
			checkedIn.put(id, new Pair(t, stationName));
		}

		public void checkOut(int id, String stationName, int t) {
			Pair pair = checkedIn.get(id);
			String src = pair.src;
			int startTime = pair.time;
			
			Map<String, Double> dest2sum = sums.getOrDefault(src, new HashMap<>());
			double sum = dest2sum.getOrDefault(stationName, 0.0);
			sum += t - startTime;
			dest2sum.put(stationName, sum);
			sums.put(src, dest2sum);

			Map<String, Integer> dest2count = counts.getOrDefault(src, new HashMap<>());
			int count = dest2count.getOrDefault(stationName, 0);
			count++;
			dest2count.put(stationName, count);
			counts.put(src, dest2count);
		}

		public double getAverageTime(String startStation, String endStation) {
			Map<String, Double> dest2sum = sums.get(startStation);
			double sum = dest2sum.get(endStation);
			Map<String, Integer> dest2count = counts.get(startStation);
			double count = dest2count.get(endStation);
			return sum / count;
		}
		
		class Pair {
			int time;
			String src;

			public Pair(int time, String src) {
				this.time = time;	
				this.src = src;
			}
		}
	}
}
