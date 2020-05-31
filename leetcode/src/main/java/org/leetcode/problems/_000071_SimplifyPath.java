package org.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000071_SimplifyPath {
	public String simplifyPath(String path) {
		Stack<String> st = new Stack<>();
		Iterable<String> chunks = getChunks(path);
		for (String chunk : chunks) {
			switch (chunk) {
			case "..":
				if (!st.isEmpty())
					st.pop();
				break;
			case ".":
				break;
			default:
				st.push(chunk);
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append('/');
		String sep = "";
		for (String chunk : st) {
			sb.append(sep).append(chunk);
			sep = "/";
		}
		return sb.toString();
	}

	Iterable<String> getChunks(String path) {
		StringBuilder sb = new StringBuilder();
		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (c == '/') {
				if (sb.length() > 0) {
					q.add(sb.toString());
				}
				sb = new StringBuilder();
			} else {
				sb.append(c);
			}
		}
		if (sb.length() > 0)
			q.add(sb.toString());
		return q;
	}
}
