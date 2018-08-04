import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] dp = new int[n + 2];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= n; ++i) dp[i] = dp[i-1] + dp[i-2];

		System.out.println(dp[n]);
	}
}
