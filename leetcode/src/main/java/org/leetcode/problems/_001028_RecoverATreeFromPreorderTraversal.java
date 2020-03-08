package org.leetcode.problems;

public class _001028_RecoverATreeFromPreorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int start;

	public TreeNode recoverFromPreorder(String s) {
		start = 0;
		return build(s, 0);
	}

	TreeNode build(String s, int d) {
		int[] dvs = getDepthValueEnd(s);
		if (dvs == null || dvs[0] != d)
			return null;
		start = dvs[2];
		TreeNode root = new TreeNode(dvs[1]);
		int[] ldvs = getDepthValueEnd(s);
		if (ldvs == null || ldvs[0] != d + 1)
			return root;
		root.left = build(s, d + 1);
		if (start < ldvs[2])
			start = ldvs[2];

		int[] rdvs = getDepthValueEnd(s);
		if (rdvs == null || rdvs[0] != d + 1)
			return root;
		root.right = build(s, d + 1);

		if (start < rdvs[2])
			start = rdvs[2];
		return root;
	}

	int[] getDepthValueEnd(String s) {
		return getDepthValueEnd(s, start, s.length() - 1);
	}

	int[] getDepthValueEnd(String s, int l, int r) {
		if (l > r)
			return null;
		int[] dvs = new int[3];
		int i = l;
		for (; i <= r && s.charAt(i) == '-'; i++)
			dvs[0]++;
		StringBuilder sb = new StringBuilder();
		for (; i <= r && s.charAt(i) != '-'; i++)
			sb.append(s.charAt(i));
		dvs[1] = Integer.parseInt(sb.toString());
		dvs[2] = i;
		return dvs;
	}
}
