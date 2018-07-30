import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();

		int[] left = new int[n];
		int[] right = new int [n];

		left[0] = 1;
		for (int i = 1; i < n; ++i) {
			if (s.charAt(i) == s.charAt(i - 1)) left[i] = left[i - 1] + 1;
			else left[i] = 1;
		}
		right[n - 1] = 1;
		for (int i = n - 2; i >= 0; --i) {
			if (s.charAt(i) == s.charAt(i + 1)) right[i] = right[i + 1] + 1;
			else right[i] = 1;
		}

		long total = n;
		for (int i = 1; i < n - 1; ++i) {
			if (s.charAt(i - 1) != s.charAt(i + 1)) continue;
			total += Math.min(left[i-1], right[i+1]);
		}
		for (int i = 0; i < n - 1; ++i) {
			if (s.charAt(i) != s.charAt(i + 1)) continue;
			total += Math.min(left[i], right[i + 1]);
		}
		System.out.println(total);
	}
}
