import java.util.HashSet;
import java.util.HashMap;

class Solution {
	public void solveSudoku(char[][] board) {
		boolean[][] r = new boolean[9][10];
		boolean[][] c = new boolean[9][10];
		boolean[][][] gr = new boolean[3][3][10];
		boolean[][][] map = new boolean[9][9][10];
		
		for (int i = 0; i < 9; ++i){
			for (int j = 0; j < 9; ++j){
				if (board[i][j] != '.') remove(i, j, r, c, gr, map, board[i][j] - '0');
			}
		}
	
		solve(0, board, r, c, gr, map);	
	}

	private boolean solve(int start, char[][] board, boolean[][] r, boolean[][] c, boolean[][][] gr, boolean[][][] map){
		if (start == 81) return true;

		for (int i = start; i < 81; ++i){
			int x = i / 9;
			int y = i % 9;
			if (board[x][y] != '.') continue;

			for (int k = 1; k <= 9; ++k){
				if (isRemoved(x, y, r, c, gr, map, k)) continue;

				board[x][y] = (char)('0' + k);
				
				remove(x, y, r, c, gr, map, k);
				if (solve(i + 1, board, r, c, gr, map)) return true;
				add(x, y, r, c, gr, map, k);
				board[x][y] = '.';
			}
			return false;
		}
		return true;
	}

	private void add(int x, int y, boolean[][] row, boolean[][] col, boolean[][][] gr, boolean[][][] map, int val){
		row[x][val] = false;
		col[y][val] = false;
		gr[x/3][y/3][val] = false;
		map[x][y][val] = false;
	}

	private void remove(int x, int y, boolean[][] row, boolean[][] col, boolean[][][] gr, boolean[][][] map, int val){
		row[x][val] = true;
                col[y][val] = true;
                gr[x/3][y/3][val] = true;
                map[x][y][val] = true;
        }

	private boolean isRemoved(int x, int y, boolean[][] row, boolean[][] col, boolean[][][] gr, boolean[][][] map, int val){
		return row[x][val] || col[y][val] || gr[x/3][y/3][val] || map[x][y][val];
	}

}
