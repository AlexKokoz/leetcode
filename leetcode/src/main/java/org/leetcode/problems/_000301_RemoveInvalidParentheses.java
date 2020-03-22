package org.leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000301_RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		int n = s.length();
		Set<String> set = new HashSet<>();
		List<String> list = new LinkedList<>();
		Queue<Node> q = new LinkedList<>();
		final char op = '(';
		final char cl = ')';

		q.add(new Node());
		while (!q.isEmpty()) {
			Node cur = q.poll();
			if (cur.nop < cur.ncl || cur.nop - cur.ncl > n - cur.index)
				continue;
			if (cur.index == n) {
				if (cur.nop == cur.ncl && cur.sb.length() > 0) {
					String sub = cur.sb.toString();
					if ((list.isEmpty() || list.get(list.size() - 1).length() == sub.length()) && !set.contains(sub)) {
						list.add(sub);
						set.add(sub);
					}
				}
				continue;
			}
			char c = s.charAt(cur.index);
			cur.index++;
			Node newNode = new Node(cur);
			if (c == op)
				newNode.nop++;
			else if (c == cl)
				newNode.ncl++;
			newNode.sb.append(c);
			q.add(newNode);
			q.add(cur);
		}
		if (list.isEmpty())
			list.add("");
		return list;
	}

	static class Node {
		StringBuilder sb;
		int index;
		int nop;
		int ncl;

		public Node() {
			sb = new StringBuilder();
		}

		public Node(Node that) {
			sb = new StringBuilder(that.sb.toString());
			index = that.index;
			nop = that.nop;
			ncl = that.ncl;
		}
	}

}
