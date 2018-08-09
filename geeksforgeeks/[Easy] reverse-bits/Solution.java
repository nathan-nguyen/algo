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
			long n = in.nextLong();
			long result = 0;
			for (int i = 0; i < 32; ++i) {
				if (((n >> i) & 1) == 0) continue;

				result |= (1L << (31 - i));
			}
			System.out.println(result);
		}
	}
}
