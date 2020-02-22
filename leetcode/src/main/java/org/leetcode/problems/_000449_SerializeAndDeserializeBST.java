package org.leetcode.problems;

import java.util.Iterator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000449_SerializeAndDeserializeBST {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public class Codec {
		private final String SEPARATOR = ",";
		private final String NULL = "_";

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder sb = new StringBuilder();
			serialize(root, sb);
			return sb.toString();
		}

		void serialize(TreeNode node, StringBuilder sb) {
			if (sb.length() > 0)
				sb.append(SEPARATOR);
			if (node == null) {
				sb.append(NULL);
			} else {
				sb.append(node.val);
				serialize(node.left, sb);
				serialize(node.right, sb);
			}
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] arr = data.split(SEPARATOR);
			StringArrayIterator itor = new StringArrayIterator(arr);
			return deserialize(itor);
		}

		TreeNode deserialize(StringArrayIterator itor) {
			if (!itor.hasNext())
				return null;
			String curVal = itor.next();
			if (curVal.equals(NULL))
				return null;
			TreeNode node = new TreeNode(Integer.parseInt(curVal));
			node.left = deserialize(itor);
			node.right = deserialize(itor);
			return node;
		}

		class StringArrayIterator implements Iterator<String> {

			private final String[] arr;
			private int curIndex = 0;

			public StringArrayIterator(String[] arr) {
				this.arr = arr;
			}

			@Override
			public boolean hasNext() {
				return curIndex < arr.length;
			}

			@Override
			public String next() {
				return arr[curIndex++];
			}

		}

	}

}
