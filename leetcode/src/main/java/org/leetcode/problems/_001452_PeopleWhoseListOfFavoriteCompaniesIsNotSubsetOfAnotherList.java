package org.leetcode.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001452_PeopleWhoseListOfFavoriteCompaniesIsNotSubsetOfAnotherList {
	
	public List<Integer> peopleIndexes(List<List<String>> fav) {
		int n = fav.size();
		List<Integer> ans = new LinkedList<>();
		Map<List<String>, Integer> map = new HashMap<>();
		@SuppressWarnings("unchecked")
		Set<String>[] set = new Set[n];

		for (int i = 0; i < n; i++) {
			map.put(fav.get(i), i);
		}

		Collections.sort(fav, new Comparator<List<String>>() {
			public int compare(List<String> a, List<String> b) {
				return a.size() - b.size();
			}
		});

		for (int r = 0; r < n; r++) {
			set[r] = new HashSet<>();
			for (String c : fav.get(r)) {
				set[r].add(c);
			}
		}
		boolean[] marked = new boolean[n];
		outer: for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (isSubset(i, j, set)) {
					marked[i] = true;
					continue outer;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (!marked[i]) {
				ans.add(map.get(fav.get(i)));
			}
		}
		Collections.sort(ans);
		return ans;
	}

	boolean isSubset(int i, int j, Set<String>[] set) {
		for (String comp : set[i]) {
			if (!set[j].contains(comp)) {
				return false;
			}
		}
		return true;
	}
}
