package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000297_SerializeAndDeserializeBinaryTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Codec {
		final String COMMA = ",";
		final TreeNode NULL_NODE = new TreeNode(0);

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			if (root == null)
				return sb.toString();
			Queue<TreeNode> q = new LinkedList<>();
			q.add(root);
			String sep = "";
			while (!q.isEmpty()) {
				boolean flag = false; // true means that in a current level node has at least one valid non null child
				for (int i = 0, size = q.size(); i < size; i++) {
					TreeNode cur = q.poll();
					sb.append(sep);
					sep = COMMA;
					if (cur == NULL_NODE)
						sb.append("null");
					else {
						sb.append(cur.val);
						if (cur.left != null) {
							flag = true;
							q.add(cur.left);
						} else {
							q.add(NULL_NODE);
						}
						if (cur.right != null) {
							flag = true;
							q.add(cur.right);
						} else {
							q.add(NULL_NODE);
						}
					}
				}
				if (!flag)
					break;
			}
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			Integer[] vals = deserializeToArray(data);
			if (vals.length == 0)
				return null;
			Queue<TreeNode> parents = new LinkedList<>();
			int index = 0;
			TreeNode root = new TreeNode(vals[index++]);
			parents.add(root);
			while (!parents.isEmpty() && index < vals.length) {
				for (int i = 0, len = parents.size(); i < len; i++) {
					TreeNode cur = parents.poll();
					if (index < vals.length && vals[index] != null) {
						cur.left = new TreeNode(vals[index]);
						parents.add(cur.left);
					}
					index++;
					if (index < vals.length && vals[index] != null) {
						cur.right = new TreeNode(vals[index]);
						parents.add(cur.right);
					}
					index++;
				}
			}
			return root;
		}

		private Integer[] deserializeToArray(String data) {
			if (data.length() == 0)
				return new Integer[0];
			Queue<String> valsQueue = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < data.length(); i++) {
				char currentChar = data.charAt(i);
				if (currentChar == ',') {
					valsQueue.add(sb.toString());
					sb = new StringBuilder();
				} else {
					sb.append(currentChar);
				}
			}
			valsQueue.add(sb.toString());
			Integer[] vals = new Integer[valsQueue.size()];
			for (int i = 0; i < vals.length; i++) {
				String val = valsQueue.poll();
				if (val.equals("null"))
					vals[i] = null;
				else
					vals[i] = Integer.parseInt(val);
			}
			return vals;
		}
	}
}
