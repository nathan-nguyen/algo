import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private long solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

		if (n == 1) return 1;

		int[] dp = new int[n];
		boolean inc = false;
	
		dp[0] = 1;	
		for (int i = 1; i < n - 1; ++i) {
			dp[i] = 1;
			if (arr[i] > arr[i - 1]) dp[i] = dp[i-1] + 1;
			// arr[i] <= arr[i - 1]
			else if (arr[i] <= arr[i + 1]) {
				for (int j = i; j >= 1 && arr[j - 1] > arr[j]; --j) {
					dp[j - 1] = Math.max(dp[j - 1], dp[j] + 1);
				}
			}
		}

		if (arr[n - 1] <= arr[n - 2]) {
			dp[n - 1] = 1;
			for (int j = n - 1; j >= 1 && arr[j - 1] > arr[j]; --j) {
				dp[j - 1] = Math.max(dp[j - 1], dp[j] + 1); 
			}
		}
		else dp[n - 1] = dp[n - 2] + 1;

		long total = 0;
		for (int i = 0; i < n; ++i) total += dp[i];
		return total;
	}
}
