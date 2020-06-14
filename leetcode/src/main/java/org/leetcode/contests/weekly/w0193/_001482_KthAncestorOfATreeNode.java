package org.leetcode.contests.weekly.w0193;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001482_KthAncestorOfATreeNode {
	class TreeAncestor {
		int[][] log;

		public TreeAncestor(int n, int[] parent) {

			log = logStepSuccessors(parent);
		}

		public int getKthAncestor(int node, int k) {
			return successor(node, k, log);
		}

		int successor(int node, int steps, int[][] succ) {
			for (int i = 0; steps > 0 && node != -1; i++, steps >>= 1) {
				if ((steps & 1) == 1)
					node = succ[node][i];
			}
			return node;
		}

		// Assumes successor graph(each node has outdegree <= 1)
		int[][] logStepSuccessors(int[] to) {
			final int NOWHERE = -1;
			int n = to.length;
			// ceiling( logn(base2) )
			int maxStep = Integer.numberOfTrailingZeros(Integer.highestOneBit(n - 1)) + 1;
			int[][] ret = new int[n][maxStep];
			for (int i = 0; i < n; i++)
				ret[i][0] = to[i];
			for (int step = 1; step < maxStep; step++) {
				for (int i = 0; i < n; i++) {
					ret[i][step] = ret[i][step - 1] == NOWHERE ? NOWHERE
							: ret[ret[i][step - 1]][step - 1];
				}
			}
			return ret;
		}
	}
}
