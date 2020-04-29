package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000088_MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i1, i2, i;
		for (i = nums1.length - 1, i1 = m - 1, i2 = n - 1; i1 >= 0 && i2 >= 0;) {
			if (nums1[i1] >= nums2[i2])
				nums1[i--] = nums1[i1--];
			else
				nums1[i--] = nums2[i2--];
		}
		while (i2 >= 0) {
			nums1[i--] = nums2[i2--];
		}
	}
}
