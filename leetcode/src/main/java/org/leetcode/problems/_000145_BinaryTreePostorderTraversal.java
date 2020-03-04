package org.leetcode.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000145_BinaryTreePostorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postOrder = new LinkedList<>();
		TreeNode cur = root;
		//find CRL order
		while (cur != null) {
			if (cur.right == null) {
				postOrder.add(cur.val);
				cur = cur.left;
			} else {
				// find successor
				TreeNode successor = cur.right;
				while (successor.left != null && successor.left != cur)
					successor = successor.left;
				// create thread
				if (successor.left == null) {
					successor.left = cur;
					postOrder.add(cur.val);
					cur = cur.right;
				} else {
					successor.left = null;
					cur = cur.left;
				}
			}
		}
		// return reversed CRL to LRC(postorder)
		Collections.reverse(postOrder);
		return postOrder;
	}
}
