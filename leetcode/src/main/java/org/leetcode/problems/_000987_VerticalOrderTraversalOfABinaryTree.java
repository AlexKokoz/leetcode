package org.leetcode.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000987_VerticalOrderTraversalOfABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int min;
	int max;

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		min = 0;
		max = 0;
		measureX(root, 0);
		int xSize = max - min + 1;
		List<List<Integer>> ans = new LinkedList<>();
		for (int i = 0; i < xSize; i++)
			ans.add(new LinkedList<>());

		Queue<TreeNode> q = new LinkedList<>();
		Queue<Integer> qx = new LinkedList<>();
		q.add(root);
		qx.add(-min);
		
		while (!q.isEmpty()) {
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0, len = q.size(); i < len; i++) {
				TreeNode curNode = q.poll();
				int curX = qx.poll();
				List<Integer> curXList = map.getOrDefault(curX, new LinkedList<>());
				curXList.add(curNode.val);
				map.put(curX, curXList);
				if (curNode.left != null) {
					q.add(curNode.left);
					qx.add(curX - 1);
				}
				if (curNode.right != null) {
					q.add(curNode.right);
					qx.add(curX + 1);
				}
			}
			for (int x : map.keySet()) {
				List<Integer> curXList = map.get(x);
				Collections.sort(curXList);
				for (int elem : curXList)
					ans.get(x).add(elem);
			}
		}
		return ans;
	}

	void measureX(TreeNode node, int x) {
		if (node == null)
			return;
		min = Math.min(min, x);
		max = Math.max(max, x);
		measureX(node.left, x - 1);
		measureX(node.right, x + 1);
	}

//	int min;
//	int max;
//
//	public List<List<Integer>> verticalTraversal(TreeNode root) {
//		min = 0;
//		max = 0;
//		measureX(root, 0);
//		int xSize = max - min + 1;
//		List<List<Integer>> ans = new LinkedList<>();
//		for (int i = 0; i < xSize; i++)
//			ans.add(new LinkedList<>());
//
//		Queue<TreeNode> q = new LinkedList<>();
//		Queue<Integer> qx = new LinkedList<>();
//		q.add(root);
//		qx.add(-min);
//		while (!q.isEmpty()) {
//			Set<Integer> seenx = new HashSet<>();
//			for (int i = 0, len = q.size(); i < len; i++) {
//				TreeNode curNode = q.poll();
//				int curX = qx.poll();
//				List<Integer> curList = ans.get(curX);
//				if (seenx.contains(curX) && curList.get(curList.size() - 1) > curNode.val) {
//					curList.add(curList.get(curList.size() - 1));
//					curList.set(curList.size() - 2, curNode.val);
//				} else
//					curList.add(curNode.val);
//				seenx.add(curX);
//				if (curNode.left != null) {
//					q.add(curNode.left);
//					qx.add(curX - 1);
//				}
//				if (curNode.right != null) {
//					q.add(curNode.right);
//					qx.add(curX + 1);
//				}
//			}
//		}
//		return ans;
//	}
//
//	void measureX(TreeNode node, int x) {
//		if (node == null)
//			return;
//		min = Math.min(min, x);
//		max = Math.max(max, x);
//		measureX(node.left, x - 1);
//		measureX(node.right, x + 1);
//	}

}
