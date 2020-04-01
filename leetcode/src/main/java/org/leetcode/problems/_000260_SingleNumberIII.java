package org.leetcode.problems;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000260_SingleNumberIII {
	public int[] singleNumber(int[] nums) {
        int mask = 0;
        for (int num : nums)
            mask ^= num;
        int i;
        for (i = 0;i < 32; i++)
            if (mask << ~i < 0)
                break;
        int num1 = 0;
        int num2 = 0;
        for (int num : nums){
            if (num << ~i < 0)
                num1 ^= num;
            else
                num2 ^= num;
        }
        return new int[]{num1, num2};
    }
}
