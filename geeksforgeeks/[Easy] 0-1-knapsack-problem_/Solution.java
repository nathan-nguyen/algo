import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		Solution solution = new Solution();
		while (t-- > 0) {
			int n = in.nextInt();
			int m = in.nextInt();

			int[] v = new int[n];
			int[] w = new int[n];

			for (int i = 0; i < n; ++i) v[i] = in.nextInt();
			for (int i = 0; i < n; ++i) w[i] = in.nextInt();

			System.out.println(solution.solve(n, w, v, m));
		}
	}

	private int solve(int n, int[] w, int[] v, int m) {
		int[][] dp = new int[n][m + 1];

		if (w[0] <= m) dp[0][w[0]] = v[0];

		for (int i = 1; i < n; ++i) {
			for (int j = 0; j <= m; ++j) {
				dp[i][j] = dp[i-1][j];
				if (j >= w[i]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j - w[i]] + v[i]);
			}
		}

		int max = 0;
		for (int i = 0; i <= m; ++i) max = Math.max(max, dp[n-1][i]);
		return max;
	}
}
