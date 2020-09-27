package org.leetcode.problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000315_CountOfSmallerNumbersAfterSelf {

	int[] ans;

	public List<Integer> countSmaller(int[] nums) {
		int n = nums.length;
		ans = new int[n];
		Pair[] pairs = new Pair[n];
		for (int i = 0; i < n; i++)
			pairs[i] = new Pair(nums[i], i);
		mergesort(pairs);
		return Arrays.stream(ans).boxed().collect(Collectors.toList());
	}

	Pair[] mergesort(Pair[] pairs) {
		int n = pairs.length;
		if (n <= 1)
			return pairs;
		Pair[] a = new Pair[n / 2];
		Pair[] b = new Pair[n - n / 2];
		for (int i = 0; i < n / 2; i++)
			a[i] = pairs[i];
		for (int i = 0; i < n - n / 2; i++)
			b[i] = pairs[i + n / 2];
		return merge(mergesort(a), mergesort(b));
	}

	Pair[] merge(Pair[] a, Pair[] b) {
		Pair[] c = new Pair[a.length + b.length];
		int i = 0, j = 0;
		for (int k = 0; k < c.length; k++) {
			if (i == a.length)                                         c[k] = b[j++];
			else if (j == b.length)            { ans[a[i].index] += j; c[k] = a[i++]; } 
			else if (a[i].value <= b[j].value) { ans[a[i].index] += j; c[k] = a[i++]; }
			else                                                       c[k] = b[j++];
		}
		return c;
	}

	class Pair {
		int value;
		int index;

		public Pair(int value, int index) {
			this.value = value;
			this.index = index;
		}

		public String toString() {
			return "v = " + value + " i = " + index;
		}
	}
	
}
