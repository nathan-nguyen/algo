import java.util.HashSet;
import java.util.HashMap;

class Solution {
	public void solveSudoku(char[][] board) {
		boolean[][] row = new boolean[9][10];
		boolean[][] col = new boolean[9][10];
		boolean[][][] gr = new boolean[3][3][10];
		
		for (int i = 0; i < 9; ++i){
			for (int j = 0; j < 9; ++j){
				if (board[i][j] != '.') {
                                        int val = board[i][j] - '0';
                                        row[i][val] = col[j][val] = gr[i/3][j/3][val] = true;
                                }
			}
		}
	
		solve(0, board, row, col, gr);	
	}

	private boolean solve(int start, char[][] board, boolean[][] row, boolean[][] col, boolean[][][] gr){
		if (start == 81) return true;

		for (int i = start; i < 81; ++i){
			int x = i / 9;
			int y = i % 9;
			if (board[x][y] != '.') continue;

			for (int k = 1; k <= 9; ++k){
				if (row[x][k] || col[y][k] || gr[x/3][y/3][k]) continue;

				board[x][y] = (char)('0' + k);
				
				row[x][k] = col[y][k] = gr[x/3][y/3][k] = true;
                                
				if (solve(i + 1, board, row, col, gr)) return true;
                                
				row[x][k] = col[y][k] = gr[x/3][y/3][k] = false;
                                
				board[x][y] = '.';
			}
			return false;
		}
		return true;
	}

}

