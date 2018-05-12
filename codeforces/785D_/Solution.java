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
		if (k > n) return 0;

		long div = (F[k] * F[n-k]) % MOD;
		return (F[n] * modInv(div, MOD)) % MOD;
	}

	private void solve(){
		Scanner in = new Scanner(System.in);
		calculateFactorial();
		String s = in.nextLine();
		
		int[] left = new int[s.length()];
		int[] right = new int[s.length()];
		
		left[0] = s.charAt(0) == '(' ? 1 : 0;
		for (int i = 1 ; i < s.length(); ++i) {
			if (s.charAt(i) == '(') left[i] = left[i-1] + 1;
			else left[i] = left[i-1];
		}

		right[s.length() - 1] = s.charAt(s.length() - 1) == ')' ? 1 : 0;
		for (int i = s.length() - 2; i >= 0; --i){
			if (s.charAt(i) == ')') right[i] = right[i+1] + 1;
			else right[i] = right[i+1];
		}

		long result = 0;
		for (int i = 0; i < s.length(); ++i){
			if (s.charAt(i) == '(') result = (result + C(left[i], left[i] + right[i] - 1)) % MOD;
		}
		System.out.println(result);
	}
}
