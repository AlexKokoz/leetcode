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
<<<<<<< HEAD

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class Solution {
		public TreeNode buildTree(int[] preorder, int[] inorder) {
			int n = preorder.length;
			Map<Integer, Integer> poPositions = new HashMap<>();
			for (int i = 0; i < n; i++)
				poPositions.put(preorder[i], i);
			Map<Integer, Integer> ioPositions = new HashMap<>();
			for (int i = 0; i < n; i++)
				ioPositions.put(inorder[i], i);
			return build(preorder, 0, n - 1, inorder, 0, n - 1, poPositions, ioPositions);
		}

		TreeNode build(int[] po, int poStart, int poEnd, int[] io, int ioStart, int ioEnd, Map<Integer, Integer> ioPos,
				Map<Integer, Integer> poPos) {
			if (ioStart > ioEnd)
				return null;
			TreeNode node = new TreeNode(po[poStart]);
			int inorderRootPosition = ioPos.get(node.val);
			int preorderRightestLeftElementPos = inorderRootPosition > 0 ? poPos.get(io[inorderRootPosition - 1]) : -1;
			node.left = build(po, poStart + 1, preorderRightestLeftElementPos, io, ioStart, inorderRootPosition - 1,
					poPos, ioPos);
			node.right = build(po, preorderRightestLeftElementPos + 1, poEnd, io, inorderRootPosition + 1, ioEnd, poPos,
					ioPos);
			return node;
		}
=======
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
>>>>>>> refs/remotes/origin/master
	}
}
