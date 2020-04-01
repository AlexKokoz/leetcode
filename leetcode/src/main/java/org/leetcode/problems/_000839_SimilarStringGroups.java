package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000839_SimilarStringGroups {
	public int numSimilarGroups(String[] A) {
		int n = A.length;
		WeightedQuickUnion qu = new WeightedQuickUnion(n);
		for (int i = 0; i < n - 1; i++)
			for (int j = i + 1; j < n; j++)
				if (areSimilar(A[i],A[j]))
					qu.union(i, j);
		return qu.componentCount;
	}

	boolean areSimilar(String s1, String s2) {
		int ndiff = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i))
				ndiff++;
			if (ndiff > 2)
				return false;
		}
		return true;
	}

	void swap(int i, int j, StringBuilder sb) {
		char a = sb.charAt(i);
		char b = sb.charAt(j);
		sb.setCharAt(i, b);
		sb.setCharAt(j, a);
	}

	class WeightedQuickUnion {

		private final int[] id;
		private final int[] size;
		private int componentCount;

		public WeightedQuickUnion(int n) {
			componentCount = n;
			id = new int[n];
			size = new int[n];
			for (int i = 0; i < size.length; i++) {
				id[i] = i;
				size[i] = 1;
			}
		}

		public boolean connected(int i, int j) {
			return find(i) == find(j);
		}

		public void union(int i, int j) {
			validate(i);
			validate(j);
			final int p = find(i);
			final int q = find(j);
			if (p == q)
				return;
			componentCount--;
			if (size[p] > size[q]) {
				id[q] = p;
				size[p] += size[q];
			} else {
				id[p] = q;
				size[q] += size[p];
			}

		}

		public int componentCount() {
			return componentCount;
		}

		public int find(int i) {
			validate(i);
			while (id[i] != i) {
				id[i] = id[id[i]];
				i = id[id[i]];
			}
			return i;
		}

		private void validate(int i) {
			final int n = id.length;
			if (i < 0 || i >= n)
				throw new IllegalArgumentException("p: " + i + " is not between 0 and " + (n - 1));
		}
	}
}
