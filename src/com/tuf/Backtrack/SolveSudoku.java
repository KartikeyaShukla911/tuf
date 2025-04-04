package com.tuf.Backtrack;

public class SolveSudoku {
	
	public static boolean solveSudoku(char[][] board) {
	    for (int i = 0; i < 9; i++) {
	      for (int j = 0; j < 9; j++) {
	        if (board[i][j] == '.') {

	          for (char c = '1'; c <= '9'; c++) {
	            if (isValid(board, i, j, c)) {
	              board[i][j] = c;

	              if (solveSudoku(board))
	                return true;
	              else
	                board[i][j] = '.';
	            }
	          }

	          return false;
	        }
	      }
	    }
	    return true;
	  }

	  public static boolean isValid(char[][] board, int row, int col, char c) {
	    for (int i = 0; i < 9; i++) {
	      if (board[i][col] == c)
	        return false;

	      if (board[row][i] == c)
	        return false;

	      if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
	        return false;
	    }
	    return true;
	  }
	  
	  /*
	   * Time Complexity: O(9(n ^ 2)), in the worst case, for each cell in the n2 board, we have 9 possible numbers.

Space Complexity: O(1), since we are refilling the given board itself, there is no extra space required, so constant space complexity.
	   */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
