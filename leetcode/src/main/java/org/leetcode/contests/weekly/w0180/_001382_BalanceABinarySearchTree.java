package org.leetcode.contests.weekly.w0180;

import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001382_BalanceABinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	List<Integer> io;

	public TreeNode balanceBST(TreeNode root) {
		io = inorder(root);
		return build(0, io.size() - 1);
	}
	
	TreeNode build(int lo, int hi) {
		if (lo > hi) return null;
		int mid = (lo + hi) / 2;
		TreeNode root = new TreeNode(io.get(mid));
		root.left = build(lo, mid - 1);
		root.right = build(mid + 1, hi);
		return root;
	}

	public List<Integer> inorder(TreeNode root) {

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
				// if no thread between current and its predecessor, add it.
				if (predecessor.right == null) {
					predecessor.right = current;
					current = current.left;
				}
				// current's left subtree has been processed; add current value to the result
				// and remove the thread.
				else {
					predecessor.right = null;
					elementsInorder.add(current.val);
					current = current.right;
				}
			}
		}
		return elementsInorder;
	}
}
