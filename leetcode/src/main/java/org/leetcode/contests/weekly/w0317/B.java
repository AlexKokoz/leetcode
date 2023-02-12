package org.leetcode.contests.weekly.w0317;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class B {
	public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
		int n = creators.length;
		List<List<String>> ans = new ArrayList<>();
		String[][] civ = new String[n][];
		for (int i = 0; i < n; i++) {
			civ[i] = new String[] { creators[i], ids[i], "" + views[i] };
		}
		Arrays.sort(civ, (a, b) -> {
			return a[0].compareTo(b[0]);
		});
		long maxTotalViews = -1;
		for (int i = 0; i < n;) {
			int j = i;
			long totalViews = 0;
			long maxVideoViews = -1;
			String maxVideo = "";
			while (j < n && civ[i][0].equals(civ[j][0])) {
				long curViews = Long.parseLong(civ[j][2]);
				totalViews += curViews;
				if (curViews > maxVideoViews) {
					maxVideoViews = curViews;
					maxVideo = civ[j][1];
				} else if (curViews == maxVideoViews && civ[j][1].compareTo(maxVideo) < 0) {
					maxVideo = civ[j][1];
				}

				j++;
			}
			if (totalViews > maxTotalViews) {
				maxTotalViews = totalViews;
				ans = new ArrayList<>();
				ans.add(Arrays.asList(civ[i][0], maxVideo));
			} else if (totalViews == maxTotalViews) {
				ans.add(Arrays.asList(civ[i][0], maxVideo));
			}
			i = j;
		}
		return ans;
	}
}
