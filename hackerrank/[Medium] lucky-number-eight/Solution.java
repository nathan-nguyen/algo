import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private static final int MOD = 1000000007;
	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();

		int[] dp = new int[8];

		for (int i = 0; i < s.length(); ++i){
			int[] newdp = new int[8];
			for (int j = 0; j < 8; ++j){
				int index = (j * 10 + s.charAt(i) - '0') % 8;
				newdp[index] = (newdp[index] + dp[j]) % MOD;
			}
			++dp[(s.charAt(i) - '0') % 8];
			for (int j = 0; j < 8; ++j) dp[j] = (dp[j] + newdp[j]) % MOD;
		}
		System.out.println(dp[0]);
	}
}
