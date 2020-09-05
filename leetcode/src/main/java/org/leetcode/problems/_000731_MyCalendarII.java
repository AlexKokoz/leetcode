package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000731_MyCalendarII {
	class MyCalendarTwo {

		SegmentTreeMax tree;

		public MyCalendarTwo() {
			tree = new SegmentTreeMax(0, (int) 1e9);
		}

		public boolean book(int start, int end) {
			tree.update(start, end - 1, 1);
			if (tree.query(start, end - 1) > 2) {
				tree.update(start, end - 1, -1);
				return false;
			}
			return true;
		}

		class SegmentTreeMax {
			private Node root;

			public SegmentTreeMax(int from, int to) {
				root = new Node(from, to, 0);
			}

			public SegmentTreeMax(int n) {
				root = new Node(0, n - 1, 0);
			}

			public SegmentTreeMax(int[] nums) {
				int n = nums.length;
				root = new Node(0, n - 1, 0);
				for (int i = 0; i < n; i++)
					update(i, nums[i]);
			}

			public void update(int qFrom, int qTo, long val) {
				validate(qFrom);
				validate(qTo);
				root = update(root, qFrom, qTo, val);

			}

			public void update(int i, long val) {
				validate(i);
				update(i, i, val);
			}

			public long query(int qFrom, int qTo) {
				return query(root, qFrom, qTo);
			}

			public String toString() {
				return root.toString();
			}
			// ================================================================================
			// PRIVATE METHODS
			// ================================================================================

			private Node update(Node node, int qFrom, int qTo, long val) {
				if (qFrom > qTo || node == null || !node.intersects(qFrom, qTo))
					return node;

				if (node.coveredBy(qFrom, qTo)) {
					node.val += val;
					node.lazyVal += val;
					return node;
				}

				node = propagate(node);

				node.lChild = update(node.lChild, qFrom, qTo, val);
				node.rChild = update(node.rChild, qFrom, qTo, val);

				node.val = Math.max(node.lChild.val, node.rChild.val);

				return node;
			}

			private Node propagate(Node node) {
				assert node != null;
				if (node.from < node.to) {
					if (node.lChild == null || node.rChild == null) {
						int mid = node.from + (node.to - node.from) / 2;
						node.lChild = new Node(node.from, mid, node.lazyVal);
						node.lChild.lazyVal = node.lazyVal;
						node.rChild = new Node(mid + 1, node.to, node.lazyVal);
						node.rChild.lazyVal = node.lazyVal;
					} else if (node.lazyVal != 0) {
						node.lChild.val += node.lazyVal;
						node.lChild.lazyVal += node.lazyVal;
						node.rChild.val += node.lazyVal;
						node.rChild.lazyVal += node.lazyVal;
					}
				}
				node.lazyVal = 0;
				return node;
			}

			private long query(Node node, int qFrom, int qTo) {
				if (qFrom > qTo || node == null || !node.intersects(qFrom, qTo))
					return Long.MIN_VALUE;
				if (node.coveredBy(qFrom, qTo))
					return node.val;
				propagate(node);
				return Math.max(query(node.lChild, qFrom, qTo), query(node.rChild, qFrom, qTo));
			}

			private void validate(int point) {
				assert point >= root.from;
				assert point <= root.to;
			}

			// ================================================================================
			// NESTED CLASSES
			// ================================================================================
			class Node {
				final int from;
				final int to;
				Node lChild;
				Node rChild;
				long val;
				long lazyVal;

				public Node(int from, int to, long val) {
					this.from = from;
					this.to = to;
					this.val = val;
				}

				private boolean coveredBy(int qFrom, int qTo) {
					return qFrom <= from && qTo >= to;
				}

				private boolean intersects(int qFrom, int qTo) {
					return qFrom <= to && from <= qTo;
				}

				public String toString() {
					return toString("  ", 0);
				}

				private String toString(String indent, int level) {
					StringBuilder sb = new StringBuilder();
					for (int i = 0; i < level; i++)
						sb.append(indent);
					sb.append("Node[ range=[");
					sb.append(from);
					sb.append(",");
					sb.append(to);
					sb.append("] value=[");
					sb.append(val);
					sb.append("] lazy=[");
					sb.append(lazyVal);
					sb.append("] ]");
					sb.append("\n");
					if (lChild != null)
						sb.append(lChild.toString(indent, level + 1));
					if (rChild != null)
						sb.append(rChild.toString(indent, level + 1));
					return sb.toString();
				}
			}
		}
	}
}
