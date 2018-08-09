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

			long total = 0;
			int count = 0;
			for (int i = 31; i >= 0; --i) {
				if (((n >> i) & 1) == 0) continue;
				++count;
				total += (1 << i) * (count - 1) + i * (1 << i) / 2;
			}
			total += count;
			System.out.println(total);
		}
	}
}
