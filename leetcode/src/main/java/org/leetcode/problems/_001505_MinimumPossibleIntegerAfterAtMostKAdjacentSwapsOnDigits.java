package org.leetcode.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001505_MinimumPossibleIntegerAfterAtMostKAdjacentSwapsOnDigits {
	public String minInteger(String s, int k) {
		int n = s.length();
		StringBuilder sb = new StringBuilder();
		BinaryIndexedTree bit = new BinaryIndexedTree(n);
		@SuppressWarnings("unchecked")
		Queue<Integer>[] q = new Queue[10];

		// Add positions in each digit bucket
		for (int i = 0; i < q.length; i++)
			q[i] = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			q[s.charAt(i) - '0'].add(i);
		}

		for (int i = 0; i < n; i++) {
			for (int d = 0; d <= 9; d++) {
				if (q[d].isEmpty())
					continue;
				int pos = q[d].peek();
				int cost = pos + bit.sum(pos);
				if (cost <= k) {
					sb.append((char) ('0' + d));
					q[d].poll();
					k -= cost;
					
					// -1 will be added to each position ONCE
					// it contributes to calculating the eventual shift of a number after
					// some shifts have already occured
					bit.add(pos, -1);
					break;
				}
			}
		}

		return sb.toString();

	}

	static class BinaryIndexedTree {

		private final int[] vals; // array for which the prefix sum is evaluated
		private final int[] tree; // represents the BIT
		private final int size; // the count of elements of the input array

		/**
		 * Instantiates a Binary Indexed Tree with a number of elements.
		 * 
		 * @param n the number of elements
		 */
		public BinaryIndexedTree(int n) {
			size = n;
			vals = new int[size];
			tree = new int[size + 1];
		}

		/**
		 * Instantiates a Binary Indexed Tree with an array.
		 * 
		 * @param n the number of elements
		 */
		public BinaryIndexedTree(int[] nums) {
			size = nums.length;
			vals = Arrays.copyOf(nums, size);
			tree = new int[size + 1];
			for (int i = 0; i < size; i++) {
				this.update(i, vals[i]);
			}
		}

		/**
		 * Updates/Substitutes a value at a given zero-based index in Binary Indexed
		 * Tree.
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
		 * Adds a value at a given zero-based index in Binary Indexed Tree.
		 * 
		 * @param index the 0-based index to be updated
		 * @param value the new value
		 */
		public void add(int index, int value) {
			validate(index);
			vals[index] += value;
			for (int i = index + 1; i <= size; i += i & -i) {
				tree[i] += value;
			}
		}

		/**
		 * Returns the sum of vals[0..index].
		 * 
		 * @param index the inclusive 0-based index.
		 * @return the sum of vals[0..index]
		 */
		public int sum(int index) {
			validate(index);
			int sum = 0;
			for (int i = index + 1; i > 0; i -= i & -i) {
				sum += tree[i];
			}
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
			if (start > end) {
				throw new IllegalArgumentException(
						"start:" + start + " should not be greater than end:" + end);
			}
			if (start == 0) {
				return sum(end);
			}
			return sum(end) - sum(start - 1);
		}

		public int size() {
			return size;
		}

		@Override
		public String toString() {
			final StringBuilder sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append("index: ");
				sb.append(i);
				sb.append(" value: ");
				sb.append(vals[i]);
				sb.append(" sum: ");
				sb.append(sum(i));
				sb.append("\n");
			}
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
			if (index < 0 || index >= size) {
				throw new IllegalArgumentException(
						"start: " + index + " should be between 1 and " + (size - 1));
			}
		}
	}
}
