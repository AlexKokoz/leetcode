package org.leetcode.contests.weekly.w0165;

/**
 * EASY
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _001275_FindWinnerOnATicTacToeGame {

	public String tictactoe(int[][] moves) {
		int flag = 1; // A == 1, B == 2
		final int[][] tab = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
        	final int[] move = moves[i];
        	tab[move[0]][move[1]] = flag;
        	flag = flag == 1 ? 2: 1;
        	if (check(tab)) {
        		return (i % 2 == 0 ? "A" : "B");
        	}
        }
        if (moves.length == 9) return "Draw";
        return "Pending";
        
    }
	
	static boolean check(int[][] tab) {
		if ((tab[0][0] != 0 && tab[0][0] == tab[0][1] && tab[0][1] == tab[0][2]) ||
		    (tab[1][0] != 0 && tab[1][0] == tab[1][1] && tab[1][1] == tab[1][2]) ||
		    (tab[2][0] != 0 && tab[2][0] == tab[2][1] && tab[2][1] == tab[2][2]) ||
		    (tab[0][0] != 0 && tab[0][0] == tab[1][0] && tab[1][0] == tab[2][0]) ||
		    (tab[0][1] != 0 && tab[0][1] == tab[1][1] && tab[1][1] == tab[2][1]) ||
		    (tab[0][2] != 0 && tab[0][2] == tab[1][2] && tab[1][2] == tab[2][2]) ||
		    (tab[0][0] != 0 && tab[0][0] == tab[1][1] && tab[1][1] == tab[2][2]) ||
		    (tab[0][2] != 0 && tab[0][2] == tab[1][1] && tab[1][1] == tab[2][0]) )
			return true;
        return false;
	}
}
