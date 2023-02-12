package org.leetcode.contests.weekly.w0301;

import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	class SmallestInfiniteSet {
		TreeSet<Integer> set;

		public SmallestInfiniteSet() {
			set = new TreeSet<>();
			for (int i = 1; i <= 2000; i++)
				set.add(i);
		}

		public int popSmallest() {
			int ans = set.first();
			set.remove(ans);
			return ans;
		}

		public void addBack(int num) {
			set.add(num);
		}
	}
}
