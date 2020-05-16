package org.leetcode.contests.biweekly.bw0026;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001449_FormLargestIntegerWithDigitsThatAddUpToTarget {
	public String largestNumber(int[] cost, int target) {
		Set<Integer> seen = new HashSet<>();
		for (int i = 8; i >= 0; i--) {
			int c = cost[i];
			if (seen.contains(c))
				cost[i] = -1;
			else
				seen.add(cost[i]);
		}
		Queue<StringBuilder> qsb = new LinkedList<>();
		Queue<Integer> qcost = new LinkedList<>();
		String best = "";
		Map<Integer, String> seenCosts = new HashMap<>();
		for (int d = 9; d >= 1; d--) {
			if (cost[d - 1] == -1)
				continue;
			StringBuilder sb = new StringBuilder();
			sb.append((char) (d + '0'));
			int c = cost[d - 1];
			if (c == target) {
				return sb.toString();
			} else if (c > target) {
				continue;
			}
			qsb.add(sb);
			qcost.add(c);
		}
		while (!qsb.isEmpty()) {
			StringBuilder sb = qsb.poll();
			int c = qcost.poll();
			for (int d = 9; d >= 1; d--) {
				if (cost[d - 1] == -1)
					continue;
				int nc = c + cost[d - 1];
				if (nc == target) {
//					sb.append((char) (d + '0'));
					String candidate = sb.toString() + ((char) (d + '0'));
					if (candidate.length() > best.length())
						best = candidate;
					else if (candidate.length() == best.length() && candidate.compareTo(best) > 0)
						best = candidate;
//					return sb.toString();
				} else if (nc < target) {
					StringBuilder nsb = new StringBuilder(sb);
					nsb.append((char) (d + '0'));
					if (seenCosts.containsKey(nc)) {
						String lbest = seenCosts.get(nc);
						String candidate = nsb.toString();
						if (candidate.length() <= lbest.length()) {
							continue;
						}
					}
					seenCosts.put(nc, nsb.toString());
					qsb.add(nsb);
					qcost.add(nc);
				}
			}
		}
		return best.equals("") ? "0" : best;
	}
}
