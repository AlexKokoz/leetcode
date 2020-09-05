package org.leetcode.contests.weekly.w0169;

import java.util.ArrayList;
import java.util.List;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001305_AllElementsInTwoBSTs {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> nums1;
	List<Integer> nums2;

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		nums1 = new ArrayList<>();
		nums2 = new ArrayList<>();
		inorder(root1, nums1);
		inorder(root2, nums2);
		List<Integer> ans = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < nums1.size() || j < nums2.size()) {
			if (i < nums1.size() && (j >= nums2.size() || nums1.get(i) <= nums2.get(j)))
				ans.add(nums1.get(i++));
			else 
				ans.add(nums2.get(j++));
		}
		return ans;
	}

	void inorder(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		if (node.left == node.right) {
			list.add(node.val);
			return;
		}
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}

}
