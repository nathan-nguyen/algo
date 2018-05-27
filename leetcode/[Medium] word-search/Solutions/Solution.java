class Solution {
	public boolean exist(char[][] b, String word) {
		if (word.length() == 0 || b.length == 0 || b[0].length == 0) return false;

		int n = b.length;
		int m = b[0].length;

        	for (int i = 0; i < n; ++i){
			for (int j = 0; j < m; ++j){
				if (b[i][j] == word.charAt(0)){
					if (search(b, i, j, word, 0, new boolean[n][m], n, m)) return true;
				}
			}
		}
		return false;
	}

	private boolean search(char[][] b, int i, int j, String word, int index, boolean[][] visited, int n, int m){
		if (index == word.length()) return true;

		if (i < 0 || i >= n || j < 0 || j >= m) return false;

		if (visited[i][j]) return false;

		if (b[i][j] != word.charAt(index)) return false;

		visited[i][j] = true;
		if (search(b, i - 1, j, word, index + 1, visited, n, m)) return true;
		if (search(b, i + 1, j, word, index + 1, visited, n, m)) return true;
		if (search(b, i, j - 1, word, index + 1, visited, n, m)) return true;
		if (search(b, i, j + 1, word, index + 1, visited, n, m)) return true;
		visited[i][j] = false;
		return false;
	}
}
