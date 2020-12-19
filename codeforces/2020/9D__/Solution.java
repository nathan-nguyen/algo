import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int h = in.nextInt();

		long[][] dp = new long[n+1][n+1];
		dp[0][0] = 1;

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				for (int k = 0; k < i; ++k) {
					for (int l = 0; l < j; ++l) {
						dp[i][j] += dp[k][j-1] * dp[i - 1 - k][l] + dp[i - 1 - k][j - 1] * dp[k][l];
					}
					dp[i][j] -= dp[k][j-1] * dp[i - 1 - k][j - 1];
				}
			}
		}

		long total = 0;
		for (int i = h; i <= n; ++i) total += dp[n][i];
		System.out.println(total);
	}
}
