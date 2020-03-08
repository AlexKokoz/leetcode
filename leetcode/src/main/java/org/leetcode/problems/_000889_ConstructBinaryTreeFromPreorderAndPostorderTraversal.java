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
public class _000889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int[] pre, post;

	public TreeNode constructFromPrePost(int[] pre, int[] post) {
		int n = pre.length;
		this.pre = pre;
		this.post = post;
		Map<Integer, Integer> prepos = new HashMap<>();
		for (int i = 0; i < n; i++)
			prepos.put(pre[i], i);
		Map<Integer, Integer> postpos = new HashMap<>();
		for (int i = 0; i < n; i++)
			postpos.put(post[i], i);
		return build(0, n - 1, 0, n - 1);
	}

	TreeNode build(int preStart, int preEnd, int postStart, int postEnd) {
		if (preStart > preEnd || postStart > postEnd)
			return null;
		TreeNode node = new TreeNode(pre[preStart]); // or post[postEnd]
		if (preStart == preEnd || postStart == postEnd)
			return node;
		int[] indices = calcIndices(preStart + 1, postStart);
		node.left = build(preStart + 1, indices[0], postStart, indices[1]);
		node.right = build(indices[0] + 1, preEnd, indices[1] + 1, postEnd - 1);
		return node;
	}

	int[] calcIndices(int preFrom, int postFrom) {
		int[] indices = new int[2];
		int preSet = 0;
		int postSet = 0;
		while (true) {
			preSet |= (1 << pre[preFrom]);
			postSet |= (1 << post[postFrom]);
			if ((preSet ^ postSet) == 0)
				break;
			preFrom++;
			postFrom++;
		}
		indices[0] = preFrom;
		indices[1] = postFrom;
		return indices;
	}

}
