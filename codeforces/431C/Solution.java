import java.util.Scanner;

public class Solution {
	public static int MOD = 1000000007;

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int d = in.nextInt();

		int[] cd = new int[n+1];
		int[] ncd = new int[n+1];

		cd[0] = 1;
		ncd[0] = 1;

		for (int i = 1; i <= n; ++i){
			for (int j = 1; j <= k; ++j){
				if (i - j < 0) break;
				cd[i] = (cd[i] + cd[i-j]) % MOD;
				if (j < d) ncd[i] = (ncd[i] + ncd[i-j]) % MOD;
			}
		}
		System.out.println(( cd[n] + MOD - ncd[n]) % MOD);
	}
}
