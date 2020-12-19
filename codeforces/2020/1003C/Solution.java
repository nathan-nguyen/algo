import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int r = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; ++i) a[i] = in.nextInt();

		long[] ps = new long[n];
		ps[0] = a[0];
		for (int i = 1; i < n; ++i) ps[i] = ps[i - 1] + a[i];

		double max = 0;
		while (r <= n) {
			for (int j = 0; j + r <= n; ++j) {
				double sum = ps[j + r - 1] - (j == 0 ? 0 : ps[j-1]);
				max = Math.max(max, sum / r);
			}
			++r;
		}
		System.out.println(max);
	}
}
