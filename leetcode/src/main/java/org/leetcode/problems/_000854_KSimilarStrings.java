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
public class _000854_KSimilarStrings {
	public int kSimilarity(String A, String B) {
		if (A.equals(B))
			return 0;

		StringBuilder sbA = new StringBuilder();
		StringBuilder sbB = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				sbA.append(A.charAt(i));
				sbB.append(B.charAt(i));
			}
		}
		A = sbA.toString();
		B = sbB.toString();

		int n = A.length();
		int ans = 0;
		Set<String> seen = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.add(A);
		seen.add(A);
		outer: while (!q.isEmpty()) {
			ans++;
			for (int i = 0, len = q.size(); i < len; i++) {
				char[] chars = q.poll().toCharArray();
				int l = 0;
				while (l < n && chars[l] == B.charAt(l))
					l++;
				for (int r = l + 1; r < n; r++) {
					if (chars[r] != B.charAt(l))
						continue;
					swap(l, r, chars);
					String nA = String.valueOf(chars);
					if (nA.equals(B))
						break outer;
					if (!seen.contains(nA)) {
						seen.add(nA);
						q.add(nA);
					}
					swap(l, r, chars);
				}
			}
		}
		return ans;
	}

	void swap(int i, int j, char[] chars) {
		char a = chars[i];
		char b = chars[j];
		chars[i] = b;
		chars[j] = a;
	}
}
