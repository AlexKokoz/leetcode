package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000114_FlattenBinaryTreeToLinkedList {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public void flatten(TreeNode root) {
		preorder(root);
	}

	/**
	 * Morris preorder traversal.
	 * 
	 * Time Complexity: O(n).
	 * 
	 * Space Complexity: O(1).
	 * 
	 * @param root
	 */
	public void preorder(TreeNode root) {

		TreeNode current = root;

		while (current != null) {

			// no elements on the left that are less than the current; add it to result.
			if (current.left == null) {
				current = current.right;
			}

			// start processing the left subtree.
			else {

				TreeNode predecessor = current.left;

				// find rightmost value of current's left subtree.
				while (predecessor.right != null && predecessor.right != current.right) {
					predecessor = predecessor.right;
				}

				// if no thread between current and its predecessor, add it and add current
				// val to the result.
				if (predecessor.right == null) {
					predecessor.right = current.right;
					current.right = current.left;
					current.left = null;
					current = current.right;
				}
				// current's left subtree has been processed; remove the thread.
				else {
					current = current.right;
				}

			}
		}
	}
}
