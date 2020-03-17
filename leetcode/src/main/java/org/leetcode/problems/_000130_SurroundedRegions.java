package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000130_SurroundedRegions {
	int[] id;
	int[] sz;

	public void solve(char[][] a) {
		int nr = a.length;
		if (nr == 0)
			return;
		int nc = a[0].length;
		id = new int[nr * nc + 1];
		for (int i = 0; i < id.length; i++)
			id[i] = i;
		sz = new int[nr * nc + 1];
		for (int i = 0; i < sz.length; i++)
			sz[i] = 1;

		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				int ch = a[r][c];
				if (ch != 'O')
					continue;
				int src = nc * r + c;
				if (r == 0 || c == 0 || r == nr - 1 || c == nc - 1) {
					union(src, id.length - 1);
					continue;
				}
				if (a[r - 1][c] == 'O')
					union(src, nc * (r - 1) + c);
				if (a[r + 1][c] == 'O')
					union(src, nc * (r + 1) + c);
				if (a[r][c - 1] == 'O')
					union(src, nc * r + c - 1);
				if (a[r][c + 1] == 'O')
					union(src, nc * r + c + 1);
			}
		}

		for (int r = 0; r < nr; r++) {
			for (int c = 0; c < nc; c++) {
				if (a[r][c] != 'O')
					continue;
				int src = nc * r + c;
				int boundary = id.length - 1;
				if (!connected(src, boundary))
					a[r][c] = 'X';
			}
		}
	}

	void union(int v, int w) {
		int p = find(v);
		int q = find(w);
		if (p == q)
			return;
		if (sz[p] > sz[q]) {
			id[q] = p;
			sz[p] += sz[q];
		} else {
			id[p] = q;
			sz[q] += sz[p];
		}
	}

	int find(int v) {
		while (v != id[v]) {
			id[v] = id[id[v]];
			v = id[v];
		}
		return v;
	}

	boolean connected(int v, int w) {
		return find(v) == find(w);
	}
}
