package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001286_IteratorForCombination {
	static class CombinationIterator {
		int len;
		int[] indices;
		char[] chars;
		boolean hasNext;

		public CombinationIterator(String characters, int combinationLength) {
			chars = characters.toCharArray();
			indices = new int[combinationLength];
			for (int i = 0; i < indices.length; i++)
				indices[i] = i;
			hasNext = true;
		}

		public String next() {
			StringBuilder sb = new StringBuilder();
			for (int i : indices)
				sb.append(chars[i]);
			// find next
			int next = indices.length - 1;
			while (next >= 0 && ((next == indices.length - 1 && indices[next] == chars.length - 1)
					|| (next < indices.length - 1 && indices[next] == indices[next + 1] - 1))) {
				next--;
			}
			if (next == -1)
				hasNext = false;
			else {
				indices[next]++;
				for (int i = next + 1; i < indices.length; i++)
					indices[i] = indices[i - 1] + 1;
			}
			return sb.toString();
		}

		public boolean hasNext() {
			return hasNext;
		}
	}

}
