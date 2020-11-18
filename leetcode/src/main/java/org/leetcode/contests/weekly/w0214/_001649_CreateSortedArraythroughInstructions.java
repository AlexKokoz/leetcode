package org.leetcode.contests.weekly.w0214;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001649_CreateSortedArraythroughInstructions {
	public int createSortedArray(int[] instructions) {
		int MAX = 0;
		for (int x : instructions)
			MAX = Math.max(MAX, x);
		BIT bit = new BIT(MAX + 1);
		int ans = 0;
		int mod = 1000000007;
		for (int x : instructions) {
			int left = x == 1 ? 0 : bit.sum(1, x - 1);
			int right = x == MAX ? 0 : bit.sum(x + 1, MAX);
			ans = (ans + Math.min(left, right)) % mod;
			bit.add(x, 1);
		}
		return ans;
	}

	static class BIT {

		private final int[] vals; // array for which the prefix sum is evaluated
		private final int[] tree; // represents the BIT
		private final int size; // the size of the input array
		private final static int mod = 1000000007;

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
			for (++i; i > 0; i -= i & -i) {
				sum += tree[i];
				if (sum >= mod)
					sum -= mod;
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
