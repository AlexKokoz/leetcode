package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001352_ProductoftheLastKNumbers {
	class ProductOfNumbers {
		private List<Long> nums;

		public ProductOfNumbers() {
			nums = new LinkedList<>();
			nums.add(1L);
		}

		public void add(int num) {
			if (num == 0) {
				nums = new LinkedList<>();
				nums.add(1L);
			} else {
				nums.add(nums.get(nums.size() - 1) * num);
			}
		}

		public int getProduct(int k) {
			int n = nums.size();
			if (k < n) {
				return (int) (nums.get(n - 1) / nums.get(n - k - 1));
			} else
				return 0;
		}
	}
}
