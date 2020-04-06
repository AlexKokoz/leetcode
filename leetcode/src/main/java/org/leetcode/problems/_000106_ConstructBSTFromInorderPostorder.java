package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000106_ConstructBSTFromInorderPostorder {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	static TreeNode construct(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
		if (pstart > pend)
			return null;
		final TreeNode root = new TreeNode(postorder[pend]);
		int i;
		for (i = istart; i <= iend && inorder[i] != postorder[pend]; i++);
		root.left = construct(inorder, istart, i - 1, postorder, pstart, pstart + i - istart - 1);
		root.right = construct(inorder, i + 1, iend, postorder, pend - iend + i, pend - 1);
		return root;
	}
}
