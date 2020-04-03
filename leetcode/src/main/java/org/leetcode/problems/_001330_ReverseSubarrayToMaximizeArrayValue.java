package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001330_ReverseSubarrayToMaximizeArrayValue {

	// - ... | (l - 1) | l | ... | r | (r + 1) | ...
	// - we care about the indices l, r that we will swap, as the inner value, as
	// well as the side values will remain the same
	// - a swap adds value to the array value, only when the [l -1, l] segment
	// doesn't overlap with the [r, r + 1] segment; that is when a segment is lower
	// than the other without overlapping
	// - the added value will be double the difference between the min-max value of
	// the lower segment, and the max-min value of the higher segment
	// - corner cases: the best solution might be reversing a prefix or a suffix of
	// the array
	public int maxValueAfterReverse(int[] nums) {
		int n = nums.length;
		int minmax = Integer.MAX_VALUE; // the minimum of all pair-maxs
		int maxmin = Integer.MIN_VALUE; // the maximum of all pair-mins
		long ans = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			minmax = Math.min(minmax, Math.max(nums[i], nums[i + 1]));
			maxmin = Math.max(maxmin, Math.min(nums[i], nums[i + 1]));
			ans += Math.abs(nums[i] - nums[i + 1]);
		}
		int diff = Math.max(0, 2 * (maxmin - minmax));
		// corner case 1: check prefix swaps
		for (int i = 1; i < n - 1; i++)
			diff = Math.max(diff, Math.abs(nums[0] - nums[i + 1]) - Math.abs(nums[i] - nums[i + 1]));
		// corner case 2: check suffix swaps
		for (int i = n - 1; i > 0; i--)
			diff = Math.max(diff, Math.abs(nums[n - 1] - nums[i - 1]) - Math.abs(nums[i] - nums[i - 1]));
		return (int) (ans + diff);
	}
}
