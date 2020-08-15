package org.leetcode.problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000731_MyCalendarII {
	static class MyCalendarTwo {

		IntervalTree<Integer> tree;

		public MyCalendarTwo() {
			tree = new IntervalTree<>();
		}

		public boolean book(int start, int end) {
			end--;
			List<IntervalTree.Interval> intervals = tree.searchAll(start, end);
			for (IntervalTree.Interval interval : intervals) {
				int count = tree.get(interval.l, interval.r);
				if (count == 2)
					return false;
				int nl = Math.max(start, interval.l);
				int nr = Math.min(end, interval.r);
				if (tree.intersectsAtLeast(nl, nr, 2))
					return false;
			}
			Integer count = tree.get(start, end);
			tree.put(start, end, 1 + (count != null ? count : 0));
			return true;

		}

		static class IntervalTree<V> {
			private Node<V> root;
			private int size;

			public boolean contains(int l, int r) {
				return get(l, r) != null;
			}

			public V get(int l, int r) {
				assert l <= r;
				Node<V> x = get(root, new Interval(l, r));
				return x == null ? null : x.val;
			}

			private Node<V> get(Node<V> node, Interval interval) {
				if (node == null)
					return null;
				int cmp = interval.compareTo(node.interval);
				if (cmp < 0)
					return get(node.left, interval);
				else if (cmp > 0)
					return get(node.right, interval);
				else
					return node;
			}

			public void put(int l, int r, V val) {
				assert l <= r;
				root = put(root, new Interval(l, r), val);
			}

			private Node<V> put(Node<V> node, Interval interval, V val) {
				if (node == null) {
					size++;
					return new Node<>(interval, val);
				}
				int cmp = interval.compareTo(node.interval);
				if (cmp < 0) {
					node.left = put(node.left, interval, val);
					node = rotR(node);
				} else if (cmp > 0) {
					node.right = put(node.right, interval, val);
					node = rotL(node);
				} else {
					node.val = val;
				}
				update(node);
				return node;
			}

			public Interval search(int l, int r) {
				assert l <= r;
				return search(root, new Interval(l, r));
			}

			private Interval search(Node<V> node, Interval interval) {
				if (node == null)
					return null;
				if (node.interval.intersects(interval))
					return new Interval(node.interval);
				else if (node.left == null)
					return search(node.right, interval);
				else if (node.left.max < interval.l)
					return search(node.right, interval);
				else
					return search(node.left, interval);
			}

			public List<Interval> searchAll(int l, int r) {
				LinkedList<Interval> list = new LinkedList<>();
				searchAll(root, new Interval(l, r), list);
				return list;
			}

			public boolean intersectsAtLeast(int l, int r, int targetCount) {
				int[] currentCount = new int[1];
				intersectsAtLeast(root, new Interval(l, r), currentCount, targetCount);
				return currentCount[0] >= targetCount;
			}

			private void intersectsAtLeast(Node<V> node, Interval interval, int[] currentCount,
					int targetCount) {
				if (currentCount[0] >= targetCount)
					return;
				if (node == null)
					return;

				if (interval.intersects(node.interval)) {
					currentCount[0]++;
					if (currentCount[0] >= targetCount)
						return;
				}
				if (node.left != null && interval.l <= node.left.max)
					intersectsAtLeast(node.left, interval, currentCount, targetCount);
				if (node.right != null && node.right.max >= interval.l)
					intersectsAtLeast(node.right, interval, currentCount, targetCount);
			}

			public int size() {
				return size;
			}

			public String toString() {
				return toString(root, " ", 0);
			}

			private String toString(Node<V> node, String indent, int level) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < level; i++)
					sb.append(indent);
				sb.append(node.interval).append(" val = " + node.val).append(" max = " + node.max)
						.append(" size = " + node.size).append("\n");
				if (node.left != null)
					sb.append(toString(node.left, indent, level + 1));
				if (node.right != null)
					sb.append(toString(node.right, indent, level + 1));
				return sb.toString();
			}

			private boolean searchAll(Node<V> node, Interval interval, LinkedList<Interval> list) {
				boolean f1 = false, f2 = false, f3 = false;
				if (node == null)
					return false;

				if (interval.intersects(node.interval)) {
					list.add(new Interval(node.interval.l, node.interval.r));
					f1 = true;
				}
				if (node.left != null && interval.l <= node.left.max)
					f2 = searchAll(node.left, interval, list);
				if (node.right != null && node.right.max >= interval.l)
					f3 = searchAll(node.right, interval, list);
				return f1 || f2 || f3;
			}

			private void update(Node<V> node) {
				node.size = 1 + size(node.left) + size(node.right);
				node.max = max(node);
			}

			private int size(Node<V> node) {
				return node == null ? 0 : node.size;
			}

			private int max(Node<V> node) {
				return node == null ? Integer.MIN_VALUE
						: Math.max(node.interval.r, Math.max(max(node.left), max(node.right)));
			}

			private Node<V> rotL(Node<V> node) {
				Node<V> right = node.right;
				node.right = right.left;
				right.left = node;
				update(node);
				update(right);
				return right;
			}

			private Node<V> rotR(Node<V> node) {
				Node<V> left = node.left;
				node.left = left.right;
				left.right = node;
				update(node);
				update(left);
				return left;
			}

			private static class Node<V> {
				Interval interval;
				private Node<V> left, right;
				private V val;
				public int max;
				private int size;

				public Node(Interval interval, V val) {
					this.interval = new Interval(interval.l, interval.r);
					this.max = interval.r;
					this.size = 1;
					this.val = val;
				}
			}

			public static class Interval implements Comparable<Interval> {
				int l, r;

				public Interval(int l, int r) {
					this.l = l;
					this.r = r;
				}

				public Interval(Interval interval) {
					this.l = interval.l;
					this.r = interval.r;
				}

				@Override
				public int compareTo(Interval that) {
					return l > that.l ? 1 : l < that.l ? -1 : r > that.r ? 1 : r < that.r ? -1 : 0;
				}

				public boolean intersects(Interval that) {
					return l <= that.r && that.l <= r;
				}

				public String toString() {
					return l + "-" + r;
				}

				public int hashCode() {
					int hash = 7;
					hash = 31 * hash + l;
					hash = 31 * hash + r;
					return hash;
				}

				public boolean equals(Object o) {
					if (o == null)
						return false;
					if (o == this)
						return true;
					if (this.getClass() != this.getClass())
						return false;
					Interval that = (Interval) o;
					return this.l == that.l && this.r == that.r;
				}

			}
		}
	}
}
