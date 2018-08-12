import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t -- > 0) {
			int n = in.nextInt();
			int w = in.nextInt();

			int[] wei = new int[n];
			int[] val = new int[n];

			for (int i = 0; i < n; ++i) val[i] = in.nextInt();
			for (int i = 0; i < n; ++i) wei[i] = in.nextInt();

			int[][] dp = new int[n][w + 1];
			if (wei[0] < w) dp[0][wei[0]] = val[0];

			for (int i = 1; i < n; ++i) {
				for (int j = 1; j <= w; ++j) {
					dp[i][j] = dp[i-1][j];
					if (j >= wei[i]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j - wei[i]] + val[i]);
				}
			}

			int max = 0;
			for (int i = 0; i <= w; ++i) max = Math.max(max, dp[n-1][i]);

			System.out.println(max);
		}
	}
}
