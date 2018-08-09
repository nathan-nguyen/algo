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
			int n = in.nextInt();
			System.out.println(solve(n));
		}
	}

	private int solve(int n) {
		int count = 0;
		for (int i = 1; i <= n; ++i) {
			int number = i;
			while (number > 0) {
				if ((number & 1) == 1) ++count;
				number = number >> 1;
			}
		}
		return count;
	}
}
