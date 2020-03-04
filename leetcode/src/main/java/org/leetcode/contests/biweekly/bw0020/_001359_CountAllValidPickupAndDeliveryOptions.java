package org.leetcode.contests.biweekly.bw0020;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001359_CountAllValidPickupAndDeliveryOptions {
	public int countOrders(int n) {
		final long mod = 1000000007;
		long ans = 1;
		for (int i = 2; i <= n; i++) {
			// for 2(n-1) current options(n - 1 pairs), the next pair will have 2n - 1
			// positions(all inbetween and the 2 edges) for the first one
			// and 2n for the second one; so (2n - 1)2n, and since we want the cases where
			// the pickup is before delivery we divide by 2 => (2n - 1)n
			long perm = ((2 * i - 1) * i) % mod;
			ans = (ans * perm) % mod;
		}
		return (int) ans;
	}
}
