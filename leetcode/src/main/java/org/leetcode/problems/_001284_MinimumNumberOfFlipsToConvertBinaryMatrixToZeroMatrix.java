package org.leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001284_MinimumNumberOfFlipsToConvertBinaryMatrixToZeroMatrix {
	public int minFlips(int[][] mat) {
		Set<Integer> seen = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		int ans = 0;
		int n = mat.length;
		int m = mat[0].length;
		int stateLength = n * m;
		
		// build initial state; ie for [1,1,1],[1,0,1],[0,0,0] => 111101000
		int index = n * m - 1;
		int state = 0;
		for (int[] row : mat)  {
			for (int d : row){
				if (d == 1)
                    state |= (1 << index);
                index--;
            }
		}
		
		// already on target state
		if (state == 0)
			return 0;
		
		// BFS
		seen.add(state);
		q.add(state);
		while (!q.isEmpty()) {
            ans++;
			for (int i = 0, len = q.size(); i < len; i++) {
				int curState = q.poll();
				for (int j = 0; j < stateLength; j++) {
					int newState = performStep(curState, j, n, m);
					if (newState == 0)
						return ans;
					if (seen.contains(newState))
						continue;
					seen.add(newState);
					q.add(newState);
				}
			}
		}
		
		
		return -1;
	}
    
    int performStep(int state, int pos, int R, int C) {

		int row = pos / C;
		int col = pos % C;
        
        if (row > 0)     state ^= (1 << ((row - 1) * C + col)); // flip top (if it exists)
        if (row < R - 1) state ^= (1 << ((row + 1) * C + col)); // flip bottom (if it exists)
        if (col > 0)     state ^= (1 << (row * C + (col - 1))); // flip left (if it exists)
        if (col < C - 1) state ^= (1 << (row * C + (col + 1))); // flip right (if it exists)
        state ^= (1 << pos);                                    // flip center
        
        return state;
    }
}
