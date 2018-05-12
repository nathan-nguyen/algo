import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();

		while (T-- > 0){
			int n = in.nextInt();
			int m = in.nextInt();

			String s1 = in.next();
			String s2 = in.next();

			int[][] dp = new int[n+1][m+1];
			for (int i = 0; i <= n; ++i) dp[i][0] = i;

			for (int i = 0; i <= m; ++i) dp[0][i] = i;

			for (int i = 1; i <= n; ++i){
				for (int j = 1; j <= m; ++j){
					dp[i][j] = Math.min(Math.min(1 + dp[i][j-1], 1 + dp[i-1][j]), (s1.charAt(i-1) == s2.charAt(j-1) ? 0 : 1) + dp[i-1][j-1]);
				}
			}
			System.out.println(dp[n][m]);
		}
	}
}
