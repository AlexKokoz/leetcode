package org.leetcode.contests.biweekly.bw0076;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	class ATM {
		int[] count;
		final int[] denom = { 20, 50, 100, 200, 500 };

		public ATM() {
			count = new int[5];
		}

		public void deposit(int[] banknotesCount) {
			for (int i = 0; i < banknotesCount.length; i++) {
				count[i] += banknotesCount[i];
			}
		}

		public int[] withdraw(int amount) {
			int[] ans = new int[5];
			for (int i = count.length - 1; i >= 0; i--) {
				int take = Math.min(count[i], amount / denom[i]);
				count[i] -= take;
				ans[i] = take;
				amount -= take * denom[i];
			}

			if (amount > 0) {
				for (int i = 0; i < count.length; i++) {
					count[i] += ans[i];
				}
				return new int[] { -1 };
			}
			return ans;
		}
	}
}
