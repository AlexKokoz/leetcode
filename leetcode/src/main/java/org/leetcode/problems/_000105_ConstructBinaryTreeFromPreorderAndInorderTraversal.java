package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int[] preorder;
	int[] inorder;
	Map<Integer, Integer> ioPos;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		this.preorder = preorder;
		this.inorder = inorder;
		// map values to their inorder positions
		ioPos = new HashMap<>();
		for (int i = 0; i < n; i++)
			ioPos.put(inorder[i], i);
		return build(0, n - 1, 0, n - 1);
	}

	TreeNode build(int poStart, int poEnd, int ioStart, int ioEnd) {
		if (poStart > poEnd || ioStart > ioEnd)
			return null;

		// build current node
		TreeNode node = new TreeNode(preorder[poStart]);

		// current node's value position in inorder traversal
		int ioRootPos = ioPos.get(node.val);
		// elements in positions ioStart..ioRootPos - 1 are in the left subtree
		int leftSubtreeSize = ioRootPos - ioStart;
		// elements in positions ioRootPos + 1..ioEnd are in the right subtree
		int rightSubtreeSize = ioEnd - ioRootPos;

		// build children
		node.left = build(poStart + 1, poStart + leftSubtreeSize, ioStart, ioRootPos - 1);
		node.right = build(poEnd - rightSubtreeSize + 1, poEnd, ioRootPos + 1, ioEnd);

		return node;

	}
}
