import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}


	private long[] egcd(long a, long p){
		if (a == 0) return new long[]{p, 0, 1};
		else {
			long[] result = egcd(p % a, a);
			return new long[]{result[0], result[2] - (p / a) * result[1], result[1]};
		}
	}

	private long modInv(long a, long p){
		long[] result = egcd(a, p);
		if (result[0] != 1) while(true);
		return ((result[1] % p)+ p) % p;
	}

	private static final int MOD = 1000000007;
	private long[] F;

	private void calculateFactorial(){
		F = new long[1000001];
		F[0] = 1;
		for (int i = 1; i <= 1000000; ++i) F[i] = (F[i-1] * i) % MOD;
	}

	private long C(int k, int n){
		long div = (F[k] * F[n-k]) % MOD;
		return (F[n] * modInv(div, MOD)) % MOD;
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		calculateFactorial();
		int k = in.nextInt();
		int n = in.nextInt();
		System.out.println(C(k,n));
	}
}
