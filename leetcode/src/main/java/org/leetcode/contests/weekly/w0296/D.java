package org.leetcode.contests.weekly.w0296;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	class TextEditor {
		Deque<Character> left, right;

		public TextEditor() {
			left = new ArrayDeque<>();
			right = new ArrayDeque<>();
		}

		public void addText(String text) {
			for (int i = 0; i < text.length(); i++) {
				left.addLast(text.charAt(i));
			}
		}

		public int deleteText(int k) {
			int deleted = 0;
			for (int i = 0; i < k && !left.isEmpty(); i++) {
				left.pollLast();
				deleted++;
			}
			return deleted;
		}

		public String cursorLeft(int k) {
			for (int i = 0; i < k && !left.isEmpty(); i++) {
				right.addFirst(left.pollLast());
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0, size = Math.min(10, left.size()); i < size; i++) {
				sb.append(left.pollLast());
			}
			sb = sb.reverse();
			for (int i = 0; i < sb.length(); i++) {
				left.addLast(sb.charAt(i));
			}
			return sb.toString();
		}

		public String cursorRight(int k) {
			for (int i = 0; i < k && !right.isEmpty(); i++) {
				left.addLast(right.pollFirst());
			}
			StringBuilder sb = new StringBuilder();
			for (int i = 0, size = Math.min(10, left.size()); i < size; i++) {
				sb.append(left.pollLast());
			}
			sb = sb.reverse();
			for (int i = 0; i < sb.length(); i++) {
				left.addLast(sb.charAt(i));
			}
			return sb.toString();
		}
	}
}
