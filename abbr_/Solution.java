import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		while (q -- > 0){
			String a = in.next();
			String b = in.next();

			boolean dp[][] = new boolean[a.length()][b.length()];

			dp[0][0] = a.charAt(0) == b.charAt(0) || a.charAt(0) - 'a' + 'A' == b.charAt(0);
			boolean flag = a.charAt(0) < 'a';
			for (int i = 1; i < a.length(); ++i) {
				if (a.charAt(i) < 'a'){
					if (flag) break;
					dp[i][0] = a.charAt(i) == b.charAt(0);
					if (!dp[i][0]) break;
					flag = true;
				}
				else dp[i][0] = (a.charAt(i) == b.charAt(0) - 'A' + 'a') || dp[i-1][0];
			}
			for (int i = 1; i < b.length(); ++i) dp[0][i] = false;

			for (int i = 1; i < a.length(); ++i){
				for (int j = 1; j < b.length(); ++j){
					if (a.charAt(i) < 'a') dp[i][j] = (a.charAt(i) == b.charAt(j)) && dp[i-1][j-1];
					else dp[i][j] = (a.charAt(i) - 'a' + 'A' == b.charAt(j) && dp[i-1][j-1]) || dp[i-1][j];
				}
			}
			
			System.out.println(dp[a.length() - 1][b.length() - 1] ? "YES" : "NO");
		}
	}
}
