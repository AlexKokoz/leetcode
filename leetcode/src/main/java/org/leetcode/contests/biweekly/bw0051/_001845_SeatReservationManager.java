package org.leetcode.contests.biweekly.bw0051;

import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001845_SeatReservationManager {
	class SeatManager {

		TreeSet<Integer> set;
		int n;

		public SeatManager(int n) {
			set = new TreeSet<>();
			for (int i = 1; i <= n; i++) {
				set.add(i);
			}
		}

		public int reserve() {
			int ret = set.first();
			set.remove(ret);
			return ret;
		}

		public void unreserve(int seatNumber) {
			set.add(seatNumber);
		}
	}
}
