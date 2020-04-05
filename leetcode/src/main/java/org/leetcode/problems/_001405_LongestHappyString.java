package org.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001405_LongestHappyString {

	public String longestDiverseString(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		int[][] c2f = new int[3][2]; // char, frequency
		c2f[0] = new int[] { 'a', a };
		c2f[1] = new int[] { 'b', b };
		c2f[2] = new int[] { 'c', c };

		outer: while (true) {
			// sort by descending frequency
			Arrays.sort(c2f, new Comparator<int[]>() {
				public int compare(int[] a, int[] b) {
					return b[1] - a[1];
				}
			});
			for (int i = 0; i < c2f.length; i++) {
				int ch = c2f[i][0]; // current char (as integer ASCII code)
				int f = c2f[i][1]; // current frequency
				if (f == 0) // skip chars with no available occurences
					continue;
				// IF result contains at most1 char, OR 
				//    current char is not the same as result's last char, OR
				//    last result's last 2 chars are not the same, 
				// THEN
				//    add current char to result and decrease its frequency by 1
				//    continue the outer loop because the frequency ordering might have changed
				if (sb.length() <= 1 || 
				    ch != sb.charAt(sb.length() - 1) || 
				    sb.charAt(sb.length() - 1) != sb.charAt(sb.length() - 2)) {
					sb.append((char) ch);
					c2f[i][1]--;
					continue outer;
				}
			}
			break; // no change has been done in the last round; STOP
		}
		return sb.toString();
	}
}
