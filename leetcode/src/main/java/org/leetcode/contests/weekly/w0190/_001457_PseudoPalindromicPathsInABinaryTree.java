package org.leetcode.contests.weekly.w0190;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001457_PseudoPalindromicPathsInABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int ans;

	public int pseudoPalindromicPaths(TreeNode root) {
		int[] ct = new int[10];
		dfs(root, ct);
		return ans;
	}

	void dfs(TreeNode node, int[] ct) {
		if (node == null)
			return;
		ct[node.val]++;
		if (node.left == node.right) {
			if (isPalindrome(ct)) {
				ans++;
			}
		}
		dfs(node.left, ct);
		dfs(node.right, ct);
		ct[node.val]--;
	}

	boolean isPalindrome(int[] digits) {
		int odds = 0;
		for (int digit : digits) {
			if (digit % 2 == 1) {
				odds++;
			}
		}
		if (odds > 1) {
			return false;
		}
		return true;
	}
}
