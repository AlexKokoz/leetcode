package org.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000140_WordBreakII {

	public List<String> wordBreak(String s, List<String> wordDict) {
		return dfs(s, wordDict, new Trie<List<String>>(new Trie.SortedLinkedListTrieType<>()));
	}

	List<String> dfs(String s, List<String> dict, Trie<List<String>> trie) {
		if (trie.contains(s))
			return trie.get(s);

		List<String> list = new ArrayList<>();
		if (s.equals("")) {
			list.add("");
			trie.put(s, list);
			return list;
		}

		for (String word : dict) {
			if (s.startsWith(word)) {
				// System.out.println(word + " " + s + " " + memo.toString());
				List<String> subs = dfs(s.substring(word.length()), dict, trie);
				trie.put(s.substring(word.length()), subs);
				for (String sub : subs) {
					StringBuilder sb = new StringBuilder(word);
					sb.append((sub.length() > 0) ? " " : "").append(sub);
					list.add(sb.toString());
				}
			}
		}
		return list;
	}

	static class Trie<V> {

		private static final String EMPTY_STRING = "";
		private final TrieNodeType<V> root;

		public Trie(TrieType<V> trieNodeTypeFactory) {
			root = trieNodeTypeFactory.build();
		}

		public boolean contains(String key) {
			assert key != null;
			V val = get(key);
			return val != null;
		}

		public V get(String key) {
			assert key != null;
			TrieNodeType<V> x = key.equals(EMPTY_STRING) ? root : get(root, key, 0);
			if (x == null)
				return null;
			return x.getVal();
		}

		private TrieNodeType<V> get(TrieNodeType<V> node, String key, int d) {
			assert key != null;
			assert d >= 0 && d < key.length();
			if (node == null)
				return null;
			TrieNodeType<V> cur = node;
			for (int i = d; i < key.length(); i++) {
				char c = key.charAt(i);
				cur = cur.find(c);
				if (cur == null)
					return null;
			}
			return cur;
		}

		public void put(String key, V val) {
			assert key != null;
			if (key.equals(EMPTY_STRING)) {
				root.setVal(val);
				return;
			}
			put(root, key, val, 0);
		}

		private void put(TrieNodeType<V> node, String key, V val, int d) {
			assert key != null;
			assert d >= 0;
			assert d < key.length();
			if (node == null)
				return; // TODO :: return false perhaps?
			TrieNodeType<V> cur = node;
			for (int i = d; i < key.length(); i++) {
				char c = key.charAt(i);
				cur = cur.putAndGet(c);
			}
			cur.setVal(val);
		}

		public String toString() {
			return root.toString();
		}

		/*********************************************************************
		 * 
		 * INTERFACES
		 * 
		 *********************************************************************/
		public interface TrieType<V> {
			Trie.TrieNodeType<V> build();
		}

		/*********************************************************************
		 * 
		 * ABSTRACT CLASSES
		 * 
		 *********************************************************************/
		public static abstract class TrieNodeType<V> {
			public TrieNodeType() {
			}

			abstract TrieNodeType<V> find(char c);

			abstract TrieNodeType<V> putAndGet(char c);

			abstract V getVal();

			abstract void setVal(V val);

			abstract String toString(String indent);

			public String toString() {
				return toString("  ");
			}
		}

		/*********************************************************************
		 * 
		 * PUBLIC CLASSES
		 * 
		 *********************************************************************/
		public static class UpperCaseTrieType<V> implements TrieType<V> {
			public TrieNodeType<V> build() {
				return new UpperCaseTrieNodeType<V>();
			}
		}

		public static class LowerCaseTrieType<V> implements TrieType<V> {
			public TrieNodeType<V> build() {
				return new LowerCaseTrieNodeType<V>();
			}
		}

		public static class SortedLinkedListTrieType<V> implements TrieType<V> {
			public TrieNodeType<V> build() {
				return new SortedLinkedListTrieNodeType<V>();
			}
		}

		public static class LinkedListTrieType<V> implements TrieType<V> {
			public TrieNodeType<V> build() {
				return new LinkedListTrieNodeType<V>();
			}
		}

		public class TrieNodeIterator {
			private TrieNodeType<V> node;

			public TrieNodeIterator() {
				node = root;
			}

			public boolean hasNext(char c) {
				return node.find(c) != null;
			}

			public TrieNodeIterator next(char c) {
				TrieNodeType<V> next = node.find(c);
				TrieNodeIterator it = new TrieNodeIterator();
				it.node = next;
				return it;
			}

			public boolean valid() {
				return node != null;
			}

			public boolean hit() {
				return getVal() != null;
			}

			public V getVal() {
				return node == null ? null : node.getVal();
			}

			public String toString() {
				return node == null ? null : node.toString();
			}

		}

		/*********************************************************************
		 * 
		 * PRIVATE CLASSES
		 * 
		 *********************************************************************/
		private static class UpperCaseTrieNodeType<V> extends TrieNodeType<V> {
			private final static int RADIX = 26;
			private final static char BASE = 'A';

			private final UpperCaseTrieNodeType<V>[] next;
			private V val;

			@SuppressWarnings("unchecked")
			public UpperCaseTrieNodeType() {
				next = new UpperCaseTrieNodeType[RADIX];
			}

			@Override
			TrieNodeType<V> find(char c) {
				int id = c - getBaseChar();
				return next[id];
			}

			@Override
			TrieNodeType<V> putAndGet(char c) {
				int id = c - getBaseChar();
				if (next[id] == null)
					next[id] = new UpperCaseTrieNodeType<>();
				return next[id];
			}

			public char getBaseChar() {
				return BASE;
			}

			@Override
			V getVal() {
				return val;
			}

			@Override
			void setVal(V val) {
				this.val = val;
			}

			public String toString(String indent) {
				return toString(indent, 0);
			}

			public String toString(String indent, int level) {
				StringBuilder sb = new StringBuilder();
				for (int l = 1; l <= level; l++)
					sb.append(indent);
				sb.append("val = " + val);
				for (int i = 0; i < next.length; i++) {
					if (next[i] == null)
						continue;
					sb.append("\n");
					sb.append(next[i].toString(indent, level + 1));
				}
				return sb.toString();
			}

		}

		private static class LowerCaseTrieNodeType<V> extends UpperCaseTrieNodeType<V> {

			private final static int RADIX = 26;
			private final static char BASE = 'a';

			private final LowerCaseTrieNodeType<V>[] next;
			private V val;

			@SuppressWarnings("unchecked")
			public LowerCaseTrieNodeType() {
				next = new LowerCaseTrieNodeType[RADIX];
			}

			@Override
			TrieNodeType<V> find(char c) {
				int id = c - getBaseChar();
				return next[id];
			}

			@Override
			TrieNodeType<V> putAndGet(char c) {
				int id = c - getBaseChar();
				if (next[id] == null)
					next[id] = new LowerCaseTrieNodeType<>();
				return next[id];
			}

			public char getBaseChar() {
				return BASE;
			}

			@Override
			V getVal() {
				return val;
			}

			@Override
			void setVal(V val) {
				this.val = val;
			}

			public String toString(String indent) {
				return toString(indent, 0);
			}

			public String toString(String indent, int level) {
				StringBuilder sb = new StringBuilder();
				for (int l = 1; l <= level; l++)
					sb.append(indent);
				sb.append("val = " + val);
				for (int i = 0; i < next.length; i++) {
					if (next[i] == null)
						continue;
					sb.append("\n");
					sb.append(next[i].toString(indent, level + 1));
				}
				return sb.toString();
			}
		}

		private static class SortedLinkedListTrieNodeType<V> extends TrieNodeType<V> {

			private final char c;
			private V val;
			private SortedLinkedListTrieNodeType<V> sibling;
			private SortedLinkedListTrieNodeType<V> child;

			public SortedLinkedListTrieNodeType() {
				c = '\0';
			}

			public SortedLinkedListTrieNodeType(final char c) {
				this.c = c;
			}

			@Override
			TrieNodeType<V> find(char c) {
				SortedLinkedListTrieNodeType<V> cur = child;
				while (cur != null && c > cur.c) // assume increasingly sorted
					cur = cur.sibling;
				return (cur == null || cur.c != c) ? null : cur;
			}

			@Override
			TrieNodeType<V> putAndGet(char c) {
				if (child == null || c < child.c) { // maintaining sorted linked list invariant
					SortedLinkedListTrieNodeType<V> node = new SortedLinkedListTrieNodeType<>(c);
					node.sibling = child;
					child = node;
					return node;
				} else if (c == child.c) {
					return child;
				} else {
					SortedLinkedListTrieNodeType<V> prev = child;
					SortedLinkedListTrieNodeType<V> curr = child.sibling;
					while (curr != null && c > curr.c) { // maintaining sorted linked list invariant
						prev = curr;
						curr = curr.sibling;
					}
					if (curr == null || c != curr.c) { // maintaining sorted linked list invariant
						SortedLinkedListTrieNodeType<V> node = new SortedLinkedListTrieNodeType<>(
								c);
						prev.sibling = node;
						node.sibling = curr;
						return node;
					}
					return curr;
				}
			}

			@Override
			V getVal() {
				return val;
			}

			@Override
			void setVal(V val) {
				this.val = val;
			}

			public String toString(String indent) {
				return toString(indent, 0);
			}

			public String toString(String indent, int level) {
				StringBuilder sb = new StringBuilder();
				for (int l = 1; l <= level; l++)
					sb.append(indent);
				sb.append("{" + c + ": " + val + "}");
				SortedLinkedListTrieNodeType<V> cur = child;
				while (cur != null) {
					sb.append("\n");
					sb.append(cur.toString(indent, level + 1));
					cur = cur.sibling;
				}
				return sb.toString();
			}
		}

		private static class LinkedListTrieNodeType<V> extends TrieNodeType<V> {

			private final char c;
			private V val;
			private LinkedListTrieNodeType<V> sibling;
			private LinkedListTrieNodeType<V> child;

			public LinkedListTrieNodeType() {
				c = '\0';
			}

			public LinkedListTrieNodeType(final char c) {
				this.c = c;
			}

			@Override
			TrieNodeType<V> find(char c) {
				LinkedListTrieNodeType<V> cur = child;
				while (cur != null && c != cur.c)
					cur = cur.sibling;
				return (cur == null) ? null : cur;
			}

			@Override
			TrieNodeType<V> putAndGet(char c) {
				if (child == null) {
					LinkedListTrieNodeType<V> node = new LinkedListTrieNodeType<>(c);
					child = node;
					return node;
				} else {
					LinkedListTrieNodeType<V> prev = null;
					LinkedListTrieNodeType<V> curr = child;
					while (curr != null && c != curr.c) {
						prev = curr;
						curr = curr.sibling;
					}
					if (curr == null) {
						LinkedListTrieNodeType<V> node = new LinkedListTrieNodeType<>(c);
						prev.sibling = node;
						return node;
					}
					return curr;
				}
			}

			@Override
			V getVal() {
				return val;
			}

			@Override
			void setVal(V val) {
				this.val = val;
			}

			public String toString(String indent) {
				return toString(indent, 0);
			}

			public String toString(String indent, int level) {
				StringBuilder sb = new StringBuilder();
				for (int l = 1; l <= level; l++)
					sb.append(indent);
				sb.append("{" + c + ": " + val + "}");
				LinkedListTrieNodeType<V> cur = child;
				while (cur != null) {
					sb.append("\n");
					sb.append(cur.toString(indent, level + 1));
					cur = cur.sibling;
				}
				return sb.toString();
			}
		}

		/*********************************************************************
		 * 
		 * CLIENT
		 * 
		 *********************************************************************/
		public static void main(String[] args) {
			String[] words = { "mary", "bought", "a", "little", "sheep", "beeh" };
			int[] vals = { 1, 2, 3, 4, 5, 6 };
			Trie<Integer> trie = new Trie<>(new SortedLinkedListTrieType<>());
			for (int i = 0; i < words.length; i++) {
				trie.put(words[i], vals[i]);
			}
			System.out.println(trie.toString());
		}
	}
}
