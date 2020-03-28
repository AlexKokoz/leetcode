package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000990_SatisfiabilityOfEqualityEquations {
	public boolean equationsPossible(String[] equations) {
		WeightedQuickUnion qu = new WeightedQuickUnion(26);
		for (String e : equations) {
			char var1 = e.charAt(0);
			char var2 = e.charAt(3);
			if (e.charAt(1) == '=') {
				qu.union(var1 - 'a', var2 - 'a');
			}
		}
		
		for (String e : equations) {
			char var1 = e.charAt(0);
			char var2 = e.charAt(3);
			if (e.charAt(1) == '!' && qu.connected(var1 - 'a', var2 - 'a')) {
				return false;
			}
		}
		return true;
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
