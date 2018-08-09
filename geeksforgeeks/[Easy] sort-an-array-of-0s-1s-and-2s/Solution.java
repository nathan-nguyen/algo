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
			int[] count = new int[3];
			while (n -- > 0) ++count[in.nextInt()];
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 3; ++i) {
				while (count[i] -- > 0) {
					sb.append(i);
					sb.append(" ");
				}
			}
			System.out.println(sb.toString());
		}
	}
}
