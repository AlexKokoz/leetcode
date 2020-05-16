package org.leetcode.contests.biweekly.bw0026;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001447_SimplifiedFractions {
	public List<String> simplifiedFractions(int n) {
		List<String> ans = new LinkedList<>();
		boolean[][] seen = new boolean[n + 1][n + 1];
		for (int den = 1; den <= n; den++) {
			for (int nom = 1; nom < den; nom++) {
				if (!seen[nom][den]) {
					int nnom = nom + nom;
					int nden = den + den;
					while (nnom <= n && nden <= n) {
						seen[nnom][nden] = true;
						nnom += nom;
						nden += den;
					}
				}
			}
		}

		for (int den = 1; den <= n; den++) {
			for (int nom = 1; nom < den; nom++) {
				if (!seen[nom][den]) {
					ans.add(nom + "/" + den);
				}
			}
		}

		return ans;
	}
}
