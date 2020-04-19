package org.leetcode.contests.weekly.w0185;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
public class _001418_DisplayTableOfFoodOrdersInARestaurant {
	public List<List<String>> displayTable(List<List<String>> orders) {
		TreeSet<String> dishes = new TreeSet<>();
		TreeMap<Integer, Map<String, Integer>> map = new TreeMap<>();
		for (List<String> order : orders) {
			int table = Integer.parseInt(order.get(1));
			String dish = order.get(2);
			dishes.add(dish);
			Map<String, Integer> pair = map.getOrDefault(table, new HashMap<>());
			int f = pair.getOrDefault(dish, 0);
			f++;
			pair.put(dish, f);
			map.put(table, pair);
		}

		List<List<String>> ans = new LinkedList<>();
		List<String> header = new LinkedList<>();
		header.add("Table");
		for (String dish : dishes)
			header.add(dish);
		ans.add(header);
		for (int table : map.keySet()) {
			List<String> row = new LinkedList<>();
			row.add(Integer.toString(table));
			Map<String, Integer> dishCounts = map.get(table);
			for (String dish : dishes)
				row.add(Integer.toString(dishCounts.getOrDefault(dish, 0)));
			ans.add(row);
		}
		return ans;
	}
}
