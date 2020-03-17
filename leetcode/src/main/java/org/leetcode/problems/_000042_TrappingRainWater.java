package org.leetcode.problems;

import java.util.*;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000042_TrappingRainWater {
	public int trap(int[] height) {
		Stack<Integer> st = new Stack<>();
		int ans = 0;
		int index = 0;
		int n = height.length;

		while (index < n) {
			while (index < n - 1 && height[index] <= height[index + 1])
				index++;
			Stack<Integer> st2 = new Stack<>();
			while (!st.isEmpty() && height[st.peek()] < height[index]) {
				if (!st2.isEmpty() && height[st2.peek()] <= height[st.peek()]) {
					st2.pop();
					st2.add(st.pop());
				} else
					st2.add(st.pop());
			}
			if (st.isEmpty())
				while (!st2.isEmpty())
					st.add(st2.pop());
			st.add(index);
			index++;
			while (index < n - 1 && height[index] > height[index + 1])
				index++;
		}
		while (st.size() > 1) {
			int right = st.pop();
			int left = st.peek();
			int min = Math.min(height[left], height[right]);
			for (int i = left + 1; i < right; i++)
				ans += Math.max(0, min - height[i]);
		}
		return ans;
	}
}
