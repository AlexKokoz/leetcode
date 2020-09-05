package org.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _000969_PancakeSorting {
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> ans = new ArrayList<>();
		int n = A.length;
		if (n <= 1)
			return ans;
		Map<Integer, Integer> map = new HashMap<>();
		boolean sorted = true;

		// check if ascending
		for (int i = 1; i < n; i++)
			if (A[i] < A[i - 1]) {
				sorted = false;
				break;
			}
		if (sorted)
			return ans;

		for (int i = 0; i < n; i++)
			map.put(A[i], i);

		for (int num = n; num >= 1; num--) {
			int pos = map.get(num);
			if (pos == num - 1)
				continue;
			ans.add(pos + 1);
			for (int j = 0; j <= pos / 2; j++) {
				swap(j, pos - j, A);
				map.put(A[j], j);
				map.put(A[pos - j], pos - j);
			}
			ans.add(num);
			for (int j = 0; j <= (num - 1) / 2; j++) {
				swap(j, num - 1 - j, A);
				map.put(A[j], j);
				map.put(A[num - 1 - j], num - 1 - j);
			}
		}
		return ans;
	}

	static void swap(int i, int j, int[] a) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
