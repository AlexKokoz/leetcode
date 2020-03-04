package org.leetcode.problems;

/**
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001361_ValidateBinaryTreeNodes {
	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		int[] indeg = new int[n];
		for (int i = 0; i < n; i++) {
			if (leftChild[i] != -1)
				indeg[leftChild[i]]++;
			if (rightChild[i] != -1)
				indeg[rightChild[i]]++;
		}
		int nRoots = 0;
		for (int x : indeg) {
			if (x > 1)
				return false;
			if (x == 0)
				nRoots++;
			if (nRoots > 1)
				return false;
		}
		if (nRoots == 0)
			return false;
		return true;

	}
}
