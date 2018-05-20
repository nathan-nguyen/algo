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

		long[] a = new long[n];
		for (int i = 0; i < n; ++i) a[i] = in.nextLong();

		long[] l = new long[m];
		for (int i = 0; i < m; ++i) l[i] = in.nextLong();

		long[] sum = new long[n+1];
		sum[0] = 0;
		for (int i = 1; i <= n; ++i) sum[i] = a[i - 1] + sum[i - 1];

		for (int i = 0; i < m; ++i){
			int k = Arrays.binarySearch(sum, l[i]);
			if (k >= 0) System .out.println (k + " " + a[k - 1]);
			else {
				k = -k - 1;
				System.out.println(k + " " + (l[i] - sum[k - 1]));
			}
		}
	}
}
