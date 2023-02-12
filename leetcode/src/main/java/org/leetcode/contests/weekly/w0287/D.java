package org.leetcode.contests.weekly.w0287;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class D {
	class Encrypter {
		Map<Character, String> map;
		Map<String, Integer> score;

		public Encrypter(char[] keys, String[] values, String[] dictionary) {
			map = new HashMap<>();
			score = new HashMap<>();
			for (int i = 0; i < keys.length; i++) {
				map.put(keys[i], values[i]);
			}
			for (String word : dictionary) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < word.length(); i++) {
					sb.append(map.get(word.charAt(i)));
				}
				String s = sb.toString();
				score.put(s, score.getOrDefault(s, 0) + 1);
			}
		}

		public String encrypt(String word1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < word1.length(); i++) {
				sb.append(map.get(word1.charAt(i)));
			}
			return sb.toString();
		}

		public int decrypt(String word2) {
			return score.getOrDefault(word2, 0);
		}

	}
}
