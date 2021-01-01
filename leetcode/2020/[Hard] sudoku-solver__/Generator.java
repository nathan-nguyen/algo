public class Generator {
	public static void main(String[] args){
		Solution solution = new Solution();
		char[][] board = new char[9][9];


		firstCase(board);
//		secondCase(board);
		solution.solveSudoku(board);

		for (int i = 0; i < 9; ++i){
			if (i % 3 == 0) System.out.println();
			for (int j = 0; j < 9; ++j) {
				if (j % 3 == 0) System.out.print(" ");
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void secondCase(char[][] board){
		String[] s = new String[9];
		s[0] = "53..7....";
		s[1] = "6..195...";
		s[2] = ".90....6.";
		s[3] = "8...6...3";
		s[4] = "4..8.3..1";
		s[5] = "7...2...6";
		s[6] = ".6....28.";
		s[7] = "...419..5";
		s[8] = "....8..79";

		for (int i = 0; i < 9; ++i) board[i] = s[i].toCharArray();
	}

	private static void firstCase(char[][] board){
		for (int i = 0; i < 9; ++i){
                        for (int j = 0; j < 9; ++j) board[i][j] = '.';
                }
	}
}
