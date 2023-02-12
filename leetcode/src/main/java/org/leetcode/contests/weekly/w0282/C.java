package org.leetcode.contests.weekly.w0282;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class C {
	public long minimumTime(int[] time, int totalTrips) {
	        long ans = Long.MAX_VALUE;
	        long lo = 0;
	        long hi = Long.MAX_VALUE / 2;
	        while (lo <= hi) {
	            long mi = lo + (hi - lo) / 2;
	            if (ok(time, totalTrips, mi)) {
	                ans = Math.min(ans, mi);
	                hi = mi - 1;
	            } else {
	                lo = mi + 1;
	            }
	        }
	         
	        return ans;
	    }
	    
	    boolean ok(int[] trips, int target, long cand) {
	        long have = 0;
	        for (int trip : trips) {
	            have += cand / trip;
	            if (have >= target) return true; // avoid overflow!!
	        }
	        return have >= target;
	    }
}
