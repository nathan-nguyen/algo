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
			int[] arr = new int[n];
			for (int i = 0; i < n; ++i) arr[i] = in.nextInt();

			int count = 0;
			int max = 0;
			int total = 0;
			for (int i = 0; i < n; ++i) {
				int value = 1;
				if (arr[i] == 1) {
					++count;
					value = -1;
				}
				total = Math.max(value, total + value);
				max = Math.max(max, total);
			}

			System.out.println(count + max);
		}
	}
}
