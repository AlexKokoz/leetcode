package org.leetcode.contests.weekly.w0279;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	class Bitset {
		int[] set;
		boolean flipped;
		int ones;

		public Bitset(int size) {
			set = new int[size];
		}

		public void fix(int i) {
			if (flipped) {
				if (set[i] == 1)
					ones++;
				set[i] = 0;
			} else {
				if (set[i] == 0)
					ones++;
				set[i] = 1;
			}
		}

		public void unfix(int i) {
			if (flipped) {
				if (set[i] == 0)
					ones--;
				set[i] = 1;
			} else {
				if (set[i] == 1)
					ones--;
				set[i] = 0;
			}
		}

		public void flip() {
			flipped = !flipped;
			ones = set.length - ones;
		}

		public boolean all() {
			return ones == set.length;
		}

		public boolean one() {
			return ones > 0;
		}

		public int count() {
			return ones;
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < set.length; i++) {
				sb.append((flipped) ? 1 ^ set[i] : set[i]);
			}
			return sb.toString();
		}
	}
}
