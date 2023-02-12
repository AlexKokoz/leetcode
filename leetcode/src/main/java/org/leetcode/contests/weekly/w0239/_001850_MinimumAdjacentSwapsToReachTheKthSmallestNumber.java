package org.leetcode.contests.weekly.w0239;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001850_MinimumAdjacentSwapsToReachTheKthSmallestNumber {
	public int getMinSwaps(String num, int k) {
		String wonderful = wonderful(num, k);
		// System.out.println(wonderful);
		BIT bit = new BIT(num.length());
		int ans = 0;
		@SuppressWarnings("unchecked")
		LinkedList<Integer>[] poss = new LinkedList[10];
		for (int i = 0; i < poss.length; i++)
			poss[i] = new LinkedList<>();
		int i = 0;
		while (i < num.length() && num.charAt(i) == wonderful.charAt(i))
			i++;
		int j = i;
		while (j < num.length()) {
			poss[num.charAt(j) - '0'].add(j);
			j++;
		}
		while (i < num.length()) {
			char cur = wonderful.charAt(i);
			int pos = poss[cur - '0'].poll();
			int cost = (bit.sum(pos, num.length() - 1));
			bit.add(pos, 1);
			pos += cost;
			ans += Math.abs(pos - i);
			i++;
		}
		return ans;
	}

	String wonderful(String s, int k) {
		char[] ss = s.toCharArray();
		for (int i = 0; i < k; i++) {
			next(ss);
		}
		return String.valueOf(ss);
	}

	void next(char[] s) {
		TreeMap<Character, Integer> map = new TreeMap<>();
		for (int i = s.length - 1; i >= 0; i--) {
			Map.Entry<Character, Integer> entry = map.higherEntry(s[i]);
			if (entry != null) {
				swap(i, entry.getValue(), s);
				Arrays.sort(s, i + 1, s.length);
				break;
			}
			map.put(s[i], i);
		}
	}

	void swap(int i, int j, char[] a) {
		char swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	static class BIT {

		private final int[] vals; // array for which the prefix sum is evaluated
		private final int[] tree; // represents the BIT
		private final int size; // the size of the input array

		/**
		 * Instantiates a Binary Indexed Tree with an empty array.
		 * 
		 * @param n the number of elements
		 */
		public BIT(int n) {
			size = n;
			vals = new int[size];
			tree = new int[size + 1];
		}

		/**
		 * Instantiates a Binary Indexed Tree with an array.
		 * 
		 * @param n the number of elements
		 */
		public BIT(int[] nums) {
			size = nums.length;
			vals = new int[size];
			tree = new int[size + 1];
			for (int i = 0; i < size; i++)
				this.add(i, nums[i]);
		}

		/**
		 * Updates/Substitutes a value at a specified 0-based index in the Binary
		 * Indexed Tree.
		 * 
		 * @param index the 0-based index to be updated/substituted
		 * @param value the new value
		 */
		public void update(int index, int value) {
			validate(index);
			final int diff = value - vals[index];
			add(index, diff);
		}

		/**
		 * Adds a value at a specified 0-based index in the Binary Indexed Tree.
		 * 
		 * @param i     the 0-based index to be updated
		 * @param value the new value
		 */
		public void add(int i, int value) {
			validate(i);
			vals[i] += value;
			for (++i; i <= size; i += i & -i)
				tree[i] += value;
		}

		/**
		 * Returns the sum of vals[0..index].
		 * 
		 * @param i the inclusive 0-based index.
		 * @return the sum of vals[0..index]
		 */
		public int sum(int i) {
			validate(i);
			int sum = 0;
			for (++i; i > 0; i -= i & -i)
				sum += tree[i];
			return sum;
		}

		/**
		 * Returns the sum of vals[start..end].
		 * 
		 * @param start the start index
		 * @param end   the end index
		 * @return the sum of vals[start..end].
		 */
		public int sum(int start, int end) {
			validate(start);
			validate(end);
			if (start > end)
				throw new IllegalArgumentException(
						"start:" + start + " should not be greater than end:" + end);
			return start == 0 ? sum(end) : sum(end) - sum(start - 1);
		}

		public int size() {
			return size;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++)
				sb.append("index: ").append(i).append(" value: ").append(vals[i]).append(" sum: ")
						.append(sum(i)).append("\n");
			return sb.toString();
		}

		/**********************************************************************
		 * *
		 * 
		 * PRIVATE METHODS
		 * 
		 * *
		 **********************************************************************/

		/**
		 * Validates a 0 based index with respect to the values array vals.
		 * 
		 * @param index the 0-based index to validate
		 */
		private void validate(int index) {
			if (index < 0 || index >= size)
				throw new IllegalArgumentException(
						"start: " + index + " should be between 0 and " + (size - 1));
		}
	}

}
