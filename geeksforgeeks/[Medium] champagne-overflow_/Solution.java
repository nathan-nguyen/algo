import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solve();
	}

	private void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();

		while (t -- > 0) {
			int k = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();

			double[] up = new double[x];
			double[] down = new double[x];

			up[0] = k;
			for (int i = 1; i < x; ++i) {
				for (int j = 0; j <= i; ++j) {
					down[j] = ((j < i) ? Math.max(0, (up[j] - 1) / 2) : 0) + ((j > 0) ? Math.max(0, (up[j - 1] - 1) / 2) : 0);
				}
				double[] dp = up;	up = down;	down = dp;
			}
			System.out.println(Math.min(1, up[y-1]));
		}
	}
}
