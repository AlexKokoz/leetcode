package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001375_BulbSwitcherIII {
	int[] bit;

	public int numTimesAllBlue(int[] light) {
		int n = light.length;
		bit = new int[n+1];
		int ans = 0;
		for (int i = 0; i < n; i++) {
			int l = light[i];
			add(1, l - 1);
			int sum = sum(l - 1);
			if (sum == i + 1) ans++;
		}
		return ans;
	}
	
	void add(int value, int index) {
		index++;
		while(index < bit.length) {
			bit[index] += value;
			index += index & (-index);
		}
	}
	
	int sum(int index) {
		int sum = 0;
		index++;
		while(index > 0) {
			sum += bit[index];
			index -= index & (-index);
		}
		return sum;
	}
}
