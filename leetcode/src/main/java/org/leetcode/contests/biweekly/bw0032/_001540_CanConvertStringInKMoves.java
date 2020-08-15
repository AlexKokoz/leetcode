package org.leetcode.contests.biweekly.bw0032;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001540_CanConvertStringInKMoves {
	public boolean canConvertString(String s, String t, int k) {
		int ns = s.length();
		int nt = t.length();
		if (ns != nt) return false;
		int[] ct = new int[26];
		for (int i = 0; i < ct.length; i++)
			ct[i] = i;
		for (int i = 0; i  < ns; i++) {
			int ids= s.charAt(i) - 'a';
			int idt = t.charAt(i) - 'a';
			if (ids == idt) continue;
			int shift = (ids < idt) ? idt - ids : 26 - (ids - idt);
			int nshift = ct[shift];
			if (nshift > k) return false;
			ct[shift] += 26;
		}
		return true;
	}
}
