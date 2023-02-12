package org.leetcode.contests.biweekly.bw0052;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001860_IncrementalMemoryLeak {
	public int[] memLeak(int memory1, int memory2) {
		int[] ret = new int[3];
		int time = 1;
		while (true) {
			int max = Math.max(memory1, memory2);
			if (time > max) {
				ret[0] = time;
				ret[1] = memory1;
				ret[2] = memory2;
				break;
			}
			if (max == memory1) {
				memory1 -= time;
			} else {
				memory2 -= time;
			}
			time++;
		}
		return ret;
	}
}
