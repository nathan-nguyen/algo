import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		String s1 = in.next();
		String s2 = in.next();

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); ++i){
			for (int j = 1; j <= s2.length(); ++j){
				dp[i][j] = dp[i-1][j-1] + (s1.charAt(i-1) == s2.charAt(j-1) ? 1 : 0);
				dp[i][j] = Math.max(Math.max(dp[i][j], dp[i-1][j]), dp[i][j-1]);
			}
		}
		System.out.println(dp[s1.length()][s2.length()]);
	}
}
