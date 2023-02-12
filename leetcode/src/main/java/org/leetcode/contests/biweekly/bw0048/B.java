package org.leetcode.contests.biweekly.bw0048;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
}

class AuthenticationManager {
	PriorityQueue<Pair> pq;
	Map<String, Integer> map;
	int dur;

	public AuthenticationManager(int timeToLive) {
		map = new HashMap<>();
		pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a.s, b.s);
		});
		dur = timeToLive;
	}

	public void generate(String tokenId, int currentTime) {
		map.put(tokenId, currentTime + dur);
		pq.add(new Pair(tokenId, currentTime + dur));
	}

	public void renew(String tokenId, int currentTime) {
		Integer prev = map.get(tokenId);
		if (prev != null) {
			if (prev <= currentTime) {
				map.remove(tokenId);
			} else {
				map.put(tokenId, currentTime + dur);
			}
		}
	}

	public int countUnexpiredTokens(int currentTime) {
		while (!pq.isEmpty()) {
			Pair p = pq.poll();
			if (p.s > currentTime) {
				pq.add(p);
				break;
			}
			if (!map.containsKey(p.f))
				continue;
			p.s = map.get(p.f);
			if (p.s <= currentTime) {
				map.remove(p.f);
			} else {
				pq.add(p);
			}
		}
		return map.size();
	}

	static class Pair {
		String f;
		Integer s;

		public Pair(String f, Integer s) {
			this.f = f;
			this.s = s;
		}

		public boolean equals(Object o) {
			if (o == null)
				return false;
			if (o == this)
				return true;
			if (getClass() != o.getClass())
				return false;
			Pair that = (Pair) o;
			return f == that.f && s == that.s;
		}

		public int hashCode() {
			int hash = 7;
			hash = 31 * hash + f.hashCode();
			hash = 31 * hash + s.hashCode();
			return hash;
		}

		public String toString() {
			return f + " " + s;
		}
	}
}
