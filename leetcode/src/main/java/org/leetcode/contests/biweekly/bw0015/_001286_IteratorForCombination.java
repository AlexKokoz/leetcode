package org.leetcode.contests.biweekly.bw0015;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001286_IteratorForCombination {
	static class CombinationIterator {
		private final int[] indices;
		private final char[] chars;
		private final int length;
		private boolean hasNext = true;

		public CombinationIterator(String characters, int combinationLength) {
			this.indices = new int[combinationLength];
			for (int i = 0; i < this.indices.length; i++)
				indices[i] = i;
			this.chars = characters.toCharArray();
			this.length = characters.length();
		}

		public String next() {
			final StringBuilder sb = new StringBuilder();
			for (int index : indices) {
				sb.append(chars[index]);
			}
			int next = indices.length - 1;

			while (next >= 0 && (indices[next] + 1 >= length
					|| (next < indices.length - 1 && indices[next] + 1 == indices[next + 1])))
				next--;

			if (next < 0)
				hasNext = false;
			else {

				indices[next]++;

				for (int i = next + 1; i < indices.length; i++) {
					indices[i] = indices[i - 1] + 1;
				}
			}
			return sb.toString();
		}

		public boolean hasNext() {
			return hasNext;
		}
	}

}
