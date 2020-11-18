package org.leetcode.contests.weekly.w0215;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001656_DesignOrderedStream {
	class OrderedStream {

		String[] arr;
		int p;

		public OrderedStream(int n) {
			arr = new String[n + 1];
			p = 1;
		}

		public List<String> insert(int id, String value) {
			arr[id] = value;
			List<String> list = new ArrayList<>();
			if (p != id)
				return list;
			while (p < arr.length && arr[p] != null) {
				list.add(arr[p++]);
			}
			return list;
		}
	}
}
