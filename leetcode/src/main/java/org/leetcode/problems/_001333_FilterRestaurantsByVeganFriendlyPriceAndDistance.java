package org.leetcode.problems;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001333_FilterRestaurantsByVeganFriendlyPriceAndDistance {
	public List<Integer> filterRestaurants(final int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
		int n = restaurants.length;
		List<Integer> filtered = new LinkedList<>();
		
		// Filter
		for (int i = 0; i < n; i++) {
			if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance)
				filtered.add(i);
		}
		
		// Sort by rating(desc), index(desc)
		Collections.sort(filtered, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if (restaurants[a][1] < restaurants[b][1])
					return 1;
				if (restaurants[a][1] > restaurants[b][1])
					return -1;
				if (restaurants[a][0] < restaurants[b][0])
					return 1;
				if (restaurants[a][0] > restaurants[b][0])
					return -1;
				return 0;
			}
		});
		
		// Get ids (may differ from 0..n indexing)
		List<Integer> ids = new LinkedList<>();
		for (int index : filtered)
			ids.add(restaurants[index][0]);
		return ids;
	}
}
