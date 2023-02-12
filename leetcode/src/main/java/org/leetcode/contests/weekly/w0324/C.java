package org.leetcode.contests.weekly.w0324;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	class Allocator {

		SegmentTreeSumLazy st;
		int n;
		Map<Integer, List<int[]>> memo;

		public Allocator(int n) {
			st = new SegmentTreeSumLazy(n);
			this.n = n;
			memo = new HashMap<>();
		}

		public int allocate(int size, int mID) {
			if (size > n)
				return -1;
			for (int i = size - 1; i < n; i++) {
				if (st.query(i - size + 1, i) == 0) {
					st.update(i - size + 1, i, 1);
					memo.computeIfAbsent(mID, z -> new ArrayList<>())
							.add(new int[] { i - size + 1, i });
					return i - size + 1;
				}
			}
			return -1;
		}

		public int free(int mID) {
			if (!memo.containsKey(mID)) {
				return 0;
			}
			int ret = 0;
			for (int[] interval : memo.get(mID)) {
				st.update(interval[0], interval[1], -1);
				ret += interval[1] - interval[0] + 1;
			}
			memo.remove(mID);
			return ret;
		}
	}

	class SegmentTreeSumLazy {
		private Node root;

		public SegmentTreeSumLazy(int min, int max) {
			root = new Node(min, max, 0);
		}

		public SegmentTreeSumLazy(int n) {
			root = new Node(0, n - 1, 0);
		}

		public SegmentTreeSumLazy(int[] nums) {
			int n = nums.length;
			root = new Node(0, n - 1, 0);
			for (int i = 0; i < n; i++)
				update(i, nums[i]);
		}

		public void update(int qmin, int qmax, long val) {
			validate(qmin);
			validate(qmax);
			root = update(root, qmin, qmax, val);

		}

		public void update(int i, long val) {
			validate(i);
			update(i, i, val);
		}

		private Node update(Node node, int qmin, int qmax, long val) {
			if (qmin > qmax || node == null || !node.intersects(qmin, qmax))
				return node;

			if (node.coveredBy(qmin, qmax)) {
				node.val += val * (node.max - node.min + 1);
				node.lazyVal += val;
				return node;
			}

			node = propagate(node);

			node.lChild = update(node.lChild, qmin, qmax, val);
			node.rChild = update(node.rChild, qmin, qmax, val);

			node.val = node.lChild.val + node.rChild.val;

			return node;
		}

		public long query(int qmin, int qmax) {
			return query(root, qmin, qmax);
		}

		public String toString() {
			return root.toString();
		}
		// ================================================================================
		// PRIVATE METHODS
		// ================================================================================

		private void validate(int point) {
			assert point >= root.min;
			assert point <= root.max;
		}

		private Node propagate(Node node) {
			assert node != null;
			if (node.min < node.max) {
				if (node.lChild == null || node.rChild == null) {
					int mid = node.min + (node.max - node.min) / 2;
					node.lChild = new Node(node.min, mid, (mid - node.min + 1) * node.lazyVal);
					node.lChild.lazyVal = node.lazyVal;
					node.rChild = new Node(mid + 1, node.max, (node.max - mid) * node.lazyVal);
					node.rChild.lazyVal = node.lazyVal;
				} else if (node.lazyVal != 0) {
					node.lChild.val += (node.lChild.max - node.lChild.min + 1) * node.lazyVal;
					node.lChild.lazyVal += node.lazyVal;
					node.rChild.val += (node.rChild.max - node.rChild.min + 1) * node.lazyVal;
					node.rChild.lazyVal += node.lazyVal;
				}
			}
			node.lazyVal = 0;
			return node;
		}

		private long query(Node node, int qmin, int qmax) {
			if (qmin > qmax || node == null || !node.intersects(qmin, qmax))
				return 0;
			if (node.coveredBy(qmin, qmax))
				return node.val;
			propagate(node);
			return query(node.lChild, qmin, qmax) + query(node.rChild, qmin, qmax);
		}

		// ================================================================================
		// NESTED CLASSES
		// ================================================================================
		class Node {
			final int min;
			final int max;
			Node lChild;
			Node rChild;
			long val;
			long lazyVal;

			public Node(int min, int max, long val) {
				this.min = min;
				this.max = max;
				this.val = val;
			}

			private boolean coveredBy(int qmin, int qmax) {
				return qmin <= min && qmax >= max;
			}

			private boolean intersects(int qmin, int qmax) {
				return qmin <= max && min <= qmax;
			}

			public String toString() {
				return toString("  ", 0);
			}

			private String toString(String indent, int level) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < level; i++)
					sb.append(indent);
				sb.append("Node[ range=[");
				sb.append(min);
				sb.append(",");
				sb.append(max);
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
