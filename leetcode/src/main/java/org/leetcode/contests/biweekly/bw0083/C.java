package org.leetcode.contests.biweekly.bw0083;

import java.util.HashMap;
import java.util.Map;
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

class NumberContainers {

	Map<Integer, Integer> index2num;
	Map<Integer, TreeSet<Integer>> num2indexes;

	public NumberContainers() {
		index2num = new HashMap<>();
		num2indexes = new HashMap<>();
	}

	public void change(int index, int number) {
		int oldNum = index2num.getOrDefault(index, -1);
		if (oldNum == number)
			return;
		index2num.put(index, number);
		num2indexes.computeIfAbsent(number, s -> new TreeSet<>()).add(index);
		if (oldNum != -1 && num2indexes.containsKey(oldNum)) {
			num2indexes.get(oldNum).remove(index);
		}
	}

	public int find(int number) {
		if (num2indexes.containsKey(number)) {
			TreeSet<Integer> set = num2indexes.get(number);
			return set.isEmpty() ? -1 : set.first();
		} else {
			return -1;
		}
	}
}
