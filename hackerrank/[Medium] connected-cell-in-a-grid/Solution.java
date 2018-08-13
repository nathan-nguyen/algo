import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private int n;
	private int m;
	private int[][] graph;
	private boolean[][] visited;

	private void solve() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();

		graph = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) graph[i][j] = in.nextInt();
		}

		int max = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) max = Math.max(max, dfs(i, j));
		}
		System.out.println(max);
	}

	private int dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || graph[i][j] == 0) return 0;

		visited[i][j] = true;
		return 1
			+ dfs(i - 1, j - 1) + dfs(i - 1, j) + dfs(i - 1, j + 1)
			+ dfs(i, j - 1) + dfs(i, j + 1)
			+ dfs(i + 1, j - 1) + dfs(i + 1, j) + dfs(i + 1, j + 1);
	}
}
