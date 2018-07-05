import java.util.Scanner;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();

		int[] c = new int[m];
		for (int i = 0; i < m; ++i) c[i] = in.nextInt();

		Arrays.sort(c);
		long[] dp = new long[n+1];
		dp[0] = 1;
	
		for (int i = 0; i < m; ++i){
			for (int j = c[i]; j <= n; ++j) dp[j] += dp[j - c[i]];
		}

		System.out.println(dp[n]);
	}
}
