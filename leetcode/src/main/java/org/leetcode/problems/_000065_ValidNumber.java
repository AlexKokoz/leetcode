package org.leetcode.problems;

/**
 * 
 * HARD
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000065_ValidNumber {

	final static int NSTATES = 13;
	final static int NSYMBOLS = 16; // 0..9 + - . e <end_of_number> other
	final static int FINAL_STATE = NSTATES - 1;
	final static int ZERO = 0;
	final static int ONE = 1;
	final static int TWO = 2;
	final static int THREE = 3;
	final static int FOUR = 4;
	final static int FIVE = 5;
	final static int SIX = 6;
	final static int SEVEN = 7;
	final static int EIGHT = 8;
	final static int NINE = 9;
	final static int PLUS = 10;
	final static int MINUS = 11;
	final static int DECIMAL = 12;
	final static int EXPONENT = 13;
	final static int EON = 14; // end of number
	final static int OTHER = 15; // any other symbol

	public boolean isNumber(String s) {
		s = s.trim();
		int[][] tr = buildTransitions();
		int state = 1;
		for (char c : s.toCharArray()) {
			int id = id(c);
			state = tr[state][id];
		}
		state = tr[state][EON];
		return state == tr.length - 1;
	}

	static int id(char c) {
		switch (c) {
		case '0':
			return ZERO;
		case '1':
			return ONE;
		case '2':
			return TWO;
		case '3':
			return THREE;
		case '4':
			return FOUR;
		case '5':
			return FIVE;
		case '6':
			return SIX;
		case '7':
			return SEVEN;
		case '8':
			return EIGHT;
		case '9':
			return NINE;
		case '+':
			return PLUS;
		case '-':
			return MINUS;
		case '.':
			return DECIMAL;
		case 'e':
			return EXPONENT;
		default:
			return OTHER;
		}
	}

	static int[][] buildTransitions() {
		int[][] tr = new int[NSTATES][NSYMBOLS];

		set(tr, 1, PLUS, 2);
		set(tr, 1, MINUS, 4);
		set(tr, 1, ZERO, NINE, 3);
		set(tr, 1, DECIMAL, 5);

		set(tr, 2, ZERO, NINE, 3);
		set(tr, 2, DECIMAL, 5);

		set(tr, 3, ZERO, NINE, 3);
		set(tr, 3, DECIMAL, 7);
		set(tr, 3, EXPONENT, 6);
		set(tr, 3, EON, FINAL_STATE);

		set(tr, 4, ZERO, NINE, 3);
		set(tr, 4, DECIMAL, 5);

		set(tr, 5, ZERO, NINE, 10);

		set(tr, 6, MINUS, 8);
		set(tr, 6, ZERO, NINE, 9);
		set(tr, 6, PLUS, 11);

		set(tr, 7, EXPONENT, 6);
		set(tr, 7, ZERO, NINE, 10);
		set(tr, 7, EON, FINAL_STATE);

		set(tr, 8, ZERO, NINE, 9);

		set(tr, 9, ZERO, NINE, 9);
		set(tr, 9, EON, FINAL_STATE);

		set(tr, 10, EXPONENT, 6);
		set(tr, 10, ZERO, NINE, 10);
		set(tr, 10, EON, FINAL_STATE);

		set(tr, 11, ZERO, NINE, 9);

		return tr;
	}

	static void set(int[][] mat, int r, int c, int val) {
		mat[r][c] = val;
	}

	static void set(int[][] mat, int r, int fromC, int toC, int val) {
		set(mat, r, r, fromC, toC, val);
	}

	static void set(int[][] mat, int fromR, int toR, int fromC, int toC, int val) {
		for (int ir = fromR; ir <= toR; ir++)
			for (int ic = fromC; ic <= toC; ic++)
				mat[ir][ic] = val;
	}
}
