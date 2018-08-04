import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private int solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] arr = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

		dp[0] = Math.max(0, arr[0]);
		if (n == 1) return dp[0];

		dp[1] = Math.max(0, arr[1]);
		if (n == 2) return Math.max(dp[1], dp[0]);

		dp[2] = dp[0] + Math.max(0, arr[2]);
		for (int i = 3; i < n; ++i){
			dp[i] = Math.max(dp[i - 2], dp[i - 3]) + Math.max(0, arr[i]);
		}
		return Math.max(dp[n - 1], dp[n - 2]);
	}
}
