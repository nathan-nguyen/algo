class Solution {
	public void gameOfLife(int[][] board) {
		int n = board.length;
		int m = board[0].length;

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				int val = checkPos(i, j, n, m, board);

				if (board[i][j] > 0) board[i][j] = Math.max(val, 1);
				else board[i][j] = -val;
			}
		}

		for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (board[i][j] == 2 || board[i][j] == 3 || board[i][j] == -3) board[i][j] = 1;
				else board[i][j] = 0;
			}
		}
	}

	private int checkPos(int i, int j, int n, int m, int[][] board){
		int count = 0;
		// -1 -1 | -1 0 | -1 + 1 | 0 +1 | +1 +1 | +1 0 | +1 -1 | 0 -1
		if (i - 1 >= 0 && j - 1 >= 0 && board[i-1][j-1] > 0) ++count;
		if (i - 1 >= 0               && board[i-1][j]   > 0) ++count;
		if (i - 1 >= 0 && j + 1 <  m && board[i-1][j+1] > 0) ++count;
		if (              j + 1 <  m && board[i][j+1]   > 0) ++count;
		if (i + 1 <  n && j + 1 <  m && board[i+1][j+1] > 0) ++count;
		if (i + 1 <  n               && board[i+1][j]   > 0) ++count;
		if (i + 1 <  n && j - 1 >= 0 && board[i+1][j-1] > 0) ++count;
		if (              j - 1 >= 0 && board[i][j-1]   > 0) ++count;

		return count;
	}
}
