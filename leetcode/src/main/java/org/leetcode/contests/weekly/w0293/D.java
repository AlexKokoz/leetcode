package org.leetcode.contests.weekly.w0293;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {

	class CountIntervals {

		int count;
		TreeMap<Integer, Integer> map;

		public CountIntervals() {
			map = new TreeMap<>();
		}

		public void add(int left, int right) {
			// check for similar start
			if (map.containsKey(left)) {
				int right2 = map.get(left);
				if (right > right2) {
					count += right - right2;
				}
				map.put(left, right);
			} else {
				map.put(left, right);
				count += right - left + 1;
			}

			// check for previous overlap
			{
				Map.Entry<Integer, Integer> prevEntry = map.lowerEntry(left);
				if (prevEntry != null) {
					if (prevEntry.getValue() >= left) {
						int intersectionStart = Math.max(prevEntry.getKey(), left);
						int intersectionEnd = Math.min(prevEntry.getValue(), right);
						count -= intersectionEnd - intersectionStart + 1;
						map.put(prevEntry.getKey(), Math.max(prevEntry.getValue(), right));
						map.remove(left);
						left = Math.min(left, prevEntry.getKey());
						right = Math.max(right, prevEntry.getValue());

					}
				}
			}

			// merge following intervals
			{
				Map.Entry<Integer, Integer> nextEntry = map.higherEntry(left);
				while (nextEntry != null && nextEntry.getKey() <= right) {
					int intersectionStart = Math.max(nextEntry.getKey(), left);
					int intersectionEnd = Math.min(nextEntry.getValue(), right);
					count -= intersectionEnd - intersectionStart + 1;
					right = Math.max(nextEntry.getValue(), right);
					map.put(left, right);
					map.remove(nextEntry.getKey());
					nextEntry = map.higherEntry(left);
				}
			}
		}

		public int count() {
			return count;
		}
	}

}
