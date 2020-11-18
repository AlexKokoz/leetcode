package org.leetcode.contests.biweekly.bw0036;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001603_DesignParkingSystem {
	class ParkingSystem {
		int[] slots;

		public ParkingSystem(int big, int medium, int small) {
			slots = new int[] { 0, big, medium, small };
		}

		public boolean addCar(int carType) {
			if (slots[carType] == 0)
				return false;
			slots[carType]--;
			return true;
		}
	}
}
