package org.leetcode.problems;

import java.util.Arrays;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000473_MatchsticksToSquare {
	int[] nums;
	long perimeter;
	long side;

	public boolean makesquare(int[] nums) {
		int n = nums.length;
		if (n < 4)
			return false;
		Arrays.sort(nums);
		this.nums = nums;
		for (int x : nums)
			this.perimeter += x;
		if (this.perimeter % 4 != 0)
			return false;
		this.side = this.perimeter / 4;
		if (nums[n - 1] < side && nums[0] + nums[n - 1] > side)
			return false;
		return dfs(n - 1, this.side, this.perimeter, 1, 0);
	}

	boolean dfs(int curIndex, long remSide, long remPerimeter, int sideId, int seen) {

		int curStick = nums[curIndex];
		seen |= (1 << curIndex);

		if (curStick > remSide)
			return false;
		else if (curStick == remSide) {
			if (sideId == 4)
				return true;
			for (int i = 0; i < nums.length; i++) {
				if (seen << ~i < 0) // skip selected sticks
					continue;
				if (dfs(i, side, remPerimeter - curStick, sideId + 1, seen))
					return true;
			}
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (seen << ~i < 0) // not selected yet
					continue;
				if (dfs(i, remSide - curStick, remPerimeter - curStick, sideId, seen))
					return true;
			}
		}
		return false;
	}
}
