import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solve());
	}

	private double solve() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt() * 2;
		int m = in.nextInt();

		int[] a = new int[n];
		double ans = m;
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
			if (a[i] == 1) return -1;
			ans *= (double) a[i] / (a[i] - 1);
		}
		return ans - m;
	}
}
