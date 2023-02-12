package org.leetcode.contests.biweekly.bw0085;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public String shiftingLetters(String s, int[][] shifts) {
		int n = s.length();
		int[] count = new int[n + 1];
		char[] cs = s.toCharArray();
		for (int[] shift : shifts) {
			int start = shift[0], end = shift[1], direction = shift[2];
			if (direction == 1) {
				count[start]++;
				count[end + 1]--;
			} else {
				count[start]--;
				count[end + 1]++;
			}
		}
		for (int i = 1; i < n; i++) {
			count[i] += count[i - 1];
		}
		for (int i = 0; i < n; i++) {
			count[i] %= 26;
			if (count[i] < 0)
				count[i] += 26;
		}

		for (int i = 0; i < n; i++) {
			int id = cs[i] - 'a';
			id += count[i];
			id %= 26;
			cs[i] = (char) (id + 'a');
		}
		return String.valueOf(cs);
	}
}
