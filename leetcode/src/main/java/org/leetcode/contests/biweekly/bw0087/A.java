package org.leetcode.contests.biweekly.bw0087;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class A {
	public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
		int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int ans = 0;
		int am1 = Integer.parseInt(arriveAlice.substring(0, 2));
		int ad1 = Integer.parseInt(arriveAlice.substring(3));
		int am2 = Integer.parseInt(leaveAlice.substring(0, 2));
		int ad2 = Integer.parseInt(leaveAlice.substring(3));
		int bm1 = Integer.parseInt(arriveBob.substring(0, 2));
		int bd1 = Integer.parseInt(arriveBob.substring(3));
		int bm2 = Integer.parseInt(leaveBob.substring(0, 2));
		int bd2 = Integer.parseInt(leaveBob.substring(3));
		int fromMonth = -1;
		int fromDay = -1;
		if (am1 < bm1 || (am1 == bm1 && ad1 < bd1)) {
			fromMonth = bm1;
			fromDay = bd1;
		} else {
			fromMonth = am1;
			fromDay = ad1;
		}
		int toMonth = -1;
		int toDay = -1;
		if (am2 < bm2 || (am2 == bm2 && ad2 < bd2)) {
			toMonth = am2;
			toDay = ad2;
		} else {
			toMonth = bm2;
			toDay = bd2;
		}
		if (toMonth < fromMonth || (toMonth == fromMonth && toDay < fromDay)) {
			return 0;
		}
		if (fromMonth == toMonth) {
			ans = toDay - fromDay + 1;
		} else {
			ans = days[fromMonth - 1] - fromDay + 1;
			fromMonth++;
			while (fromMonth < toMonth) {
				ans += days[fromMonth - 1];
				fromMonth++;
			}
			ans += toDay;
		}
		return ans;
	}
}
