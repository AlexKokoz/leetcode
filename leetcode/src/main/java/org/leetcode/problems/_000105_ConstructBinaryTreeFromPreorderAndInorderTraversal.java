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
	}
}
