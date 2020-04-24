package org.leetcode.problems;

import java.util.*;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000068_TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		int nWords = words.length;
		List<String> ans = new LinkedList<>();
		int from = 0;
		while (from < nWords) {
			int curWidth = 0; // total width of words for current row, INCLUDING 1 space in between each word
			int nWordsIncluded = 0; // word count for current row
			while (from + nWordsIncluded < nWords) {
				int cur = from + nWordsIncluded;
				curWidth += words[cur].length();
				if (nWordsIncluded > 0)
					curWidth++; // add 1 for the space in-between
				if (curWidth > maxWidth) {
					curWidth -= words[cur].length() + 1; // max width exceeded; subtract last word and its space
					break;
				}
				nWordsIncluded++; // word added
			}
			int spaceAvailable = maxWidth - (curWidth - nWordsIncluded + 1); // number of spaces to fill
			int[] spacings; // number of spaces after each word of the current row
			if (from + nWordsIncluded == nWords)
				spacings = calculateSpacings(nWordsIncluded, spaceAvailable, maxWidth, true);
			else
				spacings = calculateSpacings(nWordsIncluded, spaceAvailable, maxWidth, false);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < nWordsIncluded; i++) {
				sb.append(words[from + i]);
				for (int j = 0; j < spacings[i]; j++)
					sb.append(' ');
			}
			ans.add(sb.toString());
			from += nWordsIncluded;
		}
		return ans;
	}

	int[] calculateSpacings(int nWords, int spaceAvailable, int maxWidth, boolean lastLine) {
		int[] spacings = new int[nWords];
		if (nWords == 1) {
			spacings[0] = spaceAvailable;
		} else if (lastLine) {
			Arrays.fill(spacings, 1);
			spacings[spacings.length - 1] = spaceAvailable - nWords + 1;
		} else {
			int minSpace = spaceAvailable / (nWords - 1);
			Arrays.fill(spacings, minSpace);
			spacings[spacings.length - 1] = 0;
			for (int i = 0; i < spaceAvailable % (nWords - 1); i++)
				spacings[i]++;
		}
		return spacings;
	}
}
