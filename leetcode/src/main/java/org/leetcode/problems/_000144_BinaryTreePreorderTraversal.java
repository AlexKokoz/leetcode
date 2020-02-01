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
public class _000144_BinaryTreePreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	
	public List<Integer> preorderTraversal(TreeNode root) {
		
		// Morris Traversal
		List<Integer> elementsInorder = new LinkedList<>();
		TreeNode current = root;
		while (current != null) {
			// no elements on the left that are less than the current; add it to result.
			if (current.left == null) {
				elementsInorder.add(current.val);
				current = current.right;
			}
			// start processing the left subtree.
			else {
				TreeNode predecessor = current.left;
				// find rightmost value of current's left subtree.
				while (predecessor.right != null && predecessor.right != current) {
					predecessor = predecessor.right;
				}
				// if no thread between current and its predecessor, add it and add current
				// value to the result.
				if (predecessor.right == null) {
					predecessor.right = current;
					elementsInorder.add(current.val);
					current = current.left;
				}
				// current's left subtree has been processed; remove the thread.
				else {
					predecessor.right = null;
					current = current.right;
				}
			}
		}
		return elementsInorder;
	}
}
