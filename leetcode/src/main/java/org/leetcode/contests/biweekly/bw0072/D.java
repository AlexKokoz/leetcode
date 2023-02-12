package org.leetcode.contests.biweekly.bw0072;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	public long goodTriplets(int[] nums1, int[] nums2) {
		int n = nums1.length;
		long ans = 0;
		BIT bit = new BIT(n);
		int[] index2 = new int[n];
		for (int i = 0; i < n; i++)
			index2[nums2[i]] = i;
		for (int i1 = 0; i1 < n; i1++) {
			int i2 = index2[nums1[i1]];
			long left = bit.sum(i2);
			int right = (n - 1 - i2) - (bit.sum(n - 1) - bit.sum(i2));
			ans += left * right;
			bit.add(i2, 1);
		}
		return ans;
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
