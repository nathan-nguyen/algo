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
			int d = in.nextInt();
			int left = in.nextInt();
			int right = in.nextInt();

			int count = 0;
			for (int i = left + 1; i < right; ++i) {
				int number = i;
				while (number > 0) {
					if (number % 10 == d) ++count;
					number /= 10;
				}
			}
			System.out.println(count);
		}
	}
}
