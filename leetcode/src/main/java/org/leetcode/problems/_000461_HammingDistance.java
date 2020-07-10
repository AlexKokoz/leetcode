package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000461_HammingDistance {
	public int hammingDistance(int x, int y) {
	        int ans = 0;
	        while(x > 0 || y > 0) {
	            if (x << ~0 < 0 ^ y << ~0 < 0) ans++;
	            x >>= 1;
	            y >>= 1;
	        }
	        return ans;
	    }
}
