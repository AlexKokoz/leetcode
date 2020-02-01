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
public class _000095_UniqueBSTsII {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		return n == 0 ? (List<TreeNode>) new LinkedList<TreeNode>() : uniq(1, n);
	}

	List<TreeNode> uniq(int start, int end) {
		List<TreeNode> list = new LinkedList<>();

		if (start > end) {
			list.add(null);
			return list;
		}

		if (start == end) {
			list.add(new TreeNode(start));
			return list;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> left = uniq(start, i - 1);
			List<TreeNode> right = uniq(i + 1, end);

			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					list.add(root);
				}
			}
		}
		return list;
	}

}
