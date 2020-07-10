package org.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000957_PrisonCellsAfterNDays {
	public int[] prisonAfterNDays(int[] cells, int N) {
		Map<Integer, Integer> val = new HashMap<>();
		Map<Integer, Integer> pos = new HashMap<>();
		val.put(hash(cells), 0);
		pos.put(0, hash(cells));
		int cycleStart = 0;
		int p = 0;
		for (int i = 1; i < (1 << 6); i++) {
			update(cells);
			int hash = hash(cells);
			if (val.containsKey(hash)) {
				cycleStart = val.get(hash);
				p = val.size();
				break;
			} else {
				val.put(hash, i);
				pos.put(i, hash);
			}
		}
		if (N >= p) {
			N = cycleStart + (N - cycleStart) % (p - cycleStart);
		}
		return expand(pos.get(N));
	}

	void update(int[] arr) {
		int pre = arr[0];
		for (int i = 1; i < arr.length - 1; i++) {
			int nxt = arr[i + 1];
			int cur = arr[i];
			arr[i] = pre == nxt ? 1 : 0;
			pre = cur;
		}
		arr[0] = arr[arr.length - 1] = 0;
	}

	int hash(int[] arr) {
		int h = 0;
		int p = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			h += arr[i] * p;
			p *= 2;
		}
		return h;
	}

	int[] expand(int hash) {
		int[] ret = new int[8];
		for (int i = 0; i < ret.length; i++) {
			ret[ret.length - i - 1] = (hash << ~i < 0) ? 1 : 0;
		}
		return ret;
	}
}
