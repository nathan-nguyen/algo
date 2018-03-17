import java.util.Scanner;

public class Solution {

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		String[][] data = new String[n][2];
		String[][] order = new String[n][2];

		for (int i = 0; i < n; ++i) {
			data[i][0] = in.next();
			data[i][1] = in.next();
		}

		for (int i = 0; i < n; ++i){
			int orderIndex = in.nextInt() - 1;
			order[i] = data[orderIndex];
		}

		boolean[][] dp = new boolean[n][2];
		dp[0][0] = true;
		dp[0][1] = true;

		for (int i = 1; i < n; ++i){
			if (order[i][0].compareTo(order[i-1][0]) >= 0 && dp[i-1][0]) dp[i][0] = true;
			else if (order[i][0].compareTo(order[i-1][1]) >= 0 && dp[i-1][1]) dp[i][0] = true;

			if (order[i][1].compareTo(order[i-1][0]) >= 0 && dp[i-1][0]) dp[i][1] = true;
			else if (order[i][1].compareTo(order[i-1][1]) >= 0 && dp[i-1][1]) dp[i][1] = true;

			if (!dp[i][0] && !dp[i][1]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
