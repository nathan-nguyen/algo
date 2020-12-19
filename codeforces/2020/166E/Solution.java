import java.util.Scanner;

public class Solution {
	private static int MOD = 1000000007;
	private static int A = 0, B = 1, C = 2, D = 3;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		long[] dp = new long[4];
		// A - 0; B - 1; C - 2; D - 3
		// 1s
		dp[A] = 1;
		dp[B] = 1;
		dp[C] = 1;
		dp[D] = 0;

		for (int i = 2; i <= n; ++i){
			long[] newDp = new long[4];
			long total = dp[A] + dp[B] + dp[C] + dp[D];
			newDp[A] = (total - dp[A]) % MOD;
			newDp[B] = (total - dp[B]) % MOD;
			newDp[C] = (total - dp[C]) % MOD;
			newDp[D] = (total - dp[D]) % MOD;
			dp = newDp;
		}
		System.out.println(dp[D]);
	}
}
