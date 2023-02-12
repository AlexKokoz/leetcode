package org.leetcode.contests.weekly.w0311;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reverseOddLevels(TreeNode root) {
		List<TreeNode> prev = new ArrayList<>();
		List<TreeNode> cur = new ArrayList<>();
		cur.add(root);
		int level = 0;
		while (!cur.isEmpty()) {
			List<TreeNode> next = new ArrayList<>();
			for (TreeNode node : cur) {
				if (node.left != null) {
					next.add(node.left);
					next.add(node.right);
				}
			}
			if (level % 2 == 1) {
				for (int i = 0, j = cur.size() - 1; i < prev.size(); i++, j -= 2) {
					prev.get(i).left = cur.get(j);
					prev.get(i).right = cur.get(j - 1);
				}
				if (!next.isEmpty()) {
					for (int i = 0, j = next.size() - 1; i < cur.size(); i++, j -= 2) {
						cur.get(i).left = next.get(j - 1);
						cur.get(i).right = next.get(j);
					}
				}
			}
			prev = cur;
			cur = next;
			level++;
		}
		return root;
	}
}
