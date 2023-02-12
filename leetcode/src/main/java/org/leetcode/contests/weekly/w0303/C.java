package org.leetcode.contests.weekly.w0303;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {

}

class FoodRatings {

	Map<String, Integer> food2rat;
	Map<String, String> food2cui;
	Map<String, TreeMap<Integer, TreeSet<String>>> cui2rat2food;

	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
		food2rat = new HashMap<>();
		food2cui = new HashMap<>();
		cui2rat2food = new HashMap<>();
		int n = foods.length;
		for (int i = 0; i < n; i++) {
			food2rat.put(foods[i], ratings[i]);
			food2cui.put(foods[i], cuisines[i]);
			cui2rat2food.computeIfAbsent(cuisines[i], tm -> new TreeMap<>());
			TreeMap<Integer, TreeSet<String>> ratingTree = cui2rat2food.get(cuisines[i]);
			ratingTree.computeIfAbsent(ratings[i], tm -> new TreeSet<>()).add(foods[i]);
		}
	}

	public void changeRating(String food, int newRating) {
		String cuisine = food2cui.get(food);
		int oldRating = food2rat.get(food);
		if (oldRating == newRating)
			return;

		TreeMap<Integer, TreeSet<String>> ratingTree = cui2rat2food.get(cuisine);
		ratingTree.get(oldRating).remove(food);
		if (ratingTree.get(oldRating).size() == 0) {
			ratingTree.remove(oldRating);
		}
		ratingTree.computeIfAbsent(newRating, tm -> new TreeSet<>()).add(food);
		food2rat.put(food, newRating);
	}

	public String highestRated(String cuisine) {
		return cui2rat2food.get(cuisine).lastEntry().getValue().first();
	}
}
