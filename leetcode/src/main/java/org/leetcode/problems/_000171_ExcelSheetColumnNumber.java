package org.leetcode.problems;

/**
 * 
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000171_ExcelSheetColumnNumber {
	public int titleToNumber(String s){
	        int n = s.length();
	        int ans = 0;
	        for (int i = 0; i < n; i++) {
	            int c = s.charAt(i) - 'A' + 1;
	            ans = ans * 26  + c;
	        }
	        return ans;
	    }
}
