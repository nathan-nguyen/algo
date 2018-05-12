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
			int N = in.nextInt();
			int[] point = new int[100];
			int[] dp = new int[100];

			for (int i = 0; i < 100; ++i) point[i] = -1;

			while (N-- > 0) {
				int f = in.nextInt() - 1;
				int s = in.nextInt() - 1;
				point[f] = s;
			}

			int M = in.nextInt();

			while (M-- > 0){
				int f = in.nextInt() - 1;
				int s = in.nextInt() - 1;
				point[f] = s;
			}

			for (int i = 1; i < 100; ++i) dp[i] = 100;

			for (int i = 1; i < 100; ++i){
				for (int j = 1; j <= 6; ++j){
					if (i < j) break;
					if (point[i-j] != -1) continue;

					dp[i] = Math.min(dp[i], dp[i - j] + 1);
				}
				if (point[i] != -1){
					if (dp[point[i]] > dp[i] && point[i] < i) {
						dp[point[i]] = dp[i];
						i = point[i];
					}
					else dp[point[i]] = Math.min(dp[point[i]], dp[i]);
				}
			}
			System.out.println(dp[99] > 17 ? -1 : dp[99]);
		}
	}
} 
