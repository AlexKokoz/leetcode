package org.leetcode.problems;
import java.util.*;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000967_NumbersWithSameConsecutiveDifferences {
	public int[] numsSameConsecDiff(int N, int K) {
	        List<Integer> results = new ArrayList<>();
	        for(int i = (N > 1 ? 1 : 0); i < 10; i++) {
	            dfs((new StringBuilder(N)).append(i), i, N, K, results);
	        }
	        return results.stream().parallel().mapToInt(i->i).toArray();
	    }
	    
	    void dfs(StringBuilder sb, int last, int n, int k, List<Integer> results) {
	        // System.out.println(sb.toString() + " " + last);
	        if(sb.length() == n) {
	            results.add(Integer.parseInt(sb.toString()));
	            return;
	        }
	        int prev = last - k;
	        if(prev >= 0) {
	            dfs(sb.append(prev), prev, n, k, results);
	            sb.deleteCharAt(sb.length() - 1);
	        }
	        
	        if(k > 0) {
	            int next = last + k;
	            if(next < 10) {
	                dfs(sb.append(next), next, n, k, results);
	                sb.deleteCharAt(sb.length() - 1);
	            }
	        }
	    }
}
