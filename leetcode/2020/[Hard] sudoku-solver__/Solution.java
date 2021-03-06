import java.util.HashSet;
import java.util.HashMap;

class Solution {
	public void solveSudoku(char[][] board) {
		boolean[][] r = new boolean[9][10];
		boolean[][] c = new boolean[9][10];
		boolean[][][] gr = new boolean[3][3][10];
		
		for (int i = 0; i < 9; ++i){
			for (int j = 0; j < 9; ++j){
				if (board[i][j] != '.') remove(i, j, r, c, gr, board[i][j] - '0');
			}
		}
	
		solve(0, board, r, c, gr);	
	}

	private boolean solve(int start, char[][] board, boolean[][] r, boolean[][] c, boolean[][][] gr){
		if (start == 81) return true;

		for (int i = start; i < 81; ++i){
			int x = i / 9;
			int y = i % 9;
			if (board[x][y] != '.') continue;

			for (int k = 1; k <= 9; ++k){
				if (isRemoved(x, y, r, c, gr, k)) continue;

				board[x][y] = (char)('0' + k);
				
				remove(x, y, r, c, gr, k);
				if (solve(i + 1, board, r, c, gr)) return true;
				add(x, y, r, c, gr, k);
				board[x][y] = '.';
			}
			return false;
		}
		return true;
	}

	private void add(int x, int y, boolean[][] row, boolean[][] col, boolean[][][] gr, int val){
		row[x][val] = col[y][val] = gr[x/3][y/3][val] = false;
	}

	private void remove(int x, int y, boolean[][] row, boolean[][] col, boolean[][][] gr, int val){
		row[x][val] = col[y][val] = gr[x/3][y/3][val] = true;
        }

	private boolean isRemoved(int x, int y, boolean[][] row, boolean[][] col, boolean[][][] gr, int val){
		return row[x][val] || col[y][val] || gr[x/3][y/3][val];
	}

}
