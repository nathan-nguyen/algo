import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int[] c = new int[n];
		String[] data = new String[n];
		String[] reverse = new String[n];

		long[][] dp = new long[n][2];

		for (int i = 0; i < n; ++i) c[i] = in.nextInt();
		for (int i = 0; i < n; ++i) {
			data[i] = in.next();
			reverse[i] = new StringBuilder(data[i]).reverse().toString();
		}

		dp[0][0] = 0;
		dp[0][1] = c[0];

		for (int i = 1; i < n; ++i){
			boolean c1 = data[i].compareTo(data[i-1]) >= 0 && dp[i-1][0] != -1;
			boolean c2 = data[i].compareTo(reverse[i-1]) >= 0 && dp[i-1][1] != -1;
			if (c1 && c2) dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]);
			else if (c1) dp[i][0] = dp[i-1][0];
			else if (c2) dp[i][0] = dp[i-1][1];
			else dp[i][0] = -1;

			boolean c3 = reverse[i].compareTo(data[i-1]) >= 0 && dp[i-1][0] != -1;
			boolean c4 = reverse[i].compareTo(reverse[i-1]) >= 0 && dp[i-1][1] != -1;
			if (c3 && c4) dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + c[i];
			else if (c3) dp[i][1] = dp[i-1][0] + c[i];
                        else if (c4) dp[i][1] = dp[i-1][1] + c[i];
                        else dp[i][1] = -1;

			if (dp[i][0] == -1 && dp[i][1] == -1) {
				System.out.println(-1);
				return;
			}
		}
		if (dp[n-1][0] == -1) System.out.println(dp[n-1][1]);
		else if (dp[n-1][1] == -1) System.out.println(dp[n-1][0]);
		else System.out.println(Math.min(dp[n-1][0], dp[n-1][1])); 
	}
}
