package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000230_KthSmallestElementInABST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Morris inorder traversal
	public int kthSmallest(TreeNode root, int k) {
		TreeNode cur = root;
		int ans = 0;
		int count = 0;
		while (cur != null) {
			if (cur.left == null) {
				count++;
				if (count == k) {
					ans = cur.val;
					break;
				}
				cur = cur.right;
			} else {
				TreeNode predecessor = cur.left;
				while (predecessor.right != null && predecessor.right != cur)
					predecessor = predecessor.right;
				if (predecessor.right == null) {
					predecessor.right = cur;
					cur = cur.left;
				} else {
					predecessor.right = null;
					count++;
					if (count == k) {
						ans = cur.val;
						break;
					}
					cur = cur.right;
				}
			}
		}
		return ans;
	}
}
