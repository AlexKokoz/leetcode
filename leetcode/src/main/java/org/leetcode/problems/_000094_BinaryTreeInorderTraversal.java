package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000094_BinaryTreeInorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// ---- Iterative Method 1 ----
	public List<Integer> inorderTraversal(TreeNode root) {
		final List<Integer> list = new LinkedList<>();
		final Stack<TreeNode> stack = new Stack<>();
		while (true) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				if (stack.isEmpty())
					break;
				TreeNode node = stack.pop();
				list.add(node.val);
				root = node.right;
			}
		}
		return list;
	}
	
	/*

	// ---- Iterative Method 2 ----
	public List<Integer> inorderTraversal(TreeNode root) {
		final List<Integer> list = new LinkedList<>();
		if (root == null)
			return list;
		final Stack<TreeNode> toBeVisited = new Stack<>();
		final Stack<TreeNode> visited = new Stack<>();
		toBeVisited.push(root);
		while (!toBeVisited.isEmpty()) {
			if (toBeVisited.peek().left == null && toBeVisited.peek().right == null) {
				list.add(toBeVisited.pop().val);
			} else if (!visited.isEmpty() && toBeVisited.peek() == visited.peek()) {
				list.add(toBeVisited.pop().val);
				visited.pop();
			} else {
				final TreeNode node = toBeVisited.pop();
				visited.push(node);
				if (node.right != null)
					toBeVisited.push(node.right);
				toBeVisited.push(node);
				if (node.left != null)
					toBeVisited.push(node.left);
			}
		}
		return list;
	}
	
	*/
	
	/*

	// ---- Recursive Method ----
	public List<Integer> inorderTraversal(TreeNode root) {
		final List<Integer> list = new LinkedList<>();
		inorder(root, list);
		return list;
	}

	static void inorder(TreeNode node, List<Integer> list) {
		if (node == null)
			return;
		inorder(node.left, list);
		list.add(node.val);
		inorder(node.right, list);
	}
	
	*/

}
