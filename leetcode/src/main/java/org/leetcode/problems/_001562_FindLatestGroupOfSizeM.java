package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001562_FindLatestGroupOfSizeM {
	public int findLatestStep(int[] arr, int m) {
		int n = arr.length;
		int[] bin = new int[n];
		for (int i : arr)
			bin[i - 1] = 1;
		int l = 0;
		int sum = bin[0] == 1 ? 1 : 0;
		while (l < n) {
			int r = l + 1;
			while (r < n && bin[r] == 1) {
				sum++;
				r++;
			}
			if (sum == m)
				return n;
			l = r;
		}

		System.out.println(Arrays.toString(bin));
		BIT bit = new BIT(bin);
		for (int i = n - 1; i >= 0; i--) {
			int pos = arr[i] - 1;
			bit.add(pos, -1);
			bin[pos] = 0;
			int toLeft = pos > m ? bit.sum(pos - m, pos - 1) : bit.sum(pos - 1);
			if (toLeft == m) {
				if (pos - m - 1 >= 0) {
					if (bin[pos - m - 1] == 0)
						return i + 1;
				} else {
					return i + 1;
				}
			}

			int toRight = pos < n - m - 1 ? bit.sum(pos + 1, pos + m) : bit.sum(pos + 1, n - 1);
			if (toRight == m) {
				if (pos + m + 1 < n) {
					if (bin[pos + m + 1] == 0)
						return i + 1;
				} else {
					return i + 1;
				}
			}
		}

		return -1;
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
