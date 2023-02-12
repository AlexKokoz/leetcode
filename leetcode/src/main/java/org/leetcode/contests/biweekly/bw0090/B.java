package org.leetcode.contests.biweekly.bw0090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public List<String> twoEditWords(String[] queries, String[] dictionary) {
		int nq = queries.length;
		int nd = dictionary.length;
		int m = dictionary[0].length();
		if (m == 1) {
			return Arrays.asList(queries);
		}
		List<String> ans = new ArrayList<>();
		outer: for (int i = 0; i < nq; i++) {
			for (int j = 0; j < nd; j++) {
				int same = 0;
				for (int k = 0; k < m; k++) {
					if (queries[i].charAt(k) == dictionary[j].charAt(k)) {
						same++;
					}
				}
				if (same + 2 >= m) {
					ans.add(queries[i]);
					continue outer;
				}
			}
		}

		return ans;
	}

}
