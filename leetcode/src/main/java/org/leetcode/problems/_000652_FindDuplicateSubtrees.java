package org.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000652_FindDuplicateSubtrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	Map<String, Integer> encountered;
	List<TreeNode> list;
	final String NULL = "#";
	final String SEP = ",";

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		encountered = new HashMap<>();
		list = new LinkedList<>();
		serialize(root);
		return list;
	}

	String serialize(TreeNode node) {
		if (node == null)
			return NULL;
		String enc = node.val + SEP + serialize(node.left) + SEP + serialize(node.right);
		encountered.put(enc, encountered.getOrDefault(enc, 0) + 1);
		if (encountered.get(enc) == 2)
			list.add(node);
		return enc;
	}

}
