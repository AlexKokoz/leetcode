package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000623_AddOneRowToTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode addOneRow(TreeNode root, int v, int d) {
		TreeNode fake = new TreeNode(0);
		fake.left = root;
		addRow(fake, root, v, d, 0);
		return fake.left;
	}

	void addRow(TreeNode parent, TreeNode child, int v, int d, int curd) {
		if (curd == d - 1 && parent != null) {
			if (parent.left == child) {
				TreeNode newNode = new TreeNode(v);
				newNode.left = child;
				parent.left = newNode;
			} else {
				TreeNode newNode = new TreeNode(v);
				newNode.right = child;
				parent.right = newNode;
			}
			return;
		}
		if (child != null) {
			addRow(child, child.left, v, d, curd + 1);
			addRow(child, child.right, v, d, curd + 1);
		}
	}
}
