package org.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000438_FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		int np = p.length();
		int ns = s.length();
		List<Integer> ans = new LinkedList<>();
		if (np > ns)
			return ans;

		Map<Character, Integer> pmap = new HashMap<>();
		for (int i = 0; i < np; i++) {
			int freq = pmap.getOrDefault(p.charAt(i), 0) + 1;
			pmap.put(p.charAt(i), freq);
		}

		Map<Character, Integer> smap = new HashMap<>();
		for (int i = 0; i < np; i++) {
			int freq = smap.getOrDefault(s.charAt(i), 0) + 1;
			smap.put(s.charAt(i), freq);
		}
		if (compareMaps(pmap, smap))
			ans.add(0);

		for (int i = np; i < ns; i++) {
			char nextChar = s.charAt(i);
			char prevChar = s.charAt(i - np);
			int nextFreq = smap.getOrDefault(nextChar, 0) + 1;
			smap.put(nextChar, nextFreq);
			int prevFreq = smap.get(prevChar) - 1;
			if (prevFreq == 0)
				smap.remove(prevChar);
			else
				smap.put(prevChar, prevFreq);
			if (compareMaps(pmap, smap))
				ans.add(i - np + 1);
		}
		return ans;
	}

	boolean compareMaps(Map<Character, Integer> amap, Map<Character, Integer> bmap) {
		if (amap.size() != bmap.size())
			return false;
		for (char c : amap.keySet()) {
			if (!bmap.containsKey(c))
				return false;
			int a = amap.get(c);
			int b = bmap.get(c);
			if (a != b) {
				return false;
			}
		}
		return true;
	}
}
