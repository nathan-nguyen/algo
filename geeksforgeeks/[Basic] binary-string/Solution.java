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
			String s = in.next();
			int count = 0;
			for (int i = 0; i < n; ++i) {
				if (s.charAt(i) == '1') ++count;
			}
			System.out.println(count * (count - 1) / 2);
		}
	}
}
