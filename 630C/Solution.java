import java.util.Scanner;

public class Solution{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		long[] dp = new long[56];

		dp[1] = 2;
		for (int i = 2; i <= n; ++i) dp[i] = dp[i-1] * 2;

		long result = 0;
		for (int i = 1; i <= n; ++i) result += dp[i];

		System.out.println(result);
	}
}
