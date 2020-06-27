package org.leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001487_MakingFileNamesUnique {
	public String[] getFolderNames(String[] names) {
		int n = names.length;
		String[] ans = new String[n];
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String name = names[i];
			if (!set.contains(name)) {
				ans[i] = name;
				set.add(name);
			} else {
				int k = map.getOrDefault(name, 0) + 1;
				while (true) {
					StringBuilder sb = new StringBuilder();
					sb.append(names[i]).append('(').append(k).append(')');
					String cand = sb.toString();
					if (!set.contains(cand)) {
						ans[i] = cand;
						set.add(cand);
						map.put(name, k);
						break;
					}
					k++;
				}
			}
		}
		return ans;
	}
}
