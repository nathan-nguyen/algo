import java.util.Scanner;

public class Solution {
	private static final int MAX = 100001;
	private static final int MOD = 1000000007;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int t = in.nextInt();
		int k = in.nextInt();

		int[] dp = new int[MAX];
		dp[0] = 1;

		for (int i = 1; i < MAX; ++i){
			dp[i] = dp[i-1];
			if (i >= k) dp[i] = (dp[i] + dp[i-k]) % MOD;
		}

		int[] total = new int[MAX];

		for (int i = 1; i < MAX; ++i) total[i] = (total[i-1] + dp[i]) % MOD;

		while (t-- > 0){
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println((total[b] + MOD - total[a-1]) % MOD);
		}
	}
}
