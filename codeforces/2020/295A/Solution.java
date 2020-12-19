import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve(){
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int k = in.nextInt();

		int[] a = new int[n];
		long[][] o = new long[m][3];

		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		for (int i = 0; i < m; ++i){
			o[i][0] = in.nextInt() - 1;
			o[i][1] = in.nextInt() - 1;
			o[i][2] = in.nextInt();
		}

		long[] freq = new long[Math.max(n, m)];
		for (int i = 0; i < k; ++i){
			int l = in.nextInt() - 1;
			int r = in.nextInt() - 1;
			++freq[l];
			if (r + 1 < m) --freq[r+1];
		}

		long total = 0;
		for (int i = 0; i < m; ++i){
			total += freq[i];
			o[i][2] *= total;
		}

		// Reset freq
		for (int i = 0; i < n; ++i) freq[i] = 0;

		for (int i = 0; i < m; ++i){
			freq[(int)o[i][0]] += o[i][2];
			if ((int)o[i][1] + 1 < n) freq[(int)o[i][1] + 1] -= o[i][2];
		}

		// Recycle total
		total = 0;
		for (int i = 0; i < n; ++i){
			total += freq[i];
			System.out.print((total + a[i]) + " ");
		}
		System.out.println();
	}
}
