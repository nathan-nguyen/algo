import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private int MOD = 1000000007;

	private void solve(){
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();
		int k = in.nextInt();

		int[] dp = new int[100001];
		int[] sum = new int[100001];

		dp[0] = 1;
		for (int i = 1; i < 100001; ++i){
			dp[i] = (dp[i-1] + ((i >= k) ? dp[i-k] : 0)) % MOD;
			sum[i] = (sum[i-1] + dp[i])  % MOD;
		}

		while (t -- > 0){
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println((sum[b] + MOD - sum[a-1]) % MOD);
		}
	}
}
