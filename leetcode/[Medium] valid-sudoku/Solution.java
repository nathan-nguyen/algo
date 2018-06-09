class Solution {
	public boolean isValidSudoku(char[][] board) {
		boolean[][] r = new boolean[9][10];
		boolean[][] c = new boolean[9][10];
		boolean[][][] gr = new boolean[3][3][10];
		
		for (int i = 0; i < 9; ++i){
			for (int j = 0; j < 9; ++j){
				if (board[i][j] == '.') continue;
				int ch = board[i][j] - '0';
				if (r[i][ch] || c[j][ch] || gr[i/3][j/3][ch]) return false;
				r[i][ch] = true;
				c[j][ch] = true;
				gr[i/3][j/3][ch] = true;
			}
		}
		return true;
	}
}
